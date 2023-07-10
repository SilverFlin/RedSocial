<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Login</title>
        <link rel="stylesheet" href="/webapp/assets/css/users/user-form.css" />
        <link rel="shortcut icon" href="/webapp/assets/favicon.ico" type="image/x-icon" />  
    </head>

    <body>

        <div class="form-container">
            <img id="background-image" src="/webapp/assets/images/background-login.png" alt="alt"/>
            <form
              action="/webapp/auth?action=login"
              class="user-form"
              id="login-form"
              method="POST"
              >
                <div>
                    <img id="logo-form" src="/webapp/assets/images/strix-font.png" alt="alt"/>
                </div>
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
                <p class="form-message" id="invalid-credentials-msg">Invalid Credentials!</p>

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
    <script src="./src/users/login.js"></script>
</html>
