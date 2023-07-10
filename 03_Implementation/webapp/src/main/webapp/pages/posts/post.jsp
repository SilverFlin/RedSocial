<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="Author" content="Gerardo" />
        <meta name="Description" content="Edit post page" />
        <link rel="stylesheet" href="/webapp/assets/css/posts/view-post.css" />
        <link rel="shortcut icon" href="/webapp/assets/favicon.ico" type="image/x-icon" />  
        <title>${post.titulo}</title>
    </head>

    <body>
        <jsp:include page="/fragments/header.jsp" />
        <div class="hidden-id" id="post-${post.id}"></div>
        <div class="fondo-blanco" id="post-preview">
            <section id="previewTitle">
                <div id="title">
                    <h1>Comment post</h1>
                </div>
                <div id="content-header" class="grid-container">
                    <span class="username" id="username">
                        <img
                          src="/webapp/pictures?action=avatar&id=${post.creador.id}"
                          alt="UserProfilePhoto"        
                          class="user-icon"
                          />${post.creador.nombreCompleto.nombres==null?post.creador.email:post.creador.nombreCompleto.nombres}
                    </span>
                    <label class="fecha" >${post.fechaHoraCreacion.dayOfMonth}/${post.fechaHoraCreacion.monthValue}/${post.fechaHoraCreacion.year} </label>
                    <label class="hora">${post.fechaHoraCreacion.hour}:${post.fechaHoraCreacion.minute}</label>
                </div>
            </section>
            <section id="preview-content">

                <div class="pub-body">
                    <p class="text">
                        <span><c:out value="${post.titulo}"/></span>
                        <br>
                        <c:out value="${post.contenido.texto}"/>
                    </p>
                </div>
            </section>
        </div>

    <content class="fondo-blancobtm container" id="comments-input">
        <div id="contenedor-entrada" class="container-comment-input">
            <div class="item-comment">
                <input type="text" id="comment-input" placeholder="Comment here!">
            </div>
            <div id="boton-part" class="container-comment-input">
                <button id="btn-comment">Comment</button>
            </div>
        </div>

        <content class="fondo-blancobtm container" id="commentsContent">
            <div id="contenedorComments" class="container-comment">
                <c:if test="${requestScope.comments.size() == 0}">
                    <div>
                        <span>Leave a comment...</span>
                    </div>
                </c:if>
                <c:if test="${requestScope.comments.size() != 0}">
                    <details open class="container-comment">

                        <summary>Comments...</summary>

                        <!-- COMMENTSLOOP -->

                        <c:forEach var="item" items="${requestScope.comments}">
                            <div id="texto-comentario">
                                <span id="comment-user-img">
                                    <c:if test="${item.creador.avatar == null}">
                                        <img src="/webapp/assets/images/default-profile.jpg" alt="" class="user-icon"/>
                                    </c:if>
                                    <c:if test="${item.creador.avatar != null}">
                                        <img src="/webapp/pictures?action=avatar&id=${item.creador.id}" alt="" class="user-icon"/>
                                    </c:if></span>
                                <span id="comment-user-img">${item.creador.nombreCompleto.nombres == null ? item.creador.email : item.creador.nombreCompleto.nombres}: </span>
                                <span id="commentTextRow"><c:out value="${item.contenido.texto}"/></span>
                            </div>
                        </c:forEach>



                        <!-- EXAMPLES -->
                    </details>
                </c:if>
            </div>
        </content>
    </content>
    <jsp:include page="/fragments/footer.jspf" />

</body>
<script src="./src/posts/post-view.js"></script>
</html>
