package edu.itson.pruebapersistencia;

import edu.itson.dominio.ContenidoPost;
import edu.itson.dominio.NombreCompleto;
import edu.itson.dominio.Post;
import edu.itson.dominio.TipoPost;
import interfaces.IPostsDAO;
import java.time.LocalDateTime;
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

    private static void probarPostsDao() throws PersistenciaException {
        // TODO
        IPostsDAO postdao = DAOFactory.getPostsDAO();
        Post post = new Post(TipoPost.NORMAL);
        LocalDateTime date = LocalDateTime.now();
        post.setFechaHoraCreacion(date);
        post.setTitulo("Segundo Post");
        Usuario creador = new Usuario();
        NombreCompleto nombre = new NombreCompleto();
        nombre.setNombres("Adrian");
        ContenidoPost contenido = new ContenidoPost();
        contenido.setTexto("Hola me llamo Gerardo");
        post.setContenido(contenido);
        nombre.setApellidoPaterno("Abriles");
        nombre.setApellidoMaterno("Chavez");
        creador.setNombreCompleto(nombre);
        post.setCreador(creador);

        /*
         * Prueba agregar
         */
//        postdao.agregar(post);
//        System.out.println("Prueba agregar");

        /*
         * Prueba busqueda por ID
         */
        Post post2 = postdao.buscarPorId("6488afafd93a496465dc4e82");
        System.out.println("Prueba Busqueda por ID:");
        System.out.println("Titulo: " + post2.getTitulo() + " // Contenido: ");

        /*
         *   Prueba busqueda de todos
         */
        List<Post> lista = postdao.buscarTodos();
        System.out.println("Prueba busqueda de TODOS:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + ".- " + lista.get(i).getTitulo());

        }

        /*
         * Prueba Actulizacion
         */
        Post postNew = postdao.buscarPorId("6488afafd93a496465dc4e82");
        System.out.println(postNew);
        postNew.setTitulo("Hola");
        System.out.println("Prueba actualiza");
        postdao.actualizar(postNew);
        System.out.println("Listo");

        /*
         * Prueba Eliminar
         */
        System.out.println("Prueba Elimina");
        // postdao.eliminar(postdao.buscarID("6488dcb2d394bd15f8aae77b"));

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
