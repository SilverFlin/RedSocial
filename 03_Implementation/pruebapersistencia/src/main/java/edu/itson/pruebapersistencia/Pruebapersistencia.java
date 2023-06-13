package edu.itson.pruebapersistencia;

import edu.itson.dominio.NombreCompleto;
import edu.itson.dominio.Post;
import edu.itson.dominio.TipoPost;
import edu.itson.dominio.Usuario;
import edu.itson.persistencia.implementaciones.PostsDAO;
import implementaciones.ConectionDB;
import interfaces.IConectionDB;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.bson.codecs.jsr310.LocalDateTimeCodec;

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
        post.setTitulo("PEDO");
        Usuario creador = new Usuario();
        NombreCompleto nombre = new NombreCompleto();
        nombre.setNombres("Juan");
        nombre.setApellidoPaterno("Lopez");
        nombre.setApellidoMaterno("Estrada");
        creador.setNombreCompleto(nombre);
        post.setCreador(creador);
        
       // String hexString = "6488afafd93a496465dc4e82";
       
        // postdao.agregar(post);
       
       
        Post post2 = postdao.buscarID("6488cf9a290c624030c4cc96");
        System.out.println("------------------------------");
        if (post2 == null) {
            System.out.println("no jala");
        }else{
           System.out.println(post2.getTitulo());
        System.out.println("------------------------------");
        }
         List<Post> lista = postdao.buscarTodos();
         for (int i = 0; i < lista.size(); i++) {
             System.out.println(lista.get(i).getTitulo()); 
          
        }
        
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