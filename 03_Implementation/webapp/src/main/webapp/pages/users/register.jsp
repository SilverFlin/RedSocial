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
            <img id="background-image" src="https://images.unsplash.com/photo-1509828945144-552b3b1a968d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=687&q=80" alt="alt"/>
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
                <div class="form-message" id="password-does-not-match">The entered passwords do not match!</div>
                <div class="form-message" id="email-already-registered">The email address is already registered!</div>
                <div class="form-message" id="strong-password-hint">
                    <ul>
                        <li>At least one number</li>
                        <li>One uppercase letter</li>
                        <li>One lowercase letter</li>
                        <li>One special character</li>
                        <li>Length between 8 and 20 characters</li>
                    </ul>
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

