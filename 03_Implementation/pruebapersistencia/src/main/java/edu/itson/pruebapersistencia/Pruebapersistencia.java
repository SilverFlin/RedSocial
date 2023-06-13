package edu.itson.pruebapersistencia;

import edu.itson.dominio.Imagen;
import edu.itson.dominio.NombreCompleto;
import edu.itson.dominio.Usuario;
import edu.itson.persistencia.implementaciones.UsuariosDAO;
import implementaciones.ConectionDB;
import interfaces.IConectionDB;
import java.util.List;

/**
 *
 */
public class Pruebapersistencia {

    public static void main(String[] args) {
        probarDaos();
    }

    private static void probarComentariosDao() {
        // TODO
    }

    private static void probarPostsDao() {
        // TODO
    }

    private static void probarUsuariosDao() {
        // TODO
        final IConectionDB connectionDB = new ConectionDB();
        UsuariosDAO usuarioDAO = new UsuariosDAO(connectionDB);
        Usuario u = new Usuario();
        NombreCompleto nc = new NombreCompleto("Martin", "Cibrian", "Reynoso");
        u.setNombreCompleto(nc);
        System.out.println("----");
        
        List<Usuario>usuarios = usuarioDAO.buscarTodos();
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i).getNombreCompleto().getNombres());
        }
        
        System.out.println(usuarioDAO.buscarID("6487fa267c073f098b48c3a0").getNombreCompleto().getNombres());
        //usuarioDAO.agregar(u);
        

    }

    private static void probarDaos() {
        probarComentariosDao();
        probarPostsDao();
        probarUsuariosDao();
    }
}
