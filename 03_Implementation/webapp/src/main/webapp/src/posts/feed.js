window.onload = init;
const host = "http://localhost:8080";
const basePath = "webapp";

function init() {
    loadDeleteButtons()
}

function loadDeleteButtons() {
    const deleteButtons = document.getElementsByClassName("delete-post")

    for (let btn of deleteButtons) {
        btn.addEventListener("click", function (evt) {
            const id = this.id.split('-')[1];
            processDeletePost(id)
        })
    }

}

function processDeletePost(id) {
    if (id === null) {
        return;
    }

    if (loadConfirmOperation()) {
        doDeletePostRequest(id)
    }
}

function loadConfirmOperation(id) {
    return confirm(`Are you sure that you want to delete this post?`)
}

function doDeletePostRequest(id) {
    const post = {id}

    const fetchSettings = {
        headers: {
            "Content-Type": "application/json; charset=UTF-8",
        },
        body: JSON.stringify(post),
        method: "DELETE",
    };
    const url = `${host}/${basePath}/posts?action=delete-post`
    fetch(url, fetchSettings).then((res) => {
        if (res.status === 200) {
            alert("Post was deleted")
            window.location.replace(`${host}/${basePath}/home`);
        } else {
            alert("Something went wrong, please try again.")
        }
    });
}