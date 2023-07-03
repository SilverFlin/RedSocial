package edu.itson.webapp.servlets;

import edu.itson.dominio.TipoUsuario;
import edu.itson.dominio.Usuario;
import edu.itson.webapp.business.impl.UsersBO;
import edu.itson.webapp.business.interfaces.IUsersBO;
import edu.itson.webapp.exceptions.BusinessException;
import edu.itson.webapp.http.HttpStatusCode;
import static edu.itson.webapp.servlets.Redirect.redirectHome;
import static edu.itson.webapp.servlets.Redirect.sendToHttpErrorPage;
import static edu.itson.webapp.servlets.Redirect.sendToRegisterPage;
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
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public final class RegisterServlet extends HttpServlet {

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
        if (action == null || action.equalsIgnoreCase("register")) {
            sendToRegisterPage(req, res, getServletContext());
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

        if (action == null || action.equalsIgnoreCase("register")) {
            this.processUserRegister(req, res);
            return;
        }

        if (action != null && !action.equalsIgnoreCase("register")) {
            res.setStatus(HttpStatusCode.BAD_REQUEST.getCode());
            sendToRegisterPage(req, res, getServletContext());
            return;
        }

    }

    /**
     *
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    private void processUserRegister(
            final HttpServletRequest req,
            final HttpServletResponse res
    ) throws ServletException, IOException {

        String paramEmail = req.getParameter("email");
        String paramPassword = req.getParameter("password");
        String paramConfirmPassword = req.getParameter("confirmPassword");
        // TODO Validate existent Email

        boolean isValidParams = this.validateParams(
                paramEmail,
                paramPassword,
                paramConfirmPassword
        );

        if (!isValidParams) {
            sendToRegisterPage(req, res, getServletContext());
            return;
        }

        Usuario registeredUser;
        try {
            registeredUser = this.tryRegisterUser(paramEmail, paramPassword);
        } catch (BusinessException ex) {
            sendToServerErrorPage(req, res, getServletContext());
            return;
        }

        if (registeredUser == null) {
            sendToHttpErrorPage(
                    req,
                    res,
                    HttpStatusCode.BAD_REQUEST,
                    getServletContext()
            );
            return;
        }

        this.createSession(req, registeredUser);
        redirectHome(req, res);
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

    private Usuario tryRegisterUser(
            final String paramEmail,
            final String paramPassword
    ) throws BusinessException {
        IUsersBO userBO = new UsersBO();
        Usuario user = new Usuario(TipoUsuario.NORMAL);
        user.setEmail(paramEmail);
        user.setPassword(paramPassword);
        return userBO.register(user);
    }

    private boolean validateParams(
            final String paramEmail,
            final String paramPassword,
            final String paramConfirmPassword
    ) {
        IFormValidator validator = new FormValidator();

        boolean isValidEmail = validator.isValidEmail(paramEmail);
        boolean isValidPassword = validator.isValidPassword(paramPassword);
        boolean isValidConfirmPass = paramConfirmPassword.equals(paramPassword);
        return isValidEmail && isValidPassword && isValidConfirmPass;
    }

    private void createSession(
            final HttpServletRequest req,
            final Usuario registeredUser
    ) {
        HttpSession session = req.getSession();
        session.setAttribute("user", registeredUser);
    }
}
