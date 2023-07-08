package edu.itson.webapp.servlets;

import edu.itson.dominio.Post;
import edu.itson.webapp.business.impl.PostBO;
import edu.itson.webapp.business.interfaces.IPostBO;
import edu.itson.webapp.exceptions.BusinessException;
import edu.itson.webapp.paths.Constants;
import static edu.itson.webapp.servlets.Redirect.sendToServerErrorPage;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

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

        this.loadPosts(req, res);
        getServletContext()
                .getRequestDispatcher(Constants.HOME_PAGE)
                .forward(req, res);
        return;
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

    private void loadPosts(
            final HttpServletRequest req,
            final HttpServletResponse res
    ) throws ServletException, IOException {
        try {
            List<Post> posts = this.getPosts();
            req.setAttribute("posts", posts);
        } catch (BusinessException ex) {
            sendToServerErrorPage(req, res, getServletContext());
            return;
        }
    }

    private List<Post> getPosts() throws BusinessException {
        IPostBO postBO = new PostBO();
        final int cantidadMaximaPosts = 25;
        return postBO.getPosts(cantidadMaximaPosts);
    }

}
