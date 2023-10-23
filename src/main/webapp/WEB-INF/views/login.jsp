<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                <form method="post">
                    <h1 class="text-color-darker">Logowanie</h1>
                    <div class="form-group">
                        <input type="text" class="form-control" id="username" name="username" placeholder="podaj Twoj login">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="password" name="password" placeholder="podaj hasło">
                    </div>
                    <button class="btn btn-color rounded-0" type="submit">Zaloguj</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </div>
    </div>
</section>

<%@ include file="footer.jsp" %>

</body>
</html>
