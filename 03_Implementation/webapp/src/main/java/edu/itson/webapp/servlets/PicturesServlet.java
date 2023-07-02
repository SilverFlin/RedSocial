package edu.itson.webapp.servlets;

import edu.itson.dominio.Imagen;
import edu.itson.webapp.business.impl.UsersBO;
import edu.itson.webapp.business.interfaces.IUsersBO;
import edu.itson.webapp.exceptions.BusinessException;
import edu.itson.webapp.http.HttpStatusCode;
import edu.itson.webapp.paths.Constants;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@WebServlet(name = "PicturesServlet", urlPatterns = {"/pictures"})
public class PicturesServlet extends HttpServlet {

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
        if (actionParam != null && actionParam.equalsIgnoreCase("avatar")) {
            this.processGetAvatar(req, res);
        }

        if (actionParam != null && actionParam.equalsIgnoreCase("content")) {
            this.processGetContent(req, res);
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

    private void processGetAvatar(
            final HttpServletRequest req,
            final HttpServletResponse res
    ) throws ServletException, IOException {

        String idParam = req.getParameter("id");

        if (idParam == null) {
            this.sendToHttpErrorPage(req, res, HttpStatusCode.NOT_FOUND);
            return;
        }
        Imagen avatar;
        try {
            IUsersBO usersBO = new UsersBO();
            avatar = usersBO.getUserAvatar(idParam);
        } catch (BusinessException ex) {
            this.sendToServerErrorPage(req, res);
            return;
        }

        String path = req.getServletContext().getRealPath("");
        this.createTemporalDir(path);

        byte[] imgData = avatar.getImageData().getData();
        this.makeOutputResponse(req, res, imgData);
        return;

    }

    private void processGetContent(
            final HttpServletRequest req,
            final HttpServletResponse res
    ) throws ServletException, IOException {

    }

    private void createTemporalDir(final String path) {
        String pathGuardar = path + "archivos";
        File dir = new File(pathGuardar);
        if (!dir.exists()) {
            dir.mkdir();
        }

    }

    private void makeOutputResponse(
            final HttpServletRequest req,
            final HttpServletResponse res,
            final byte[] imgData
    ) throws ServletException, IOException {
        try (OutputStream out = res.getOutputStream()) {
            out.write(imgData);
            out.flush();
        } catch (IOException ex) {
            sendToServerErrorPage(req, res);
            return;
        }
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
}
