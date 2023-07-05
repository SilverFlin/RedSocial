package edu.itson.webapp.servlets;

import com.google.gson.Gson;
import edu.itson.dominio.Post;
import edu.itson.dominio.Usuario;
import edu.itson.webapp.business.impl.PostBO;
import edu.itson.webapp.business.interfaces.IPostBO;
import edu.itson.webapp.exceptions.BusinessException;
import edu.itson.webapp.http.HttpStatusCode;
import static edu.itson.webapp.http.HttpStatusCode.BAD_REQUEST;
import static edu.itson.webapp.http.HttpStatusCode.UNAUTHORIZED;
import edu.itson.webapp.json.impl.IdJson;
import edu.itson.webapp.json.impl.JsonResponses;
import edu.itson.webapp.json.impl.ResponseJson;
import java.io.IOException;
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
public final class PostsServlet extends HttpServlet {

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
        // TODO vista Post
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

    }

    @Override
    protected void doDelete(
            final HttpServletRequest req,
            final HttpServletResponse res
    ) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null || action.equalsIgnoreCase("delete-post")) {
            this.processDeletePost(req, res);
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

    private void processDeletePost(
            final HttpServletRequest req,
            final HttpServletResponse res
    ) throws ServletException, IOException {
        ResponseJson<IdJson> responseJson = new ResponseJson<>();

        String idParam = req.getParameter("id");

        String jsonData = JsonConverter.getJsonFromRequest(req);
        Gson gson = new Gson();
        IdJson idJson = gson.fromJson(jsonData, IdJson.class);
        String postId = idJson.getId();

        Usuario user = (Usuario) req.getSession().getAttribute("user");

        if (user == null) {
            res.setStatus(UNAUTHORIZED.getCode());
            ResponseJson.doJsonResponse(
                    responseJson,
                    JsonResponses.STATUS_FAIL,
                    "User is null",
                    null,
                    res);
            return;
        }

        Post postDeleted;
        try {
            postDeleted = this.tryDeletePost(idParam, user);

            if (postDeleted == null) {
                postDeleted = this.tryDeletePost(postId, user);
            }

        } catch (BusinessException ex) {
            res.setStatus(BAD_REQUEST.getCode());
            ResponseJson.doJsonResponse(
                    responseJson,
                    JsonResponses.STATUS_FAIL,
                    "Post was not deleted",
                    null,
                    res);
            return;
        }

        if (postDeleted == null) {
            res.setStatus(BAD_REQUEST.getCode());
            ResponseJson.doJsonResponse(
                    responseJson,
                    JsonResponses.STATUS_FAIL,
                    "Post is null",
                    null,
                    res);
            return;
        }

        res.setStatus(HttpStatusCode.OK.getCode());
        ResponseJson.doJsonResponse(
                responseJson,
                JsonResponses.STATUS_SUCCESS,
                "Post was deleted succesfully",
                idJson,
                res
        );
        return;

    }

    private Post tryDeletePost(
            final String postId,
            final Usuario user
    ) throws BusinessException {
        if (postId == null || user == null) {
            return null;
        }
        IPostBO postBO = new PostBO();
        return postBO.deletePost(postId, user);
    }

}
