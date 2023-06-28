package edu.itson.webapp.servlets;

import edu.itson.dominio.Imagen;
import edu.itson.webapp.business.impl.UsersBO;
import edu.itson.webapp.business.interfaces.IUsersBO;
import edu.itson.webapp.exceptions.BusinessException;
import edu.itson.webapp.http.HttpStatusCode;
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
            res.setStatus(HttpStatusCode.NOT_FOUND.getCode());
            // TODO redirect error page
            return;
        }
        Imagen avatar;
        try {
            IUsersBO usersBO = new UsersBO();
            avatar = usersBO.getUserAvatar(idParam);
        } catch (BusinessException ex) {
            // TODO redirect to java error page.
            return;
        }

        // Crea Imagen temporal
        String path = req.getServletContext().getRealPath("");
        String pathGuardar = path + "archivos";
        File dir = new File(pathGuardar);
        if (!dir.exists()) {
            dir.mkdir();
        }
        byte[] imgData = avatar.getImageData().getData();

        try (OutputStream out = res.getOutputStream()) {
            out.write(imgData);
            out.flush();
        } catch (IOException ex) {
            // TODO redirect to java error page.
            return;
        }
    }

    private void processGetContent(
            final HttpServletRequest req,
            final HttpServletResponse res
    ) throws ServletException, IOException {

    }

}
