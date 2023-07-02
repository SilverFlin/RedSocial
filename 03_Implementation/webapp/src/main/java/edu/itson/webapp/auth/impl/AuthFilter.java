package edu.itson.webapp.auth.impl;

import edu.itson.webapp.auth.interfaces.AuthRequestProcessor;
import edu.itson.webapp.http.HttpStatusCode;
import edu.itson.webapp.paths.Constants;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public final class AuthFilter implements Filter {

    @Override
    public void doFilter(
            final ServletRequest req,
            final ServletResponse res,
            final FilterChain chain
    ) throws IOException, ServletException {

        if (!this.isAuthorized(req)) {
            this.redirectLogin(req, res);
            return;
        }

        chain.doFilter(req, res);

    }

    @Override
    public void destroy() {

    }

    private void redirectLogin(
            final ServletRequest req,
            final ServletResponse res
    ) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setStatus(HttpStatusCode.UNAUTHORIZED.getCode());

        req.getServletContext()
                .getRequestDispatcher(Constants.LOGIN_PAGE)
                .forward(req, res);
    }

    private boolean isAuthorized(final ServletRequest req) {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        String path = AuthRequestProcessor.getRequestedPath(httpReq);

        boolean isPrivatePathReq = AuthRequestProcessor.isPrivatePath(path);
        boolean isUserLoggedIn = AuthRequestProcessor.isUserLoggedIn(httpReq);

        return !isPrivatePathReq && isUserLoggedIn;

    }
}
