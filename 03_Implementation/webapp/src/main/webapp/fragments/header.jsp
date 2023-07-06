<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link rel="stylesheet" href="/webapp/assets/css/fragments/header.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
</head>
<header id="header-body">
    <div class="container-header">
        
        <div class="item-header">
            <c:if test="${sessionScope.user != null}">
                <c:if test="${sessionScope.user.nombreCompleto.nombres != null}">
                    <span id="user-email">Welcome Back, ${sessionScope.user.nombreCompleto.nombres}!</span>
                </c:if>
                    <c:if test="${sessionScope.user.nombreCompleto.nombres == null}">
                    <span id="user-email">Welcome Back, ${sessionScope.user.email}!</span>
                </c:if>
            </c:if>
        </div>
        <div class="item-header"><a class="home-link" href="./home">STRIX</a></div>
        <div class="item-header" id="btn-container">
            <button id="btn-edit">
                <a href="/webapp/edit-user"> 
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                        <path fill="currentColor" d="M12 4a4 4 0 0 1 4 4a4 4 0 0 1-4
                              4a4 4 0 0 1-4-4a4 4 0 0 1 4-4m0 10c4.42 0 8 1.79 8 4v2H4v-2c0-2.21 3.58-4 8-4Z" />
                    </svg> </a></button>
            <button id="btn-logout">
                <a href="/webapp/auth?action=logout">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                        <g fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                           stroke-width="2">
                            <path d="M14 8V6a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h7a2 2 0 0 0 2-2v-2" />
                            <path d="M9 12h12l-3-3m0 6l3-3" />
                        </g>
                    </svg></a></button>
        </div>
    </div>
</header>

