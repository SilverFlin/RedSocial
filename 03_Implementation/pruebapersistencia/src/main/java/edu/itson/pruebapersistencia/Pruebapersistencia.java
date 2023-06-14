package edu.itson.pruebapersistencia;

import edu.itson.dominio.Usuario;
import exceptions.PersistenciaException;
import implementations.db.DAOFactory;
import interfaces.IUsuariosDAO;

import java.util.List;

/**
 *
 */
public final class Pruebapersistencia {

    private Pruebapersistencia() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Método principal.
     *
     * @param args
     */
    public static void main(final String[] args) {
        probarDaos();
    }

    private static void probarComentariosDao() {
        // TODO
    }

    private static void probarPostsDao() {
        // TODO
    }

    private static void probarUsuariosDao() throws PersistenciaException {
        // TODO
        IUsuariosDAO usuarioDAO = DAOFactory.getUsuariosDAO();
        // Obtener el usuario que deseas actualizar
        Usuario usuario = usuarioDAO.buscarPorId("6487f995d81edf3a35dca04d");

// Realizar las modificaciones necesarias en el objeto Usuario
        usuario.getNombreCompleto().setNombres("Maradona");
        usuario.getNombreCompleto().setApellidoPaterno("xd");
        usuario.getNombreCompleto().setApellidoMaterno("xd");

// Llamar al método actualizar pasando el objeto Usuario modificado
        usuarioDAO.eliminar(usuario);

        List<Usuario> usuarios = usuarioDAO.buscarTodos();
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i).getNombreCompleto()
                    .getNombres());
        }

//        System.out.println(usuarioDAO.buscarID("6487fa267c073f098b48c3a0")
//.getNombreCompleto().getNombres());
    }

    private static void probarDaos() {
        try {
            probarComentariosDao();
            probarPostsDao();
            probarUsuariosDao();
        } catch (PersistenciaException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
