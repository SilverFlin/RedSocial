<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="Author" content="Gerardo" />
        <meta name="Description" content="Edit post page" />
        <link rel="stylesheet" href="/webapp/assets/css/posts/create-post.css" />
        <title>Edit Post</title>
    </head>

    <body>
        <div class="fondo-blanco" id="post-preview">
            <div id="title">
                <h1>Edit Post</h1>
            </div>
            <span id="preview-title-span">Preview</span>
            <section id="previewTitle">
                <div id="content-header" class="grid-container">
                    <span class="username" id="username">
                        <img
                          src="/webapp/pictures?action=avatar&id=${sessionScope.user.id}"
                          alt="UserProfilePhoto"
                          class="user-icon"
                          />${sessionScope.user.email}
                    </span>
                    <label class="fecha"
                           >${post.fechaHoraCreacion.dayOfMonth}/${post.fechaHoraCreacion.monthValue}/${post.fechaHoraCreacion.year}
                    </label>
                    <label class="hora"
                           >${post.fechaHoraCreacion.hour}:${post.fechaHoraCreacion.minute}</label
                    >
                </div>
            </section>
            <section id="preview-content">
                <div class="pub-body">
                    <p class="text">
                    <p id="title-post">${post.titulo}</p> 
                    <p id="content-post">${post.contenido.texto}</p>
                    </p>
                </div>
            </section>
        </div>

        <form
          action="/webapp/edit-post?action=edit&id=${post.id}"
          method="post"
          class="fondo-blanco container"
          id="form"
          >
            <div id="contenedor" class="container">
                <div class="item" id="titlefield">
                    <label for="title-text" class="labels">Title</label>
                    <input
                      type="text"
                      name="title"
                      id="title-text"
                      required
                      value="${post.titulo}"
                      />
                </div>
                <div class="item" id="txt-area">
                    <label for="content" class="labels">Content</label>
                    <textarea name="content" required id="content">${post.contenido.texto}</textarea>
                </div>
                <div class="item" id="file-field">
                    <input disabled type="file" name="file" id="file" />
                </div>
            </div>
            <div id="boton-part" class="container2">
                <input type="submit" class="item2" value="Edit" id="boton" />
            </div>
        </form>
    </body>
    <script src="/webapp/src/posts/edit-post.js"></script>
</html>
