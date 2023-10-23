<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="pl">

<head>
    <title>Wypożycz, co tylko chcesz!</title>
</head>

<body>
<%@ include file="header.jsp" %>
<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-25">
                <sec:authorize access="isAuthenticated()">
                <form action="<c:url value="/logout"/>" method="post">
                    <input class="fa fa-id-badge" type="submit" value="Wyloguj">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                </sec:authorize>
            </div>
        </div>
    </div>
</section>

<%@ include file="footer.jsp" %>

</body>
</html>
