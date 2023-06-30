<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Login</title>
        <link rel="stylesheet" href="/webapp/assets/css/users/user-form.css" />
    </head>

    <body>
        <div class="form-container">
            <div class="image-logotype">
                <img src="/webapp/assets/images/strix.png" alt="logotype" class="logotype" />
            </div>

            <form action="/webapp/auth?action=login" action="/home" class="user-form" method="POST">
                <div class="login-title"><h1>Login</h1></div>

                <div class="content">
                    <label for="email">Email</label>
                    <input
                      type="email"
                      id="email"
                      placeholder="Enter your email"
                      required
                      name="email"
                      />
                </div>

                <div class="content">
                    <label for="password">Password</label>
                    <input
                      type="password"
                      id="password"
                      placeholder="Enter your password"
                      required
                      name="password"
                      />
                </div>

                <div class="content">
                    <button type="submit" id="user-form-btn">SIGN IN</button>
                    <hr id="bar" />
                </div>
                <nav class="container-join-now">
                    <label for="joinnow" id="label-join-now">New to Strix</label>
                    <a href="./register" id="link-join-now">Join now</a>
                </nav>
            </form>
        </div>
    </body>
</html>
