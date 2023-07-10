window.onload = init;

const host = "http://localhost:8080";
const basePath = "webapp";

function init() {
    bindInputs();
    loadFormSubmission()
}

function bindInputs() {
    const titleInput = document.getElementById("title-text");
    const contentInput = document.getElementById("content");
    const titlePost = document.getElementById("title-post");
    const contentPost = document.getElementById("content-post");
    bindInputToElement(titleInput, titlePost);
    bindInputToElement(contentInput, contentPost);
}

function bindInputToElement(inputElement, element) {
    inputElement.addEventListener("input", (evt) => {
        element.innerText = evt.target.value;
    });
    inputElement.addEventListener("focusout", () => {
        inputElement.value = inputElement.value.trim()
    })
}

function loadFormSubmission() {
    const createPostForm = document.getElementById("form")
    const titleInput = document.getElementById("title-text");
    const contentInput = document.getElementById("content");
    const typeInput = document.getElementById("type")

    createPostForm.addEventListener("submit", (evt) => {
        evt.preventDefault()
        const post = {
            title: titleInput.value.trim(),
            content: contentInput.value.trim(),
            isAnchored: !!typeInput?.checked
        }
             
        const fetchSettings = {
            headers: {
                "Content-Type": "application/json; charset=UTF-8",
            },
            body: JSON.stringify(post),
            method: "POST",
        };
        const url = `${host}/${basePath}/create-post?action=create-post`
        fetch(url, fetchSettings).then((res) => {
            if (res.status === 201) {
                alert("Post was created")
                window.location.replace(`${host}/${basePath}/home`);
            } else {
                alert("Something went wrong, please try again.")
            }
        });
    })
}