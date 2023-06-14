package implementations.daos;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import edu.itson.dominio.Post;
import exceptions.PersistenciaException;
import implementations.db.Connection;
import java.util.List;
import org.bson.Document;
import interfaces.IPostsDAO;
import java.util.ArrayList;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

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
            Bson filter = new Document("_id", post.getId());
            this.collection.replaceOne(filter, post);
            return post;
        } catch (MongoException ex) {
            String msg = "No se pudo actualizar el post" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
    }

    @Override
    public Post buscarPorId(final String id) throws PersistenciaException {

        try {
            return this.collection
                    .find(new Document("_id", new ObjectId(id)))
                    .first();
        } catch (MongoException ex) {
            String msg = "No se pudo buscar el post" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
    }

    @Override
    public List<Post> buscarTodos() throws PersistenciaException {

        try {
            MongoCursor<Post> resultadoConsulta
                    = this.collection
                            .find()
                            .iterator();
            List<Post> listaP = new ArrayList<>();
            while (resultadoConsulta.hasNext()) {
                listaP.add(resultadoConsulta.next());
            }
            return listaP;
        } catch (Exception ex) {
            String msg = "No se pudo buscar los posts" + ex.getMessage();
            throw new PersistenciaException(msg);
        }
    }

}
