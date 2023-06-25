<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Register</title>
        <link rel="stylesheet" href="./assets/css/users/user-form.css" />
    </head>

    <body>
        <div class="form-container">
            <div class="image-logotype">
                <img src="./assets/images/strix.png" alt="logotype" class="logotype" />
            </div>

            <form action="" class="user-form" method="POST">
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

                <div class="content">
                    <button type="submit" id="user-form-btn">Register</button>
                    <hr id="bar" />
                </div>
                <nav class="container-join-now">
                    <span id="label-join-now">
                        Already have an account?
                    </span>
                    <a href="" id="link-join-now">Sign in</a>
                </nav>
            </form>
        </div>
    </body>
</html>

