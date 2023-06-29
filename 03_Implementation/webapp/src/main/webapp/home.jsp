<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="myVariable" value="Hello from the main JSP page" />
        <c:set var="requestScope.myAttribute" value="${myVariable}" />


        <jsp:include page="/fragments/header.jspf" />

        <!--TODO render 3 posts-->
        <c:forEach var="item" items="${requestScope.posts}">
            <p>${item}</p>
        </c:forEach>


        <jsp:include page="/fragments/footer.jspf" />
    </body>
</html>
