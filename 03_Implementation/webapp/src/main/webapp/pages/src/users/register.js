window.onload = init;

function init() {
//    loadRegisterForm();
    console.log("asd")

}
console.log("asd")
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


function loadRegisterForm() {

    const registerForm = document.getElementById("login-form");
    const btnLoginForm = document.getElementById("user-form-btn");
    const emailInput = document.querySelector(".content #email");
    const passwordInput = document.querySelector(".content #password");
    const confirmPasswordInput = document.querySelector(".content #confirm-password");

    registerForm.addEventListener("submit", async (evt) => {
        btnLoginForm.disabled = true;
        btnLoginForm.style.backgroundColor = "#D8D3D3";
        evt.preventDefault();

        const host = "http://localhost:8080";
        const basePath = "webapp";
        const url = `${host}/${basePath}/auth?action=register`;

        const credentials = {
            email: emailInput.value,
            password: passwordInput.value,
            confirmPassword: confirmPasswordInput.value
        };

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
            btnLoginForm.disabled = false;
        } else {
            setTimeout(() => {
                btnLoginForm.style.backgroundColor = "#525252";
                btnLoginForm.disabled = false;
            }, 1200);
        }
    });
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