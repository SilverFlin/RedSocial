window.onload = init;

const host = "http://localhost:8080";
const basePath = "webapp";

function init() {
    loadCommentSubmission();
}

function loadCommentSubmission() {
    const commentInput = document.getElementById("comment-input");
    const postIdElement = document.getElementsByClassName("hidden-id")[0];
    const submitBtn = document.getElementById("btn-comment");

    submitBtn.addEventListener("click", (evt) => {
        evt.preventDefault()

        const comment = {
            postId: postIdElement.id.split('-')[1],
            content: commentInput.value.trim()
        }

        if (comment.content.length <= 0) {
            return;
        }

        const fetchSettings = {
            headers: {
                "Content-Type": "application/json; charset=UTF-8",
            },
            body: JSON.stringify(comment),
            method: "POST",
        };
        const url = `${host}/${basePath}/comments?action=create-comment`
        fetch(url, fetchSettings).then((res) => {
            if (res.status === 201) {
                alert("Comment created")
                window.location.replace(`${host}/${basePath}/posts?action=get-post&id=${comment.postId}`);
            } else {
                alert("Something went wrong, please try again.")
            }
        });
    })

}