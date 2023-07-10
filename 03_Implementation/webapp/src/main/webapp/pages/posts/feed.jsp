<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="/webapp/assets/css/posts/feed.css" />
        <link rel="shortcut icon" href="/webapp/assets/favicon.ico" type="image/x-icon" />  
    </head>
    <body class="thisBody">
        <div class="container">
            <div class="left-bar"></div>
            <!--TODO move to JS-->
            <div class="posts-container">
                <button class="create-post-btn" onclick="window.location.href = '/webapp/create-post';">
                    + Create a new Post
                </button>
                <c:forEach var="item" items="${requestScope.feedItems.entrySet()}">
                    <section class="post">
                        <div class="post-components-wrapper">
                            <!--HEADER-->
                            <div class="post-header-wrapper">
                                <header class="post-header">
                                    <c:if test="${item.getKey().creador.avatar == null}">
                                        <img src="/webapp/assets/images/default-profile.jpg" alt="" />
                                    </c:if>
                                    <c:if test="${item.getKey().creador.avatar != null}">
                                        <img src="/webapp/pictures?action=avatar&id=${item.getKey().creador.id}" alt="" />
                                    </c:if>
                                    <span>
                                        <c:out value="${item.getKey().creador.nombreCompleto.nombres == null ? item.getKey().creador.email : item.getKey().creador.nombreCompleto.nombres}"/>
                                    </span>

                                </header>
                                <c:if test="${sessionScope.user.tipoUsuario == 'ADMIN'}">
                                    <div class="delete-post" id="delete-${item.getKey().id}">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path fill="currentColor" d="M9 3v1H4v2h1v13a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V6h1V4h-5V3H9m0 5h2v9H9V8m4 0h2v9h-2V8Z"/></svg>
                                    </div>
                                </c:if>
                                <c:if test="${item.getKey().tipoPost == 'ANCLADO'}">
                                    <div class="post-header-highlighted">
                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1152 1664"><path fill="currentColor" d="M480 736V288q0-14-9-23t-23-9t-23 9t-9 23v448q0 14 9 23t23 9t23-9t9-23zm672 352q0 26-19 45t-45 19H659l-51 483q-2 12-10.5 20.5T577 1664h-1q-27 0-32-27l-76-485H64q-26 0-45-19t-19-45q0-123 78.5-221.5T256 768V256q-52 0-90-38t-38-90t38-90t90-38h640q52 0 90 38t38 90t-38 90t-90 38v512q99 0 177.5 98.5T1152 1088z"/></svg>
                                    </div>
                                </c:if>
                                <div class="post-time">
                                    <!--TODO Formatear Fecha-->
                                    <label>${item.getKey().fechaHoraCreacion.dayOfMonth}/${item.getKey().fechaHoraCreacion.monthValue}/${item.getKey().fechaHoraCreacion.year}</label>

                                    <label><b>${item.getKey().fechaHoraCreacion.hour}:${item.getKey().fechaHoraCreacion.minute}</b></label>
                                </div>
                            </div>
                            <!--POST CONTENT-->
                            <div class="post-content-wrapper">
                                <section class="post-content">
                                    <h1>${item.getKey().titulo}</h1>
                                    <c:if test="${item.getKey().creador.id == sessionScope.user.id}">
                                        <a class="edit-post-btn"  href="/webapp/edit-post?action=edit-post&id=${item.getKey().id}">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M24 0v24H0V0h24ZM12.594 23.258l-.012.002l-.071.035l-.02.004l-.014-.004l-.071-.036c-.01-.003-.019 0-.024.006l-.004.01l-.017.428l.005.02l.01.013l.104.074l.015.004l.012-.004l.104-.074l.012-.016l.004-.017l-.017-.427c-.002-.01-.009-.017-.016-.018Zm.264-.113l-.014.002l-.184.093l-.01.01l-.003.011l.018.43l.005.012l.008.008l.201.092c.012.004.023 0 .029-.008l.004-.014l-.034-.614c-.003-.012-.01-.02-.02-.022Zm-.715.002a.023.023 0 0 0-.027.006l-.006.014l-.034.614c0 .012.007.02.017.024l.015-.002l.201-.093l.01-.008l.003-.011l.018-.43l-.003-.012l-.01-.01l-.184-.092Z"/><path fill="currentColor" d="M13.896 3.03a2 2 0 0 1 2.701-.117l.127.117l4.243 4.243a2 2 0 0 1 .117 2.7l-.117.128l-10.314 10.314a2 2 0 0 1-1.238.578L9.239 21H4.006a1.01 1.01 0 0 1-1.004-.9l-.006-.11v-5.233a2 2 0 0 1 .467-1.284l.12-.13L13.895 3.03ZM12.17 7.584l-7.174 7.174V19H9.24l7.174-7.174l-4.243-4.243Zm3.14-3.14L13.584 6.17l4.243 4.243l1.726-1.726l-4.243-4.243Z"/></g></svg>
                                        </a>
                                    </c:if>
                                    <p>
                                        <c:out value="${item.getKey().contenido.texto}"/>
                                    </p>
                                </section>
                            </div>

                            <!--FOOTER--> 
                            <!--TODO Comentarios-->
                            <c:if test="${item.getKey().tipoPost != 'ANCLADO'}">
                                <div class="post-footer-wrapper">
                                    <section class="post-footer">
                                        <c:if test="${item.getValue() != null}">
                                            <c:if test="${item.getKey().creador.avatar == null}">
                                                <img src="/webapp/assets/images/default-profile.jpg" alt="" />
                                            </c:if>
                                            <c:if test="${item.getKey().creador.avatar != null}">
                                                <img src="/webapp/pictures?action=avatar&id=${item.getValue().creador.id}" alt="" />
                                            </c:if>
                                            <h1>
                                                <c:out value="${item.getValue().creador.nombreCompleto.nombres == null ? item.getValue().creador.email : item.getValue().creador.nombreCompleto.nombres}"/> says:
                                            </h1>
                                            <p>
                                                <c:out value="${item.getValue().contenido.texto}"/>
                                            </p>
                                        </c:if>
                                        <c:if test="${item.getValue() == null}">
                                            <c:if test="${item.getKey().creador.avatar == null}">
                                                <img src="/webapp/assets/images/default-profile.jpg" alt="" />
                                            </c:if>
                                            <c:if test="${item.getKey().creador.avatar != null}">
                                                <img src="/webapp/pictures?action=avatar&id=${item.getKey().creador.id}" alt="" />
                                            </c:if>
                                            <h1>
                                                Leave a comment
                                            </h1>
                                            <p>
                                                There are not comments here
                                            </p>
                                        </c:if>



                                        <a class="comments-link" href="/webapp/posts?action=get-post&id=${item.getKey().id}">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 1792 1536"><path fill="currentColor" d="M1792 640q0 174-120 321.5t-326 233t-450 85.5q-70 0-145-8q-198 175-460 242q-49 14-114 22q-17 2-30.5-9t-17.5-29v-1q-3-4-.5-12t2-10t4.5-9.5l6-9l7-8.5l8-9q7-8 31-34.5t34.5-38t31-39.5t32.5-51t27-59t26-76q-157-89-247.5-220T0 640q0-130 71-248.5T262 187T548 50.5T896 0q244 0 450 85.5t326 233T1792 640z"/></svg>
                                        </a>
                                    </section>

                                </div>
                            </c:if>
                        </div>
                    </section>
                </c:forEach>
            </div>
            <div class="right-bar"></div>
        </div>
    </body>
    <script src="./src/posts/feed.js"></script>
</html>
