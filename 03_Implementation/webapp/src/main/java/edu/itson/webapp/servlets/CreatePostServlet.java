package edu.itson.webapp.servlets;

import com.google.gson.Gson;
import edu.itson.dominio.ContenidoPost;
import edu.itson.dominio.Post;
import edu.itson.dominio.TipoPost;
import edu.itson.dominio.Usuario;
import edu.itson.webapp.business.impl.PostBO;
import edu.itson.webapp.business.interfaces.IPostBO;
import edu.itson.webapp.exceptions.BusinessException;
import static edu.itson.webapp.http.HttpStatusCode.BAD_REQUEST;
import static edu.itson.webapp.http.HttpStatusCode.CREATED;
import edu.itson.webapp.json.impl.CreatePostJson;
import edu.itson.webapp.json.impl.JsonResponses;
import edu.itson.webapp.json.impl.ResponseJson;
import edu.itson.webapp.paths.Constants;
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
@WebServlet(name = "CreatePostServlet", urlPatterns = {"/create-post"})
public class CreatePostServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param req servlet request
     * @param res servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(
            final HttpServletRequest req,
            final HttpServletResponse res
    )
            throws ServletException, IOException {
        String action = req.getParameter("action");

        /* Default Action */
        if (action == null || action.equalsIgnoreCase("create-post")) {
            this.sendToCreatePostPage(req, res);
            return;
        }
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

        if (action == null || action.equalsIgnoreCase("create-post")) {
            this.processCreatePost(req, res);
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

    private void sendToCreatePostPage(
            final HttpServletRequest req,
            final HttpServletResponse res
    )
            throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(Constants.CREATE_POST_PAGE)
                .forward(req, res);
    }

    private void processCreatePost(
            final HttpServletRequest req,
            final HttpServletResponse res
    ) throws ServletException, IOException {

        // TODO Separate tryWithParams / tryWithJson
        ResponseJson<CreatePostJson> responseJson = new ResponseJson<>();

        String titleParam = req.getParameter("title");
        String contentParam = req.getParameter("content");
        boolean isAnchoredParam
                = req.getParameter("type") != null
                && req.getParameter("type").equals("true");

        String formInJson = JsonConverter.getJsonFromRequest(req);
        Gson gson = new Gson();
        CreatePostJson postSubmission
                = gson.fromJson(formInJson, CreatePostJson.class);
        String title = null;
        String content = null;
        boolean isAnchored = false;
        if (postSubmission != null) {
            title = postSubmission.getTitle();
            content = postSubmission.getContent();
            isAnchored = postSubmission.getIsAnchored();
        }

        Usuario user = (Usuario) req.getSession().getAttribute("user");

        if (user == null) {
            res.setStatus(BAD_REQUEST.getCode());
            ResponseJson.doJsonResponse(
                    responseJson,
                    JsonResponses.STATUS_FAIL,
                    "User is null",
                    null,
                    res);
            return;

        }

        Post postCreated;
        try {
            postCreated = this.tryCreatePost(titleParam, contentParam, isAnchoredParam, user);

            if (postCreated == null) {
                postCreated = this.tryCreatePost(title, content, isAnchored, user);
            }

        } catch (BusinessException ex) {
            res.setStatus(BAD_REQUEST.getCode());
            ResponseJson.doJsonResponse(
                    responseJson,
                    JsonResponses.STATUS_ERROR,
                    "Post was not created: " + ex.getMessage(),
                    null,
                    res);
            return;
        }

        if (postCreated == null) {
            res.setStatus(BAD_REQUEST.getCode());
            ResponseJson.doJsonResponse(
                    responseJson,
                    JsonResponses.STATUS_FAIL,
                    "Post is null",
                    null,
                    res
            );
            return;
        }

        res.setStatus(CREATED.getCode());
        ResponseJson.doJsonResponse(
                responseJson,
                JsonResponses.STATUS_SUCCESS,
                "Post was created",
                postSubmission,
                res
        );
        return;

    }

    private boolean validateParams(final String title, final String content) {
        IFormValidator validator = new FormValidator();

        final int titleLimit = 20;
        boolean isValidTitle
                = !validator.hasBlankSpaces(title)
                && !validator.hasExceededLengthLimit(title, titleLimit);

        final int contentLimit = 500;
        boolean isValidContent
                = !validator.hasBlankSpaces(content)
                && !validator.hasExceededLengthLimit(content, contentLimit);

        return isValidTitle && isValidContent;
    }

    private Post tryCreatePost(
            final String title,
            final String content,
            final boolean isAnchored,
            final Usuario user
    ) throws BusinessException {

        if (title == null || content == null || user == null) {
            return null;
        }

        if (!this.validateParams(title, content)) {
            return null;
        }

        Post postCreated
                = new Post(isAnchored ? TipoPost.ANCLADO : TipoPost.NORMAL);
        postCreated.setTitulo(title);
        ContenidoPost contenidoPost = new ContenidoPost();
        contenidoPost.setTexto(content);
        postCreated.setContenido(contenidoPost);
        postCreated.setCreador(user);
        postCreated.setFechaHoraCreacion(LocalDateTime.now());
        IPostBO postBO = new PostBO();
        return postBO.createPost(postCreated);
    }

}
