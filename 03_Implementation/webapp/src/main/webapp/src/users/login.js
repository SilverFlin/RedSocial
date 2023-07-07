window.onload = init;

function init() {
    loadLoginForm();
}

function loadLoginForm() {
    const loginForm = document.getElementById("login-form");
    const btnLoginForm = document.getElementById("user-form-btn");
    const emailInput = document.querySelector(".content #email");
    const passwordInput = document.querySelector(".content #password");

    loginForm.addEventListener("submit", async (evt) => {
        btnLoginForm.disabled = true;
        btnLoginForm.style.backgroundColor = "#D8D3D3";
        evt.preventDefault();

        const host = "http://localhost:8080";
        const basePath = "webapp";
        const url = `${host}/${basePath}/auth?action=login`;

        const credentials = {
            email: emailInput.value,
            password: passwordInput.value,
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
            loadInvalidCredentialsMessage();
            setTimeout(() => {
                btnLoginForm.style.backgroundColor = "#525252";
                btnLoginForm.disabled = false;
            }, 1200);
        }
    });
}

function loadInvalidCredentialsMessage() {
    const invalidCredentialsDiv = document.getElementById("invalid-credentials-msg");
    invalidCredentialsDiv.style.visibility = "visible";
    setTimeout(() => {
        invalidCredentialsDiv.style.visibility = "hidden";
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
