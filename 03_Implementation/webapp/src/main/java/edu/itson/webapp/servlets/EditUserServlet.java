package edu.itson.webapp.servlets;

import edu.itson.dominio.Imagen;
import edu.itson.dominio.Usuario;
import edu.itson.webapp.business.impl.UsersBO;
import edu.itson.webapp.business.interfaces.IUsersBO;
import edu.itson.webapp.exceptions.BusinessException;
import edu.itson.webapp.utils.MongoImageConversor;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 */
@MultipartConfig
@WebServlet(name = "EditUserServlet", urlPatterns = {"/edit-user"})
public class EditUserServlet extends HttpServlet {

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
        if (action == null || action.equalsIgnoreCase("edit-user")) {
            getServletContext()
                    .getRequestDispatcher("/pages/users/edit-user.jsp")
                    .forward(req, res);
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
            final HttpServletResponse res)
            throws ServletException, IOException {

        String firstNameParam = req.getParameter("first-name");
        String lastNameParam = req.getParameter("last-name");
        String phoneNumberParam = req.getParameter("phone-number");
        String birthdayParam = req.getParameter("phone-number");
        String genderParam = req.getParameter("gender");
        String cityParam = req.getParameter("city");
        String municipalityParam = req.getParameter("municipality");
        String stateParam = req.getParameter("state");
//        TODO Crear usuario con todo lo que no sea null
        Part profilePicturePart = req.getPart("profile-picture");
        InputStream inputStream = profilePicturePart.getInputStream();

        Imagen profilePicture
                = MongoImageConversor
                        .crearImagen(
                                inputStream,
                                profilePicturePart.getSubmittedFileName()
                        );

        // TODO Validate n Refactor
        Usuario loggedUser = (Usuario) req.getSession().getAttribute("user");
        loggedUser.setAvatar(profilePicture);
        IUsersBO userBO = new UsersBO();
        try {
            Usuario updatedUser = userBO.editUser(loggedUser);

            HttpSession session = req.getSession();
            session.removeAttribute("user");
            session.setAttribute("user", updatedUser);

            // TODO changes made msg
            // TODO redirect action edit-user
            // TODO Mover a otra clase
        } catch (BusinessException ex) {
            // TODO redirect error page
            getServletContext()
                    .getRequestDispatcher("/testIndex.jsp")
                    .forward(req, res);
            return;
        }

        getServletContext()
                .getRequestDispatcher("/edit-user")
                .forward(req, res);
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

}
