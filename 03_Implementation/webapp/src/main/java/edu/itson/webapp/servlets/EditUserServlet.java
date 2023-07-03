package edu.itson.webapp.servlets;

import edu.itson.dominio.Address;
import edu.itson.dominio.UserGender;
import edu.itson.dominio.Image;
import edu.itson.dominio.CompleteName;
import edu.itson.dominio.User;
import edu.itson.webapp.business.impl.UsersBO;
import edu.itson.webapp.business.interfaces.IUsersBO;
import edu.itson.webapp.exceptions.BusinessException;
import edu.itson.webapp.http.HttpStatusCode;
import edu.itson.webapp.paths.Constants;
import edu.itson.webapp.utils.impl.FormValidator;
import edu.itson.webapp.utils.impl.LocalDateTimeProcessor;
import edu.itson.webapp.utils.impl.MongoImageConversor;
import edu.itson.webapp.utils.interfaces.IDateProcessor;
import edu.itson.webapp.utils.interfaces.IFormValidator;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
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
                    .getRequestDispatcher(Constants.EDIT_USER_PAGE)
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

        this.processEditUser(req, res);

        this.redirectHome(req, res);
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

    private void processEditUser(
            final HttpServletRequest req,
            final HttpServletResponse res
    ) throws IOException, ServletException {

        User loggedUser = (User) req.getSession().getAttribute("user");
        this.fillNewAttributesToUser(req, loggedUser);

        try {
            IUsersBO userBO = new UsersBO();
            User updatedUser = userBO.editUser(loggedUser);
            HttpSession session = req.getSession();
            session.setAttribute("user", updatedUser);
            res.setStatus(HttpStatusCode.OK.getCode());

        } catch (BusinessException ex) {
            this.sendToServerErrorPage(req, res);
            return;
        }
    }

    private void fillNewAttributesToUser(
            final HttpServletRequest req,
            final User user
    ) {

        String firstNameParam = req.getParameter("first-name");
        String lastNameParam = req.getParameter("last-name");
        String phoneNumberParam = req.getParameter("phone-number");
        String birthdayParam = req.getParameter("birthday");
        String genderParam = req.getParameter("gender");
        String cityParam = req.getParameter("city");
        String municipalityParam = req.getParameter("municipality");
        String stateParam = req.getParameter("state");
        Image profilePicture = this.getAvatarImage(req);

        IFormValidator validator = new FormValidator();

        if (!validator.hasBlankSpaces(firstNameParam)) {
            if (user.getNombreCompleto() == null) {
                user.setNombreCompleto(new CompleteName());
            }
            user.getNombreCompleto().setNombres(firstNameParam);
        }
        if (!validator.hasBlankSpaces(lastNameParam)) {
            if (user.getNombreCompleto() == null) {
                user.setNombreCompleto(new CompleteName());
            }
            user.getNombreCompleto().setApellidoPaterno(lastNameParam);
        }

        if (validator.isValidPhoneNumber(phoneNumberParam)) {
            user.setTelefono(phoneNumberParam);
        }

        if (validator.isValidDate(birthdayParam)) {
            IDateProcessor<LocalDateTime> dateProcessor
                    = new LocalDateTimeProcessor();
            LocalDateTime birthday
                    = dateProcessor.convertStringToDate(birthdayParam);
            user.setFechaNacimiento(birthday);
        }

        if (genderParam != null) {

            if (genderParam.equalsIgnoreCase("male")) {
                user.setGenero(UserGender.MASCULINO);
            } else if (genderParam.equalsIgnoreCase("female")) {
                user.setGenero(UserGender.FEMENINO);
            } else if (genderParam.equalsIgnoreCase("other")) {
                user.setGenero(UserGender.OTRO);
            }
        }

        if (!validator.hasBlankSpaces(cityParam)) {
            if (user.getDireccion() == null) {
                user.setDireccion(new Address());
            }
            user.getDireccion().setCiudad(cityParam);
        }

        if (!validator.hasBlankSpaces(municipalityParam)) {
            if (user.getDireccion() == null) {
                user.setDireccion(new Address());
            }
            user.getDireccion().setMunicipio(municipalityParam);
        }

        if (!validator.hasBlankSpaces(stateParam)) {
            if (user.getDireccion() == null) {
                user.setDireccion(new Address());
            }
            user.getDireccion().setEstado(stateParam);
        }

        if (profilePicture != null) {
            user.setAvatar(profilePicture);
        }
    }

    private Image getAvatarImage(final HttpServletRequest req) {
        String inputName = "profile-picture";
        try {
            Part profilePicturePart = req.getPart(inputName);

            InputStream inputStream = profilePicturePart.getInputStream();

            return MongoImageConversor
                    .createImageFromInputStream(
                            inputStream,
                            profilePicturePart.getSubmittedFileName()
                    );

        } catch (IOException | ServletException ex) {
            return null;
        }
    }

    private void sendToServerErrorPage(
            final HttpServletRequest req,
            final HttpServletResponse res
    ) throws ServletException, IOException {
        res.setStatus(HttpStatusCode.INTERNAL_SERVER_ERROR.getCode());
        getServletContext()
                .getRequestDispatcher("/pages/errors/server-error.jsp")
                .forward(req, res);
    }

    private void redirectHome(
            final HttpServletRequest req,
            final HttpServletResponse res
    ) throws IOException {
        res.setStatus(HttpStatusCode.OK.getCode());
        res.sendRedirect(req.getContextPath() + "/home");
    }
}
