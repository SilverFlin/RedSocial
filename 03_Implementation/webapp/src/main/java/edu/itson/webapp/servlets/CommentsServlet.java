package edu.itson.webapp.servlets;

import com.google.gson.Gson;
import edu.itson.dominio.Comentario;
import edu.itson.dominio.ContenidoComentario;
import edu.itson.dominio.Post;
import edu.itson.dominio.Usuario;
import edu.itson.webapp.business.impl.CommentBO;
import edu.itson.webapp.business.impl.PostBO;
import edu.itson.webapp.business.interfaces.ICommentBO;
import edu.itson.webapp.business.interfaces.IPostBO;
import edu.itson.webapp.exceptions.BusinessException;
import edu.itson.webapp.http.HttpStatusCode;
import static edu.itson.webapp.http.HttpStatusCode.BAD_REQUEST;
import static edu.itson.webapp.http.HttpStatusCode.UNAUTHORIZED;
import edu.itson.webapp.json.impl.CreateCommentJson;
import edu.itson.webapp.json.impl.JsonResponses;
import edu.itson.webapp.json.impl.ResponseJson;
import edu.itson.webapp.utils.impl.FormValidator;
import edu.itson.webapp.utils.interfaces.IFormValidator;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@WebServlet(name = "CommentsServlet", urlPatterns = {"/comments"})
public class CommentsServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(
            final HttpServletRequest request,
            final HttpServletResponse response
    )
            throws ServletException, IOException {
//        TODO
//        /comments?action=get-all&idPost=id
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param req servlet request
     * @param res servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(
            final HttpServletRequest req,
            final HttpServletResponse res
    )
            throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null || action.equalsIgnoreCase("create-comment")) {
            this.processCreateComment(req, res);
            return;
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void processCreateComment(
            final HttpServletRequest req,
            final HttpServletResponse res
    ) throws ServletException, IOException {
        ResponseJson<CreateCommentJson> responseJson = new ResponseJson<>();

        String contentParam = req.getParameter("content");
        String postIdParam = req.getParameter("postId");

        String formInJson = JsonConverter.getJsonFromRequest(req);
        Gson gson = new Gson();
        CreateCommentJson commentSubmission
                = gson.fromJson(formInJson, CreateCommentJson.class);
        String content = commentSubmission.getContent();
        String postId = commentSubmission.getPostId();

        Usuario loggedUser = (Usuario) req.getSession().getAttribute("user");

        if (loggedUser == null) {
            res.setStatus(UNAUTHORIZED.getCode());
            ResponseJson.doJsonResponse(
                    responseJson,
                    JsonResponses.STATUS_FAIL,
                    "User is null",
                    null,
                    res);
            return;
        }

        Comentario commentCreated;
        try {
            commentCreated
                    = this.tryCreatePost(contentParam, postIdParam, loggedUser);

            if (commentCreated == null) {
                commentCreated
                        = this.tryCreatePost(content, postId, loggedUser);
            }

        } catch (BusinessException ex) {
            res.setStatus(BAD_REQUEST.getCode());
            ResponseJson.doJsonResponse(
                    responseJson,
                    JsonResponses.STATUS_FAIL,
                    "Comment was not created",
                    null,
                    res);
            return;
        }

        if (commentCreated == null) {
            res.setStatus(BAD_REQUEST.getCode());
            ResponseJson.doJsonResponse(
                    responseJson,
                    JsonResponses.STATUS_FAIL,
                    "Comment is null",
                    null,
                    res);
            return;
        }

        res.setStatus(HttpStatusCode.CREATED.getCode());
        ResponseJson.doJsonResponse(
                responseJson,
                JsonResponses.STATUS_SUCCESS,
                "Comment was created",
                commentSubmission,
                res
        );
        return;
    }

    private boolean validateParams(final String content) {
        IFormValidator validator = new FormValidator();

        final int contentLimit = 150;
        return !validator.hasBlankSpaces(content)
                && !validator.hasExceededLengthLimit(content, contentLimit);

    }

    private Comentario tryCreatePost(
            final String content,
            final String postId,
            final Usuario user
    ) throws BusinessException {

        if (content == null || postId == null) {
            return null;
        }

        if (!this.validateParams(content)) {
            return null;
        }

        IPostBO postBO = new PostBO();
        Post post = postBO.getPostById(postId);

        Comentario commentCreated = new Comentario();
        ContenidoComentario contenidoComentario = new ContenidoComentario();
        contenidoComentario.setTexto(content);
        commentCreated.setContenido(contenidoComentario);
        commentCreated.setCreador(user);
        commentCreated.setObjetivo(post);
        commentCreated.setFechaHoraCreacion(LocalDateTime.now());

        ICommentBO commentBO = new CommentBO();
        return commentBO.createComment(commentCreated, post);
    }

}
