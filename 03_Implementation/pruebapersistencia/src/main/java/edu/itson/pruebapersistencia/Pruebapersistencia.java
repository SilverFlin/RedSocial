package edu.itson.pruebapersistencia;

import edu.itson.dominio.Comentario;
import edu.itson.persistencia.implementaciones.ComentariosDAO;
import edu.itson.persistencia.implementaciones.UsuariosDAO;
import implementaciones.ConectionDB;
import interfaces.IConectionDB;
import edu.itson.dominio.*;
import interfaces.Comentable;
import java.time.LocalDateTime;
import java.util.List;
import org.bson.codecs.jsr310.LocalDateTimeCodec;
import org.bson.types.ObjectId;

/**
 *
 */
public class Pruebapersistencia {

    public static void main(String[] args) {
        probarDaos();
    }

    private static void probarComentariosDao() {
        // TODO
        final IConectionDB connectionDB = new ConectionDB();
        ComentariosDAO comentariosDAO = new ComentariosDAO(connectionDB);

//        Comentario newComentario = new Comentario();
//        ContenidoComentario contenido = new ContenidoComentario();
//        newComentario.setContenido(contenido);
//        Usuario nuevoUsuario = new Usuario();
//        NombreCompleto nC = new NombreCompleto("Arturo", "Luna", "Ruelas");
//        nuevoUsuario.setNombreCompleto(nC);
//        newComentario.setUsuario(nuevoUsuario);
//        comentariosDAO.agregar(newComentario);
//        System.out.println(comentariosDAO.buscarID("6487fca8130b0abe43ee3aad"));
//        Comentario comentarioActualizar = new Comentario();
//        Usuario usuario = new Usuario();
//                usuario.setId(new ObjectId("6487fca8130b0abe43ee3aad"));
//                usuario.setNombreCompleto(new NombreCompleto("Juan", "Luna", "Ruelas"));
//        comentarioActualizar.setUsuario(usuario);
//        ContenidoComentario cont = new ContenidoComentario();
//        cont.setTexto("Hola"); 
//        comentarioActualizar.setContenido(cont);
//        comentariosDAO.actualizar(comentarioActualizar);
//        List<Comentario> listaComentario = comentariosDAO.buscarTodos();
//        for (int i = 0; i < listaComentario.size(); i++) {
//            System.out.println(listaComentario.get(i).getUsuario().getNombreCompleto());
//        }
//        Comentario comentario = comentariosDAO.buscarID("6487fca8130b0abe43ee3aad");
//        System.out.println("---------------------");
//        if (comentario == null) {
//            System.out.println("no jala");
//        }else{
//            System.out.println("si jala" +comentario);
//        }
//        Comentario comentario = new Comentario();
//        ContenidoComentario contenido = new ContenidoComentario();
//        contenido.setTexto("Contenido con texto");
//        comentario.setContenido(contenido);
//        LocalDateTime time = LocalDateTime.now();
//        comentario.setFechaHoraCreacion(time);
//        Usuario usuario = new Usuario();
//        NombreCompleto nombreCompleto = new NombreCompleto("Luis", "Ruiz", "Acuña");
//        usuario.setNombreCompleto(nombreCompleto);
//        comentario.setUsuario(usuario);
//        comentariosDAO.agregar(comentario);
        comentariosDAO.buscarID("");
    }

    private static void probarPostsDao() {
        // TODO

    }

    private static void probarUsuariosDao() {
        // TODO
    }

    private static void probarDaos() {
        probarComentariosDao();
//        probarPostsDao();
//        probarUsuariosDao();
    }
}
