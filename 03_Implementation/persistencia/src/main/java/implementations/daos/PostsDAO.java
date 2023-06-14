package implementations.daos;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import edu.itson.dominio.Post;
import exceptions.PersistenciaException;
import implementations.db.Connection;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import interfaces.IPostsDAO;

/**
 *
 */
public final class PostsDAO implements IPostsDAO {

    /**
     * Collección con la que el DAO interactúa.
     */
    private final MongoCollection<Post> collection;
    /**
     * Instancia de esta clase.
     */
    private static PostsDAO postsDAO;

    /**
     * Constructor que inicializa la colección.
     */
    public PostsDAO() {
        this.collection
                = Connection
                        .getDb()
                        .getCollection("posts", Post.class);

    }

    /**
     * Método que regresa una instancia de la clase. Usa el patrón Singleton.
     *
     * @return instancia de la clase.
     */
    public static PostsDAO getInstance() {
        if (PostsDAO.postsDAO == null) {
            PostsDAO.postsDAO = new PostsDAO();
        }
        return PostsDAO.postsDAO;
    }

    @Override
    public Post agregar(final Post post) throws PersistenciaException {
        try {
            if (post != null) {

                this.collection.insertOne(post);
            }
        } catch (MongoException ex) {
            String msg = "No se pudo agregar el post" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
        return post;
    }

    @Override
    public Post eliminar(final Post post) throws PersistenciaException {
        try {
            Document filtros = new Document();
            filtros.append("_id", post.getId());
            this.collection.deleteOne(filtros);
        } catch (MongoException ex) {
            String msg = "No se pudo eliminar el post" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
        return post;
    }

    @Override
    public Post actualizar(final Post post) throws PersistenciaException {
        try {
            Document filtroActualizacion = new Document("_id", post.getId());
            Document cambiosARealizar = new Document();
            cambiosARealizar.append("$set", new Document()
                    .append("contenido", post.getContenido())
                    .append("creador", post.getCreador())
                    .append("fechaHoraCreacion", post.getFechaHoraCreacion())
                    .append("tipopost", post.getTipoPost())
                    .append("titulo", post.getTitulo()));
            return post;
        } catch (MongoException ex) {
            String msg = "No se pudo actualizar el post" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
    }

    @Override
    public Post buscarPorId(final String id) throws PersistenciaException {

        Post exPost = null;
        try {
            Document filtros = new Document();
            filtros.append("id", id);
            FindIterable<Post> comentarios = this.collection.find(filtros);
            exPost = comentarios.first();
            return exPost;
        } catch (MongoException ex) {
            String msg = "No se pudo buscar el post" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
    }

    @Override
    public List<Post> buscarTodos() throws PersistenciaException {
        List<Post> listaPosts;
        try {
            listaPosts = new LinkedList<>();
            return this.collection.find().into(listaPosts);
        } catch (Exception ex) {
            String msg = "No se pudo buscar los posts" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
    }

}
