package edu.itson.webapp.servlets;

import edu.itson.dominio.PostContent;
import edu.itson.dominio.Post;
import edu.itson.dominio.PostType;
import edu.itson.dominio.User;
import edu.itson.webapp.business.impl.PostsBO;
import edu.itson.webapp.business.interfaces.IPostBO;
import edu.itson.webapp.exceptions.BusinessException;
import edu.itson.webapp.http.HttpStatusCode;
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
    )
            throws ServletException, IOException {
        String titleParam = req.getParameter("title");
        String contentParam = req.getParameter("content");
        // TODO Image File

        if (!this.validateParams(titleParam, contentParam)) {
            this.sendToHttpErrorPage(req, res, HttpStatusCode.BAD_REQUEST);
            return;
        }

        User loggedUser = (User) req.getSession().getAttribute("user");

        if (loggedUser == null) {
            this.sendToHttpErrorPage(req, res, HttpStatusCode.UNAUTHORIZED);
            return;
        }

        Post postCreated;
        try {
            postCreated
                    = this.tryCreatePost(titleParam, contentParam, loggedUser);
        } catch (BusinessException ex) {
            this.sendToServerErrorPage(req, res);
            return;
        }

        if (postCreated == null) {
            this.sendToHttpErrorPage(req, res, HttpStatusCode.BAD_REQUEST);
            return;
        }

        this.redirectHome(req, res);
    }

    private boolean validateParams(final String title, final String content) {
        IFormValidator validator = new FormValidator();

        final int titleLimit = 15;
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
            final String titleParam,
            final String contentParam,
            final User user
    ) throws BusinessException {
        Post postCreated = new Post(PostType.NORMAL);
        postCreated.setTitulo(titleParam);
        PostContent contenidoPost = new PostContent();
        contenidoPost.setTexto(contentParam);
        postCreated.setContenido(contenidoPost);
        postCreated.setCreador(user);
        postCreated.setFechaHoraCreacion(LocalDateTime.now());
        IPostBO postBO = new PostsBO();
        return postBO.createPost(postCreated);
    }

    private void sendToHttpErrorPage(
            final HttpServletRequest req,
            final HttpServletResponse res,
            final HttpStatusCode httpStatusCode
    ) throws ServletException, IOException {
        res.setStatus(httpStatusCode.getCode());
        getServletContext()
                .getRequestDispatcher(Constants.HTTP_ERROR_PAGE)
                .forward(req, res);
    }

    private void sendToServerErrorPage(
            final HttpServletRequest req,
            final HttpServletResponse res
    ) throws ServletException, IOException {
        res.setStatus(HttpStatusCode.INTERNAL_SERVER_ERROR.getCode());
        getServletContext()
                .getRequestDispatcher(Constants.SERVER_ERROR_PAGE)
                .forward(req, res);
    }

    private void redirectHome(
            final HttpServletRequest req,
            final HttpServletResponse res
    ) throws IOException {
        res.setStatus(HttpStatusCode.OK.getCode());
        res.sendRedirect(req.getContextPath() + Constants.HOME_ENDPOINT);
    }

}
