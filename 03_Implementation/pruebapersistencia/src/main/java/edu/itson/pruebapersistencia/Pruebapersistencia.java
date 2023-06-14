package edu.itson.pruebapersistencia;

import exceptions.PersistenciaException;
import implementations.db.DAOFactory;
import interfaces.IComentariosDAO;

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

    private static void probarComentariosDao() throws PersistenciaException {
        // TODO
        IComentariosDAO comentariosDAO = DAOFactory.getComentariosDAO();

//        Comentario newComentario = new Comentario();
//        ContenidoComentario contenido = new ContenidoComentario();
//        newComentario.setContenido(contenido);
//        Usuario nuevoUsuario = new Usuario();
//        NombreCompleto nC = new NombreCompleto("Arturo", "Luna", "Ruelas");
//        nuevoUsuario.setNombreCompleto(nC);
//        newComentario.setUsuario(nuevoUsuario);
//        comentariosDAO.agregar(newComentario);
//      System.out.println(comentariosDAO.buscarID("6487fca8130b0abe43ee3aad"));
//        Comentario comentarioActualizar = new Comentario();
//        Usuario usuario = new Usuario();
//                usuario.setId(new ObjectId("6487fca8130b0abe43ee3aad"));
//      usuario.setNombreCompleto(new NombreCompleto("Juan", "Luna", "Ruelas"));
//        comentarioActualizar.setUsuario(usuario);
//        ContenidoComentario cont = new ContenidoComentario();
//        cont.setTexto("Hola");
//        comentarioActualizar.setContenido(cont);
//        comentariosDAO.actualizar(comentarioActualizar);
//        List<Comentario> listaComentario = comentariosDAO.buscarTodos();
//        for (int i = 0; i < listaComentario.size(); i++) {
//  System.out.println(listaComentario.get(i).getUsuario().getNombreCompleto());
//        }
//  Comentario comentario = comentariosDAO.buscarID("6487fca8130b0abe43ee3aad");
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
//  NombreCompleto nombreCompleto = new NombreCompleto("Luis", "Ruiz", "Acuña");
//        usuario.setNombreCompleto(nombreCompleto);
//        comentario.setUsuario(usuario);
//        Comentario comentario2 = comentariosDAO.agregar(comentario);
//        System.out.println(comentario2.getId());
    }

    private static void probarPostsDao() {
        // TODO

    }

    private static void probarUsuariosDao() {
        // TODO
    }

    private static void probarDaos() {
        try {
            probarComentariosDao();
//        probarPostsDao();
//        probarUsuariosDao();
        } catch (PersistenciaException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
