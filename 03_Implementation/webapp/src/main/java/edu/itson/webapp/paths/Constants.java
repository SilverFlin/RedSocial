package edu.itson.webapp.paths;

/**
 *
 */
public final class Constants {

    /**
     * The path to the login page.
     */
    public static final String LOGIN_PAGE = "/pages/users/login.jsp";

    /**
     * The path to the home page.
     */
    public static final String HOME_PAGE = "/home.jsp";

    /**
     * The path to the edit user page.
     */
    public static final String EDIT_USER_PAGE = "/pages/users/edit-user.jsp";

    /**
     * The path to the register user page.
     */
    public static final String REGISTER_USER_PAGE = "/pages/users/register.jsp";

    /**
     * The path to the create post page.
     */
    public static final String CREATE_POST_PAGE
            = "/pages/posts/create-post.jsp";

    /**
     * The path to the edit post page.
     */
    public static final String EDIT_POST_PAGE = "/pages/posts/edit-post.jsp";

    /**
     * The path to the show post page.
     */
    public static final String SHOW_POST_PAGE = "/pages/posts/post.jsp";

    /**
     * The path to the HTTP error page.
     */
    public static final String HTTP_ERROR_PAGE = "/pages/errors/http-error.jsp";

    /**
     * The path to the server error page.
     */
    public static final String SERVER_ERROR_PAGE
            = "/pages/errors/server-error.jsp";

    /**
     * The endpoint for the home.
     */
    public static final String HOME_ENDPOINT = "/home";

    /**
     * The endpoint for the login.
     */
    public static final String LOGIN_ENDPOINT = "/login";

    /**
     * The endpoint for the authentication.
     */
    public static final String AUTH_ENDPOINT = "/auth";

    /**
     * The endpoint for the registration.
     */
    public static final String REGISTER_ENDPOINT = "/register";

    /**
     * The directory for assets.
     */
    public static final String ASSETS_DIR = "/assets";

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

}
