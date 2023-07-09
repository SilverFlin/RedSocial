package edu.itson.webapp.servlets;

import edu.itson.dominio.Comentario;
import edu.itson.dominio.Post;
import edu.itson.webapp.business.impl.PostBO;
import edu.itson.webapp.business.interfaces.IPostBO;
import edu.itson.webapp.exceptions.BusinessException;
import edu.itson.webapp.paths.Constants;
import static edu.itson.webapp.servlets.Redirect.sendToServerErrorPage;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
            Map<Post, Comentario> feedItems = this.getPosts();
            req.setAttribute("feedItems", feedItems);
        } catch (BusinessException ex) {
            sendToServerErrorPage(req, res, getServletContext());
            return;
        }
    }

    private Map<Post, Comentario> getPosts() throws BusinessException {
        IPostBO postBO = new PostBO();
        Map<Post, Comentario> feedMap = new HashMap<>();

        final int cantidadMaximaPosts = 25;
        List<Post> posts = postBO.getPosts(cantidadMaximaPosts);

        for (Post post : posts) {
            Comentario comment = null;
            List<Comentario> comments = postBO.getPostComments(post);
            if (!comments.isEmpty()) {
                comment = comments.get(comments.size() - 1);
            }
            feedMap.put(post, comment);
        }

        return feedMap;

    }

}
