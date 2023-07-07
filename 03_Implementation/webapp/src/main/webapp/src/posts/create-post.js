window.onload = init;

function init() {
    bindInputs();
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
