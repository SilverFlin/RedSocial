<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Register</title>
        <link rel="stylesheet" href="./assets/css/users/register-user.css" />
    </head>

    <body>
        <div class="grid-register-container">
            <div class="image-logotype">
                <img src="./assets/images/strix.png" alt="logotype" class="logotype" />
            </div>

            <form class="register-form">
                <div class="register-title"><h1>Register</h1></div>

                <div class="content">
                    <label for="email">Email</label>
                    <input type="email" id="email" placeholder="Enter your email" />
                </div>

                <div class="content">
                    <label for="password">Password</label>
                    <input
                        type="password"
                        id="password"
                        placeholder="Enter your password"
                        />
                </div>

                <div class="content">
                    <label for="confirm-password">Confirm Password</label>
                    <input
                        type="password"
                        id="confirm-password"
                        placeholder="Confirm your password"
                        />
                </div>

                <div class="content">
                    <button type="submit" id="button-sign-up">Register</button>
                    <hr id="bar" />
                </div>
                <nav class="log-up">
                    <span id="label-join-now">
                        Already have an account?
                    </span>
                    <a href="" id="link-join-now">Sign in</a>
                </nav>
            </form>
        </div>
    </body>
</html>

