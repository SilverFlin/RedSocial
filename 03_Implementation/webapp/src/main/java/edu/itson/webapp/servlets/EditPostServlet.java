package edu.itson.webapp.servlets;

import edu.itson.dominio.ContenidoPost;
import edu.itson.dominio.Post;
import edu.itson.dominio.Usuario;
import edu.itson.webapp.business.impl.PostBO;
import edu.itson.webapp.business.interfaces.IPostBO;
import edu.itson.webapp.exceptions.BusinessException;
import edu.itson.webapp.http.HttpStatusCode;
import static edu.itson.webapp.http.HttpStatusCode.BAD_REQUEST;
import static edu.itson.webapp.http.HttpStatusCode.NOT_FOUND;
import static edu.itson.webapp.http.HttpStatusCode.UNAUTHORIZED;
import edu.itson.webapp.paths.Constants;
import static edu.itson.webapp.servlets.Redirect.redirectHome;
import static edu.itson.webapp.servlets.Redirect.sendToHttpErrorPage;
import static edu.itson.webapp.servlets.Redirect.sendToServerErrorPage;
import edu.itson.webapp.utils.impl.FormValidator;
import edu.itson.webapp.utils.interfaces.IFormValidator;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Toled
 */
@WebServlet(name = "EditPostServlet", urlPatterns = {"/edit-post"})
public class EditPostServlet extends HttpServlet {

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
    ) throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null || action.equalsIgnoreCase("edit-post")) {
            this.processGetEditPostPage(req, res);
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

        if (action == null || action.equalsIgnoreCase("edit")) {
            this.processEditPost(req, res);
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

    private void processGetEditPostPage(
            final HttpServletRequest req,
            final HttpServletResponse res
    ) throws ServletException, IOException {
        String idParam = req.getParameter("id");

        if (idParam == null) {
            sendToHttpErrorPage(req, res, BAD_REQUEST, getServletContext());
            return;
        }

        IPostBO postBO = new PostBO();
        Post post = null;
        try {
            post = postBO.getPostById(idParam);
        } catch (BusinessException ex) {
            sendToServerErrorPage(req, res, getServletContext());
        }

        if (post == null) {
            sendToHttpErrorPage(req, res, NOT_FOUND, getServletContext());
            return;
        }

        req.setAttribute("post", post);

        getServletContext()
                .getRequestDispatcher(Constants.EDIT_POST_PAGE)
                .forward(req, res);
        return;
    }

    private void processEditPost(
            final HttpServletRequest req,
            final HttpServletResponse res
    ) throws ServletException, IOException {

        String titleParam = req.getParameter("title").trim();
        String contentParam = req.getParameter("content").trim();

        if (!this.validateParams(titleParam, contentParam)) {
            sendToHttpErrorPage(req, res, BAD_REQUEST, getServletContext());
            return;
        }

        try {
            this.tryEditPost(req);
            res.setStatus(HttpStatusCode.OK.getCode());
        } catch (BusinessException ex) {
            if (ex.getMessage().equalsIgnoreCase("User is not the creator.")) {
                res.setStatus(HttpStatusCode.UNAUTHORIZED.getCode());
                sendToHttpErrorPage(
                        req,
                        res,
                        UNAUTHORIZED,
                        getServletContext()
                );
                return;
            }
            sendToServerErrorPage(req, res, getServletContext());
            return;
        }

        redirectHome(req, res);

    }

    private boolean validateParams(
            final String title,
            final String content
    ) {
        IFormValidator validator = new FormValidator();
        final int titleLimit = 15;
        final int contentLimit = 500;
        boolean isValidTitle
                = !validator.hasBlankSpaces(title)
                && !validator.hasExceededLengthLimit(title, titleLimit);

        boolean isValidContent = !validator.hasBlankSpaces(content)
                && !validator.hasExceededLengthLimit(content, contentLimit);

        return isValidTitle && isValidContent;

    }

    private void tryEditPost(
            final HttpServletRequest req
    ) throws BusinessException {

        String idParam = req.getParameter("id");
        String titleParam = req.getParameter("title");
        String contentParam = req.getParameter("content");

        IPostBO postBO = new PostBO();

        Post post = postBO.getPostById(idParam);

        post.setTitulo(titleParam);
        ContenidoPost contenido = new ContenidoPost();
        contenido.setTexto(contentParam);
        post.setContenido(contenido);

        HttpSession session = req.getSession(false);
        Usuario loggedUser = (Usuario) session.getAttribute("user");

        postBO.editPost(loggedUser, post);
    }

}
