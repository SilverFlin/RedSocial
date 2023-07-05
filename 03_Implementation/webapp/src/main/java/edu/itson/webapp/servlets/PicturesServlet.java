package edu.itson.webapp.servlets;

import edu.itson.dominio.Imagen;
import edu.itson.webapp.business.impl.UsersBO;
import edu.itson.webapp.business.interfaces.IUsersBO;
import edu.itson.webapp.exceptions.BusinessException;
import edu.itson.webapp.http.HttpStatusCode;
import static edu.itson.webapp.servlets.Redirect.sendToHttpErrorPage;
import static edu.itson.webapp.servlets.Redirect.sendToServerErrorPage;
import edu.itson.webapp.utils.impl.MongoImageConversor;
import edu.itson.webapp.utils.interfaces.IimageConversor;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de gestionar las imágenes.
 */
@WebServlet(name = "PicturesServlet", urlPatterns = {"/pictures"})
public class PicturesServlet extends HttpServlet {

    /**
     * Instancia.
     */
    private final IimageConversor imageConversor;

    /**
     * Instancia en el constructor.
     */
    public PicturesServlet() {
        imageConversor = new MongoImageConversor();
    }

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
            sendToHttpErrorPage(
                    req, res, HttpStatusCode.NOT_FOUND, getServletContext());
            return;
        }
        Imagen avatar;
        try {
            IUsersBO usersBO = new UsersBO();
            avatar = usersBO.getUserAvatar(idParam);
        } catch (BusinessException ex) {
            sendToServerErrorPage(req, res, getServletContext());
            return;
        }

        InputStream inputStream
                = new ByteArrayInputStream(avatar.getImageData().getData());
        String fileName = avatar.getFileName();
        Imagen convertedImage;
        try {
            convertedImage = imageConversor.
                    createImageFromInputStream(inputStream, fileName);
        } catch (IOException ex) {
            sendToServerErrorPage(req, res, getServletContext());
            return;
        }

        String path = req.getServletContext().getRealPath("");
        createTemporalDir(path);

        byte[] imgData = convertedImage.getImageData().getData();
        makeOutputResponse(req, res, imgData);
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
            sendToServerErrorPage(req, res, getServletContext());
            return;
        }
    }

}
