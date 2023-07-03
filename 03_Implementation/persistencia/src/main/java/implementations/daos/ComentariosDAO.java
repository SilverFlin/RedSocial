package implementations.daos;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import edu.itson.dominio.Comment;
import exceptions.PersistenciaException;
import implementations.db.Connection;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import interfaces.IComentariosDAO;

/**
 *
 */
public final class ComentariosDAO implements IComentariosDAO {

    /**
     * Collección con la que el DAO interactúa.
     */
    private final MongoCollection<Comment> collection;

    /**
     * Instancia de esta clase.
     */
    private static ComentariosDAO comentariosDAO;

    /**
     * Constructor que inicializa la colección.
     */
    public ComentariosDAO() {
        this.collection
                = Connection
                        .getDb()
                        .getCollection("comentarios", Comment.class);
    }

    /**
     * Método que regresa una instancia de la clase. Usa el patrón Singleton.
     *
     * @return instancia de la clase.
     */
    public static ComentariosDAO getInstance() {
        if (ComentariosDAO.comentariosDAO == null) {
            ComentariosDAO.comentariosDAO = new ComentariosDAO();
        }
        return ComentariosDAO.comentariosDAO;
    }

    @Override
    public Comment agregar(
            final Comment comentario
    ) throws PersistenciaException {

        try {
            this.collection.insertOne(comentario);
        } catch (MongoException ex) {
            String msg = "No se pudo agregar el comentario" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
        return comentario;
    }

    @Override
    public Comment eliminar(
            final Comment comentario
    ) throws PersistenciaException {

        try {
            Document filtros = new Document();
            filtros.append("_id", comentario.getId());
            this.collection.deleteOne(filtros);
        } catch (MongoException ex) {
            String msg = "No se pudo eliminar el comentario" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
        return comentario;
    }

    @Override
    public Comment actualizar(
            final Comment comentario
    ) throws PersistenciaException {

        try {
            Document filtroActualizacion
                    = new Document("_id", comentario.getId());
            Document cambiosARealizar = new Document();
            cambiosARealizar.append("$set", new Document()
                    .append("usuario", comentario.getUsuario())
                    .append("objetivo", comentario.getObjetivo())
                    .append(
                            "fechaHoraCreacion",
                            comentario.getFechaHoraCreacion()
                    )
                    .append("contenido", comentario.getContenido()));
            this.collection.updateOne(filtroActualizacion, cambiosARealizar);
        } catch (MongoException ex) {
            String msg = "No se pudo actualizar comentario" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
        return comentario;
    }

    @Override
    public Comment buscarPorId(
            final String id
    ) throws PersistenciaException {
        Comment comentario;
        try {
            Document filtros = new Document();
            filtros.append("_id", id);
            FindIterable<Comment> comentarios
                    = this.collection.find(filtros);
            comentario = comentarios.first();
            return comentario;
        } catch (MongoException ex) {
            String msg = "No se pudo buscar el comentario" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
    }

    @Override
    public List<Comment> buscarTodos() throws PersistenciaException {
        List<Comment> listacomentario;
        try {
            listacomentario = new LinkedList<>();
            return this.collection.find().into(listacomentario);
        } catch (MongoException ex) {
            String msg = "No se pudo buscar los comentarios" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
    }

}
