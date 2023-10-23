<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>

<body>
<%@ include file="headerForAdmin.jsp" %>
<section>
    <div class="row padding-small">
        <i class="fas fa-users icon-users"></i>
        <h1>Moje wypożyczenia:</h1>
        <hr>
        <div class="orange-line w-100"></div>
    </div>
</section>

<section class="mr-4 ml-4">
    <table class="table">
        <thead>
        <tr class="d-flex text-color-darker">
            <th scope="col" class="col-1">ID</th>
            <th scope="col" class="col-5">NAZWA PRZEDMIOTU</th>
            <th scope="col" class="col-5">OD KIEDY</th>
            <th scope="col" class="col-1">AKCJE</th>
        </tr>
        </thead>
        <tbody class="text-color-lighter">
        <c:forEach var = "userRental" items="${userRentals}">
            <tr class="d-flex">
                <th scope="row" class="col-1"><c:out value="${userRental.id}"/></th>
                <td class="col-5"><c:out value="${userRental.item.name}"/></td>
                <td class="col-5"><c:out value="${userRental.created}"/></td>
                <td class="col-1 d-flex align-items-center justify-content-center flex-wrap">
                    <a href="/app/recipe/delete/${userRental.id}" class="btn btn-danger rounded-0 text-light m-1">Zakończ</a>
                    <a href="/app/recipe/extend/${userRental.id}" class="btn btn-info rounded-0 text-light m-1">Przedłuż</a>
                    <a href="/#" class="btn btn-warning rounded-0 text-light m-1">???</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<section class="last-info-section padding-small">
    <div class="container">
        <div class="row">
            <div class="col">
                <h3 class="mb-4">Lorem ipsum dolor</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at porttitor sem.  Aliquam erat volutpat. Donec placerat nisl magna.</p>
            </div>
            <div class="col pl-4 ml-4">
                <h3 class="mb-4">Lorem ipsum dolor</h3>
                <ul class="container">
                    <li>consectetur adipiscing elit</li>
                    <li>sed do eiusmod tempor</li>
                    <li>incididunt ut labore</li>
                    <li>et dolore magna aliqua</li>
                </ul>
            </div>
            <div class="col">
                <h3 class="mb-4">Lorem ipsum dolor</h3>
                <div class="input-group mb-3">
                    <input type="text" class="form-control border-0 rounded-0" placeholder=""
                           aria-label="Recipient's username" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                        <button class="input-group-text btn-color border-0 rounded-0" type="submit" id="basic-addon2"><a href="index.html">Lorem</a></button>
                    </div>
                </div>
                <div class="container d-flex-row">
                    <a href="#">
                        <i class="fab fa-facebook-square mr-4 icon-social"></i>
                    </a>
                    <a href="#">
                        <i class="fab fa-twitter-square mr-4 icon-social"></i>

                    </a>
                    <a href="#">
                        <i class="fab fa-instagram icon-social"></i>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>
<%@ include file="../footer.jsp" %>
</body>
</html>