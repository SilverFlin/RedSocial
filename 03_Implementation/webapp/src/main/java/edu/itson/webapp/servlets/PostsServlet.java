package edu.itson.webapp.servlets;

import edu.itson.dominio.Post;
import edu.itson.webapp.business.impl.PostBO;
import edu.itson.webapp.business.interfaces.IPostBO;
import edu.itson.webapp.exceptions.BusinessException;
import edu.itson.webapp.http.HttpStatusCode;
import edu.itson.webapp.paths.Constants;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Toled
 */
@WebServlet(name = "PostsServlet", urlPatterns = {"/posts"})
public class PostsServlet extends HttpServlet {

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

        String actionParam = req.getParameter("action");
        // /pictures?action=avatar&id=6498a7ebce302d27e8c99b2e
        if (actionParam != null && actionParam.equalsIgnoreCase("all-posts")) {
            this.processGetAllPosts(req, res);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(
            final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {
//        TODO
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
    // </editor-fold>

    private void processGetAllPosts(
            final HttpServletRequest req,
            final HttpServletResponse res
    ) throws ServletException, IOException {
        String limitParam = req.getParameter("limit");

        int limit;
        try {
            limit = Integer.parseInt(limitParam);
        } catch (NumberFormatException ex) {
            // TODO redirect http-error
            return;
        }

        final int limitPosts = 5;
        if (limitParam == null || limit > limitPosts) {
            // TODO redirect http-error
            return;
        }

        try {
            IPostBO postBO = new PostBO();
            List<Post> posts = postBO.getPosts(limit);
            req.setAttribute("posts", posts);
        } catch (BusinessException ex) {
            // TODO Log
            res.setStatus(HttpStatusCode.INTERNAL_SERVER_ERROR.getCode());
            getServletContext()
                    .getRequestDispatcher(Constants.SERVER_ERROR_PAGE)
                    .forward(req, res);
        }

    }

}
