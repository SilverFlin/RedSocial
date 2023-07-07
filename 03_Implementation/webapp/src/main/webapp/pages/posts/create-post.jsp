<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="Author" content="Gerardo" />
        <meta name="Description" content="Create post page" />
        <link rel="stylesheet" href="/webapp/assets/css/posts/create-post.css" />
        <title>Create Post</title>
    </head>

    <body>

        <jsp:include page="/fragments/header.jsp" />
        <div class="fondo-blanco" id="post-preview">
            <div id="title">
                <h1>Create Post</h1>
            </div>
            <span id="preview-title-span">Preview</span>
            <section id="previewTitle">
                <div id="contentHeader" class="grid-container">
                    <span class="username" id="username">
                        <img
                          src="/webapp/pictures?action=avatar&id=${sessionScope.user.id}"
                          alt="UserProfilePhoto"
                          class="user-icon"
                          />${sessionScope.user.nombreCompleto.nombres != null ? sessionScope.user.nombreCompleto.nombres  : sessionScope.user.email}</span
                    >
                    <span class="fecha">dd/mmmm/yy</span>
                    <span class="hora">13:45</span>
                </div>
            </section>
            <section id="previewContent">
                <div class="pub-body">
                    <div class="text">
                        <p  id="title-post">Title</p> 
                        <p id="content-post">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                    </div>
                </div>
            </section>
        </div>

        <form action="create-post" method="POST" class="fondo-blanco container" id="form">
            <div id="contenedor" class="container">
                <div class="item" id="titlefield">
                    <label for="title-text" class="labels">Title</label>
                    <input type="text" name="title" id="title-text" required />
                </div>
                <div class="item" id="txtArea">
                    <label for="content" class="labels">Content</label>
                    <textarea name="content" id="content"  required></textarea>
                </div>
                <div class="item" id="fileField">
                    <input disabled type="file" name="file" id="file" />
                </div>
            </div>
            <div id="botonPart" class="container2">
                <input type="submit" class="item2" value="Post" id="boton" />
            </div>
        </form>
        <jsp:include page="/fragments/footer.jspf" />
    </body>
    <script src="./src/posts/create-post.js"></script>
</html>


