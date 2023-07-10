<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="Author" content="Gerardo" />
        <meta name="Description" content="Edit post page" />
        <link rel="stylesheet" href="/webapp/assets/css/posts/create-post.css" />
        <link rel="shortcut icon" href="/webapp/assets/favicon.ico" type="image/x-icon" />  
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
                          /> <c:out value="${sessionScope.user.email}"/>
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
                    <div class="text">
                        <p  class="text" id="title-post"><c:out value="${post.titulo}"/></p> 
                        <p  class="text" id="content-post"><c:out value="${post.contenido.texto}"/></p>
                    </div>
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
                      minlength="1"
                      maxlength="20"
                      value="${post.titulo}"
                      />
                </div>
                <div class="item" id="txt-area">
                    <label for="content" class="labels">Content</label>
                    <textarea minlength="1"
                              maxlength="500"   name="content" required id="content"><c:out value="${post.contenido.texto}"/></textarea>
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
    <script src="./src/posts/edit-post.js"></script>
</html>
