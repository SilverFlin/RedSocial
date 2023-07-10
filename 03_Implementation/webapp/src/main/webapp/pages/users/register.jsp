<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Register</title>
        <link rel="stylesheet" href="/webapp/assets/css/users/user-form.css" />
    </head>

    <body>
        <div class="form-container">
            <img id="background-image" src="/webapp/assets/images/background-login.jpg" alt="alt"/>
            <form action="" class="user-form" method="POST" id="register-form">
                <div><h1>Register</h1></div>

                <div class="content">
                    <label for="email">Email</label>
                    <input 
                      required
                      type="email"
                      id="email"
                      placeholder="Enter your email"
                      name="email"
                      />
                </div>
                <div class="form-message" id="email-already-registered">
                    Email address already registered!
                </div>

                <div class="content">
                    <label for="password">Password</label>
                    <input
                      required
                      type="password"
                      id="password"
                      placeholder="Enter your password"
                      name="password"
                      />
                </div>

                <div class="content">
                    <label for="confirm-password">Confirm Password</label>
                    <input
                      required
                      type="password"
                      id="confirm-password"
                      placeholder="Confirm your password"
                      name="confirmPassword"
                      />
                </div>
                <div class="form-message" id="password-does-not-match">
                    Passwords do not match.
                </div>

                <div class="form-message" id="strong-password-hint">
                    Ensure your password meets these criteria: 8-20 chars, 1 uppercase, 1 lowercase, 1 number, and 1 special char.
                </div>
                <div class="content">
                    <button type="submit" id="user-form-btn">Register</button>
                    <hr id="bar" />
                </div>
                <nav class="container-join-now">
                    <span id="label-join-now">
                        Already have an account?
                    </span>
                    <a href="./login" id="link-join-now">Sign in</a>
                </nav>
            </form>
        </div>
    </body>
    <script src="./src/users/register.js"></script>
</html>

