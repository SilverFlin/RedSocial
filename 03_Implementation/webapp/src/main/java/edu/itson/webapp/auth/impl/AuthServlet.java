package edu.itson.webapp.auth.impl;

import edu.itson.dominio.Usuario;
import edu.itson.webapp.business.impl.UsersBO;
import edu.itson.webapp.business.interfaces.IUsersBO;
import edu.itson.webapp.exceptions.BusinessException;
import edu.itson.webapp.http.HttpStatusCode;
import edu.itson.webapp.paths.Constants;
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
@WebServlet(name = "Auth", urlPatterns = {"/auth"})
public final class AuthServlet extends HttpServlet {

    /*
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
    ) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action != null && action.equalsIgnoreCase("login")) {
            this.processLogin(request, response);
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
    protected void doGet(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action != null && action.equalsIgnoreCase("logout")) {
            this.processLogout(request, response);
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

    private void processLogin(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) throws ServletException, IOException {

        String paramEmail = request.getParameter("email");
        String paramPasswordAttempt = request.getParameter("password");

        // TODO Refactor n Move Validation
        final int limitEmail = 100;
        final int limitPassword = 30;
        if (validateParamLimit(paramEmail, limitEmail)
                || validateParamLimit(paramPasswordAttempt, limitPassword)) {

            response.setStatus(HttpStatusCode.BAD_REQUEST.getCode());
            request.setAttribute("email", paramEmail);
            getServletContext()
                    .getRequestDispatcher(Constants.LOGIN_PAGE)
                    .forward(request, response);

            return;
        }

        Usuario user = this.tryLogin(paramEmail, paramPasswordAttempt);

        if (user == null) {
            request.setAttribute("error", "invalid credentials");
            response.setStatus(HttpStatusCode.UNAUTHORIZED.getCode());
            getServletContext()
                    .getRequestDispatcher(Constants.HTTP_ERROR_PAGE)
                    .forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        response.setStatus(HttpStatusCode.OK.getCode());
        response.sendRedirect(
                request.getContextPath() + Constants.HOME_ENDPOINT
        );

    }

    private void processLogout(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) throws ServletException, IOException {
        request.getSession().invalidate();
        final int okHttpStatusCode = 200;
        response.setStatus(okHttpStatusCode);

        getServletContext()
                .getRequestDispatcher(Constants.LOGIN_PAGE)
                .forward(request, response);

    }

    private boolean validateParamLimit(final String param, final int limit) {
        return (param == null || param.isBlank() || param.length() > limit);
    }

    private Usuario tryLogin(
            final String email,
            final String passwordAttempt
    ) {
        try {
            IUsersBO userBO = new UsersBO();
            return userBO.login(email, passwordAttempt);
        } catch (BusinessException ex) {
            // TODO add log ?
            return null;
        }
    }

}
