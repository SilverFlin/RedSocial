<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="/webapp/assets/css/posts/feed.css" />

    </head>
    <body class="thisBody">
        <div class="container">
            <div class="left-bar"></div>
            <!--TODO move to JS-->
            <button class="create-post-btn" onclick="window.location.href = '/webapp/create-post';">
                + Create a new Post
            </button>

            <c:forEach var="item" items="${requestScope.posts}">
                <section class="post">
                    <div class="post-components-wrapper">
                        <!--HEADER-->
                        <div class="post-header-wrapper">
                            <header class="post-header">

                                <c:if test="${item.creador.avatar == null}">
                                    <img src="/webapp/assets/images/default-profile.jpg" alt="" />
                                </c:if>
                                <c:if test="${item.creador.avatar != null}">
                                    <img src="/webapp/pictures?action=avatar&id=${item.creador.id}" alt="" />
                                </c:if>
                                <span>${item.creador.nombreCompleto.nombres == null ? item.creador.email : item.creador.nombreCompleto.nombres}</span>
                            </header>
                            <c:if test="${item.tipoPost == 'ANCLADO'}">
                                <header class="post-header-highlighted">
                                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1152 1664"><path fill="currentColor" d="M480 736V288q0-14-9-23t-23-9t-23 9t-9 23v448q0 14 9 23t23 9t23-9t9-23zm672 352q0 26-19 45t-45 19H659l-51 483q-2 12-10.5 20.5T577 1664h-1q-27 0-32-27l-76-485H64q-26 0-45-19t-19-45q0-123 78.5-221.5T256 768V256q-52 0-90-38t-38-90t38-90t90-38h640q52 0 90 38t38 90t-38 90t-90 38v512q99 0 177.5 98.5T1152 1088z"/></svg>
                                </header>
                            </c:if>
                            <div class="post-time">
                                <!--TODO Formatear Fecha-->
                                <label>${item.fechaHoraCreacion.dayOfMonth}/${item.fechaHoraCreacion.monthValue}/${item.fechaHoraCreacion.year}</label>

                                <label><b>${item.fechaHoraCreacion.hour}:${item.fechaHoraCreacion.minute}</b></label>
                            </div>
                        </div>
                        <!--POST CONTENT-->
                        <div class="post-content-wrapper">
                            <section class="post-content">
                                <h1>${item.titulo}</h1>
                                <p>
                                    ${item.contenido.texto}
                                </p>
                                <c:if test="${sessionScope.user.tipoUsuario == 'ADMIN'}">
                                    <div class="delete-post">
                                        <svg
                                          xmlns="http://www.w3.org/2000/svg"
                                          width="24"
                                          height="24"
                                          viewBox="0 0 24 24"
                                          >
                                        <path
                                          fill="currentColor"
                                          d="m9.25 22l-.4-3.2q-.325-.125-.613-.3t-.562-.375L4.7 19.375l-2.75-4.75l2.575-1.95Q4.5 12.5 4.5 12.337v-.674q0-.163.025-.338L1.95 9.375l2.75-4.75l2.975 1.25q.275-.2.575-.375t.6-.3l.4-3.2h5.5l.4 3.2q.325.125.613.3t.562.375l2.975-1.25l2.75 4.75l-2.575 1.95q.025.175.025.338v.674q0 .163-.05.338l2.575 1.95l-2.75 4.75l-2.95-1.25q-.275.2-.575.375t-.6.3l-.4 3.2h-5.5Zm2.8-6.5q1.45 0 2.475-1.025T15.55 12q0-1.45-1.025-2.475T12.05 8.5q-1.475 0-2.488 1.025T8.55 12q0 1.45 1.012 2.475T12.05 15.5Z"
                                          />
                                        </svg>
                                    </div>
                                </c:if>

                            </section>
                            <a href="/webapp/posts?action=get-post&id=${item.id}">
                                <button> &gt;</button>
                            </a>
                            <c:if test="${item.creador.id == sessionScope.user.id}">
                                <a href="/webapp/edit-post?action=edit-post&id=${item.id}">
                                    <button> Edit</button>
                                </a>
                            </c:if>

                        </div>

                        <!--FOOTER--> 
                        <!--TODO Comentarios-->
                        <div class="post-footer-wrapper">
                            <section class="post-footer">
                                <img src="/webapp/assets/images/default-profile.jpg" alt="" />
                                <h1>John Doe</h1>
                                <p>comentario-falso</p>
                                <!--<button>&gt;</button>-->
                            </section>
                        </div>
                    </div>
                </section>
            </c:forEach>

            <div class="right-bar"></div>
        </div>



    </body>
</html>
