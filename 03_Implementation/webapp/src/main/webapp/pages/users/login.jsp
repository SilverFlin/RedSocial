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
            <img id="background-image" src="https://images.unsplash.com/photo-1509828945144-552b3b1a968d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=687&q=80" alt="alt"/>
            <form
              action="/webapp/auth?action=login"
              class="user-form"
              id="login-form"
              method="POST"
              >
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
