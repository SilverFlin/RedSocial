package implementations.daos;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import edu.itson.dominio.NombreCompleto;
import edu.itson.dominio.Usuario;
import exceptions.PersistenciaException;
import implementations.db.Connection;
import java.util.List;
import interfaces.IUsuariosDAO;
import java.util.LinkedList;
import org.bson.Document;
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
        ObjectId id = usuario.getId();
        try {
            Document filtro = new Document("_id", id);
            DeleteResult dr = this.collection.deleteOne(filtro);
            return usuario;
        } catch (MongoException ex) {
            String msg = "No se pudo eliminar el usuario" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
    }

    @Override
    public Usuario actualizar(
            final Usuario usuario
    ) throws PersistenciaException {
        try {
            Document filtroActualizacion = new Document("_id", usuario.getId());
            Document cambiosARealizar = new Document();
            NombreCompleto nCompleto = usuario.getNombreCompleto();
            cambiosARealizar.append("$set", new Document()
                    .append("nombres", nCompleto.getNombres())
                    .append("apellidoPaternos", nCompleto.getApellidoPaterno())
                    .append("apellidoMaterno", nCompleto.getApellidoMaterno()));
//                    .append("password", usuario.getPassword())
//                    .append("telefono", usuario.getTelefono())
//                    .append("avatar", new Document()
//                    .append("nombreImagen", usuario.getAvatar().getFileName())
//                    .append("data", usuario.getAvatar().getImageData()))
//                    .append("fechaNacimiento", usuario.getFechaNacimiento())
//                    .append("genero", usuario.getGenero())
//                    .append("direccion", new Document()
//                    .append("ciudad", usuario.getDireccion().getCiudad())
//                   .append("municipio", usuario.getDireccion().getMunicipio())
//                    .append("estado", usuario.getDireccion().getEstado()))
//                    .append("tipoUsuario", usuario.getTipoUsuario());
            this.collection.updateOne(filtroActualizacion, cambiosARealizar);
        } catch (MongoException ex) {
            String msg = "No se pudo actualizar el usuario" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
        return usuario;
    }

    @Override
    public Usuario buscarPorId(final String id) throws PersistenciaException {
        Usuario usuario;
        try {
            ObjectId objectId = new ObjectId(id);

            Document filtros = new Document();
            filtros.append("_id", objectId);
            FindIterable<Usuario> usuarios = this.collection.find(filtros);
            usuario = usuarios.first();
            return usuario;
        } catch (MongoException ex) {
            String msg = "No se pudo buscar el usuario" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
    }

    @Override
    public List<Usuario> buscarTodos() throws PersistenciaException {
        List<Usuario> usuarios = null;
        try {
            usuarios = new LinkedList<>();
            return this.collection.find().into(usuarios);
        } catch (MongoException ex) {
            String msg = "No se pudo buscar el usuario" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
    }

}
