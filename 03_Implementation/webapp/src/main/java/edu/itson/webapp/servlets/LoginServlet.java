package edu.itson.webapp.servlets;

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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public final class LoginServlet extends HttpServlet {

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
        if (action == null || action.equalsIgnoreCase("login")) {
            getServletContext()
                    .getRequestDispatcher("/pages/users/login.jsp")
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
    ) throws ServletException, IOException {

        String action = request.getParameter("action");

        String paramEmail = request.getParameter("email");
        String paramPasswordAttempt = request.getParameter("password");

        // TODO Refactor n Move Validation
        final int limitEmail = 100;
        final int limitPassword = 30;
        if (validateParamLimit(paramEmail, limitEmail)
                || validateParamLimit(paramPasswordAttempt, limitPassword)) {
            final int badRequestHttpStatusCode = 400;
            response.setStatus(badRequestHttpStatusCode);
            // TODO Redirect to /login
            // TODO add request attributes to fill the form
            return;
        }

        IUsersBO userBO = new UsersBO();

        try {

            Usuario user = userBO.login(paramEmail, paramPasswordAttempt);
            if (user == null) {
                request.setAttribute("error", "invalid credentials");
                final int unauthorizedHttpStatusCode = 401;
                response.setStatus(unauthorizedHttpStatusCode);
                return;
            }

            request.setAttribute("user", user);
            final int okHttpStatusCode = 200;
            response.setStatus(okHttpStatusCode);

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
