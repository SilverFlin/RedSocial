package edu.itson.webapp.servlets;

import edu.itson.dominio.TipoUsuario;
import edu.itson.dominio.Usuario;
import edu.itson.webapp.business.impl.UsersBO;
import edu.itson.webapp.business.interfaces.IUsersBO;
import edu.itson.webapp.exceptions.BusinessException;
import edu.itson.webapp.http.HttpStatusCode;
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
            this.sendToRegisterPage(req, res);
            return;
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
            final HttpServletResponse response
    )
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.equalsIgnoreCase("register")) {
            this.processUserRegister(request, response);
            return;
        }

        if (action != null && !action.equalsIgnoreCase("register")) {
            response.setStatus(HttpStatusCode.BAD_REQUEST.getCode());
            this.sendToRegisterPage(request, response);
            return;
        }

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void processUserRegister(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) throws ServletException, IOException {

        String paramEmail = request.getParameter("email");
        String paramPassword = request.getParameter("password");
        String paramConfirmPassword = request.getParameter("confirmPassword");

        // TODO Refactor n Move Validation
        // TODO Move confirm password validation to client-side
        // TODO Validate existent Email
        // TODO Password regex Validation
        boolean isValidParams = this.validateParams(
                paramEmail,
                paramPassword,
                paramConfirmPassword
        );

        if (!isValidParams) {
            response.setStatus(HttpStatusCode.BAD_REQUEST.getCode());
            this.sendToRegisterPage(request, response);
            // TODO pass an attribute to show the errors
            // (email already created / password does not match)
            return;
        }

        Usuario registeredUser;
        try {
            registeredUser = this.tryRegisterUser(paramEmail, paramPassword);
        } catch (BusinessException ex) {
            response.setStatus(HttpStatusCode.INTERNAL_SERVER_ERROR.getCode());
            getServletContext()
                    .getRequestDispatcher("/pages/errors/server-error.jsp")
                    .forward(request, response);
            return;
        }

        if (registeredUser == null) {
            response.setStatus(HttpStatusCode.BAD_REQUEST.getCode());
            getServletContext()
                    .getRequestDispatcher("/pages/errors/http-error.jsp")
                    .forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", registeredUser);
        response.setStatus(HttpStatusCode.OK.getCode());
        response.sendRedirect(request.getContextPath() + "/home");
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

    private void sendToRegisterPage(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/pages/users/register.jsp")
                .forward(request, response);
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
        final int limitEmail = 100;
        final int limitPassword = 30;
        return validateParamLimit(paramEmail, limitEmail)
                || validateParamLimit(paramPassword, limitPassword)
                || validateParamLimit(paramConfirmPassword, limitPassword)
                || !paramPassword.equals(paramConfirmPassword);
    }

    private boolean validateParamLimit(final String param, final int limit) {

        return (param == null || param.isBlank() || param.length() > limit);
    }
}
