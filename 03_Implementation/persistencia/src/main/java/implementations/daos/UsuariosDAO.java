package implementations.daos;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import edu.itson.dominio.Usuario;
import exceptions.PersistenciaException;
import implementations.db.Connection;
import java.util.List;
import interfaces.IUsuariosDAO;
import java.util.LinkedList;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 */
public final class UsuariosDAO implements IUsuariosDAO {

    /**
     * Collección con la que el DAO interactúa.
     */
    private final MongoCollection<Usuario> collection;

    /**
     * Instancia de esta clase.
     */
    private static UsuariosDAO usuariosDAO;

    /**
     * Constructor que inicializa la colección.
     */
    public UsuariosDAO() {
        this.collection
                = Connection
                        .getDb()
                        .getCollection("usuarios", Usuario.class);
    }

    /**
     * Método que regresa una instancia de la clase. Usa el patrón Singleton.
     *
     * @return instancia de la clase.
     */
    public static UsuariosDAO getInstance() {
        if (UsuariosDAO.usuariosDAO == null) {
            UsuariosDAO.usuariosDAO = new UsuariosDAO();
        }
        return UsuariosDAO.usuariosDAO;
    }

    @Override
    public Usuario agregar(final Usuario usuario) throws PersistenciaException {
        try {
            if (usuario != null) {
                this.collection.insertOne(usuario);
                return usuario;
            }
        } catch (MongoException ex) {
            String msg = "No se pudo agregar el usuario" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
        return null;
    }

    @Override
    public Usuario eliminar(
            final Usuario usuario
    ) throws PersistenciaException {
        try {
            Document filtros = new Document("_id", usuario.getId());
            this.collection.deleteOne(filtros);
        } catch (MongoException ex) {
            String msg = "No se pudo eliminar el usuario" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
        return usuario;
    }

    @Override
    public Usuario actualizar(
            final Usuario usuario
    ) throws PersistenciaException {
        try {
            Bson filter = new Document("_id", usuario.getId());
            this.collection.replaceOne(filter, usuario);
            return usuario;
        } catch (MongoException ex) {
            String msg = "No se pudo actualizar el usuario" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
    }

    @Override
    public Usuario buscarPorId(final String id) throws PersistenciaException {
        return this.buscarPor("_id", id);
    }

    @Override
    public List<Usuario> buscarTodos() throws PersistenciaException {
        List<Usuario> usuarios;
        try {
            usuarios = new LinkedList<>();
            return this.collection.find().into(usuarios);
        } catch (MongoException ex) {
            String msg = "No se pudo buscar el usuario" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
    }

    @Override
    public Usuario buscarPorEmail(
            final String email
    ) throws PersistenciaException {
        return buscarPor("email", email);
    }

    private Usuario buscarPor(
            final String param,
            final String value
    ) throws PersistenciaException {

        Usuario usuario = null;
        try {
            Document filtros = new Document();
            if (param.equals("_id")) {
                ObjectId objectId = new ObjectId(value);
                filtros.append(param, objectId);
            } else {
                filtros.append(param, value);
            }
            FindIterable<Usuario> usuarios = this.collection.find(filtros);
            usuario = usuarios.first();
        } catch (MongoException ex) {
            String msg = "No se pudo encontrar el usuario" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
        return usuario;
    }

}
