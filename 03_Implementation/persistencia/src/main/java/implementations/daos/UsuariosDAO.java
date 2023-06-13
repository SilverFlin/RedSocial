package implementations.daos;

import com.mongodb.client.MongoCollection;
import edu.itson.dominio.Usuario;
import implementations.db.Connection;
import java.util.List;
import interfaces.IUsuariosDAO;

/**
 *
 */
public class UsuariosDAO implements IUsuariosDAO {

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
    public Usuario agregar(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Usuario eliminar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Usuario actualizar(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Usuario buscarPorId(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Usuario> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
