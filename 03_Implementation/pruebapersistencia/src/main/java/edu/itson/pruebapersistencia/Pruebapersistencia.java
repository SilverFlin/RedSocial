package edu.itson.pruebapersistencia;

import edu.itson.dominio.ContenidoPost;
import edu.itson.dominio.NombreCompleto;
import edu.itson.dominio.Post;
import edu.itson.dominio.TipoPost;
import edu.itson.dominio.Usuario;
import edu.itson.persistencia.implementaciones.PostsDAO;
import implementaciones.ConectionDB;
import interfaces.IConectionDB;
import java.time.LocalDateTime;
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
        IConectionDB conexion = new ConectionDB();
        PostsDAO postdao = new PostsDAO(conexion);
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
//         postdao.agregar(post);
//        System.out.println("Prueba agregar");   

        /*
         * Prueba busqueda por ID
         */
        Post post2 = postdao.buscarID("6488afafd93a496465dc4e82");
        System.out.println("Prueba Busqueda por ID:");
        System.out.println("Titulo: " + post2.getTitulo() + " // Contenido: " );

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
        
        Post postNew = postdao.buscarID("6488afafd93a496465dc4e82");
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

    private static void probarUsuariosDao() {
        // TODO
    }

    private static void probarDaos() {
        probarComentariosDao();
        probarPostsDao();
        probarUsuariosDao();
    }
}
