package edu.itson.webapp.servlets;

import edu.itson.dominio.TipoUsuario;
import edu.itson.dominio.Usuario;
import edu.itson.webapp.business.impl.UsersBO;
import edu.itson.webapp.business.interfaces.IUsersBO;
import edu.itson.webapp.exceptions.BusinessException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public final class RegisterServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(
            final HttpServletRequest request,
            final HttpServletResponse response
    )
            throws ServletException, IOException {

        String action = request.getParameter("action");

        /* Default Action */
        if (action == null || action.equalsIgnoreCase("register")) {
            getServletContext()
                    .getRequestDispatcher("/pages/users/register.jsp")
                    .forward(request, response);
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

        String paramEmail = request.getParameter("email");
        String paramPassword = request.getParameter("password");
        String paramConfirmPassword = request.getParameter("confirmPassword");

        // TODO Refactor n Move Validation
        // TODO Move confirm password validation to client-side
        // TODO Validate existent Email
        // TODO Password regex Validation
        final int limitEmail = 100;
        final int limitPassword = 30;
        if (validateParamLimit(paramEmail, limitEmail)
                || validateParamLimit(paramPassword, limitPassword)
                || validateParamLimit(paramPassword, limitPassword)
                || !paramPassword.equals(paramConfirmPassword)) {
            final int badRequestHttpStatusCode = 400;
            response.setStatus(badRequestHttpStatusCode);
            // TODO Redirect to /register
            // TODO add request attributes to fill the form
            // TODO pass an attribute to show the errors
            // (email already created / password does not match)
            return;
        }

        IUsersBO userBO = new UsersBO();
        Usuario user = new Usuario(TipoUsuario.NORMAL);
        user.setEmail(paramEmail);
        // TODO Encrypt
        user.setPassword(paramPassword);

        try {
            Usuario registeredUser = userBO.register(user);
            request.setAttribute("user", registeredUser);
            final int createdHttpStatusCode = 201;
            response.setStatus(createdHttpStatusCode);
            // TODO Auth
            // TODO Redirect HomePage
            return;
        } catch (BusinessException ex) {
            // TODO redirect to java error page.
            return;
        }
    }

    private boolean validateParamLimit(final String param, final int limit) {
        return (param == null || param.isBlank() || param.length() > limit);
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

}
