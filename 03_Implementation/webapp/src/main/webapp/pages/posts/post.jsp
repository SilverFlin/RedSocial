<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="Author" content="Gerardo" />
        <meta name="Description" content="Edit post page" />
        <link rel="stylesheet" href="/webapp/assets/css/posts/view-post.css" />
        <title>Edit Post</title>
    </head>

    <body>
        <div class="fondo-blanco" id="post-preview">

            <section id="previewTitle">

                <div id="title">
                    <h1>Comment post</h1>
                </div>
                <div id="content-header" class="grid-container">
                    <span class="username" id="username">
                        <img
                          src="/webapp/pictures?action=avatar&id=${sessionScope.user.id}"
                          alt="UserProfilePhoto"
                          class="user-icon"
                          />${sessionScope.user.nombreCompleto.nombres==null?sessionScope.user.email:sessionScope.user.nombreCompleto.nombres}
                    </span>
                    <label class="fecha" >${post.fechaHoraCreacion.dayOfMonth}/${post.fechaHoraCreacion.monthValue}/${post.fechaHoraCreacion.year} </label>
                    <label class="hora">${post.fechaHoraCreacion.hour}:${post.fechaHoraCreacion.minute}</label>
                </div>
            </section>
            <section id="preview-content">

                <div class="pub-body">
                    <p class="text">
                        ${post.titulo} <br>
                        ${post.contenido.texto}
                    </p>
                </div>
            </section>
        </div>

    <content class="fondo-blancobtm container " id="commentsInput">
        <div id="contenedorEntrada" class="containerCommentInput">
            <div class="itemComment">
                <input type="text" id="commentInput" placeholder="Comment here!">
            </div>
            <div id="boton-part" class="containerCommentInput">
                <button id="btn-comment">Comment</button>
            </div>
        </div>

        <content class="fondo-blancobtm container" id="commentsContent">
            <div id="contenedorComments" class="containerComment">
                <details>
                    <summary>Comments...</summary>

                    <!-- COMMENTSLOOP -->
                    <c:forEach var="item" items="${requestScope.comments}">
                        <div id="textoComentario">
                            <span id="commentUser-Img">
                                <img
                                  src="/webapp/pictures?action=avatar&id=${item.creador.id}"
                                  alt="UserProfilePhoto"
                                  class="user-icon"
                                  />${item.creador.nombreCompleto.nombres}:</span>
                            <span id="commentTextRow">${item.contenido.texto}</span>
                        </div>
                    </c:forEach>
                    
                    <!-- EXAMPLES -->
                </details>
            </div>
        </content>
    </content>


</body>
</html>
