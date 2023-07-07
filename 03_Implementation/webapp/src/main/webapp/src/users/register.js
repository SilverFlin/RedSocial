window.onload = init;

const host = "http://localhost:8080";
const basePath = "webapp";

function init() {
    loadRegisterForm();
}

class User {

    constructor(email, password, confirmPassword) {
        this._email = email
        this._password = password
        this._confirmPassword = confirmPassword
    }

    get email() {
        return this._email
    }
    set email(nuevoEmail) {
        this._email = nuevoEmail
    }
    get password() {
        return this._password
    }
    set password(newPassword) {
        this._password = newPassword
    }
    get confirmPassword() {
        return this._confirmPassword
    }
    set confirmPassword(confirmPassword) {
        this._confirmPassword = confirmPassword
    }
}


async function loadRegisterForm() {

    const registerForm = document.getElementById("register-form");
    const btnRegisterForm = document.getElementById("user-form-btn");
    const emailInput = document.querySelector(".content #email");
    const passwordInput = document.querySelector(".content #password");
    const confirmPasswordInput = document.querySelector(".content #confirm-password");
    registerForm.addEventListener("submit", async (evt) => {
        btnRegisterForm.disabled = true;
        btnRegisterForm.style.backgroundColor = "#D8D3D3";
        evt.preventDefault();
        const host = "http://localhost:8080";
        const basePath = "webapp";
        const url = `${host}/${basePath}/register?action=register`;
        const credentials = {
            email: emailInput.value,
            password: passwordInput.value,
            confirmPassword: confirmPasswordInput.value
        };

        if (!validateStrongPassword(credentials.password)) {
            loadStrongPasswordHint()
            enableBtn(btnRegisterForm)

            return
        }

        if (!validatePasswordMatch(credentials.password, credentials.confirmPassword)) {
            loadPasswordDoesNotMatch()
            enableBtn(btnRegisterForm)
            return
        }

        if (await validateEmailExistence(credentials.email)) {
            loadEmailRegistered();
            enableBtn(btnRegisterForm);
            return;
        }



        let formBody = generateEncodedParams(credentials);
        const fetchSettings = {
            headers: {
                "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
            },
            method: "POST",
            body: formBody,
        };
        const res = await fetch(url, fetchSettings);

        if (res.status === 200) {
            window.location.replace(`${host}/${basePath}/home`);
            btnRegisterForm.disabled = false;
        } else {
            setTimeout(() => {
                btnRegisterForm.style.backgroundColor = "#525252";
                btnRegisterForm.disabled = false;
            }, 1200);
        }
    });
}

function loadPasswordDoesNotMatch() {
    const passwordDoesNotMatch = document.getElementById("password-does-not-match");
    passwordDoesNotMatch.style.display = "block";
    setTimeout(() => {
        passwordDoesNotMatch.style.display = "none";
    }, 1200);
}

function loadStrongPasswordHint() {
    const strongPasswordHint = document.getElementById("strong-password-hint");
    strongPasswordHint.style.display = "block";
    setTimeout(() => {
        strongPasswordHint.style.display = "none";
    }, 3000);
}

function loadEmailRegistered() {
    const emailRegistered = document.getElementById("email-already-registered");
    emailRegistered.style.display = "block";
    setTimeout(() => {
        emailRegistered.style.display = "none";
    }, 1200);
}

function generateEncodedParams(obj) {
    let params = [];
    for (let property in obj) {
        let encodedKey = encodeURIComponent(property);
        let encodedValue = encodeURIComponent(obj[property]);
        params.push(encodedKey + "=" + encodedValue);
    }
    params = params.join("&");
    return params;
}

function validatePasswordMatch(pass, confirmPassword) {
    return pass === confirmPassword
}

function validateStrongPassword(password) {
    const regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,20}$/;
    return regex.test(password)
}

async function validateEmailExistence(email) {
    const fetchSettings = {
        headers: {
            "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
        },
        method: "GET",
    };
    const url = `${host}/${basePath}/register?action=check-email&email=${email}`
    const res = await fetch(url, fetchSettings);
    console.log(res)
    return res.status === 200;
}

function enableBtn(btn) {
    btn.style.backgroundColor = "#525252";
    btn.disabled = false;
}