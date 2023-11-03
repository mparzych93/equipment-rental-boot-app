<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Wypożycz, co tylko chcesz!</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<body>
<%@ include file="headerForAdmin.jsp" %>

<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <%@ include file="sidePanelForAdmin.jsp" %>

        <div class="m-4 p-4 width-medium">
            <div class="dashboard-header m-4">
                <div class="dashboard-menu">
                    <div class="menu-item border-dashed">
                        <a href="/app/item/add">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">Wystaw przedmiot</span>
                        </a>
                    </div>
                    <div class="menu-item border-dashed">
                        <a href="/app/item/list">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">Wypożycz przedmiot</span>
                        </a>
                    </div>
                    <div class="menu-item border-dashed">
                        <a href="/app/recipe/plan/add">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">dodaj przepis do planu</span>
                        </a>
                    </div>
                </div>

                <div class="dashboard-alerts">
                    <div class="alert-item alert-info">
                        <i class="fas icon-circle fa-info-circle"></i>
                        <span class="font-weight-bold">Liczba moich przedmiotów: <c:out value="${quantityOfItems}" /></span>
                    </div>
                    <div class="alert-item alert-light">
                        <i class="far icon-calendar fa-calendar-alt"></i>
                        <span class="font-weight-bold">Liczba przedmiotów, które wypożyczyłem od kogoś: <c:out value="${quantityOfRentals}" /></span>
                    </div>
                </div>
            </div>
            <div class="m-4 p-4 border-dashed">
                <h2 class="dashboard-content-title">
                    <span>Wypożyczone przedmioty, które powinny być zwrócone:</span>
                </h2>
                <table class="table">
                    <thead>
                    <tr class="d-flex">
                        <th class="col-2">Moje wypożyczenia</th>
                        <th class="col-8"></th>
                        <th class="col-1"></th>
                        <th class="col-1"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${expiredRentals}" var="expiredRental">
                    <tr class="d-flex">
                        <td class="col-2">${expiredRental.item.name}</td>
                        <td class="col-8">${expiredRental.created}</td>
                        <td class="col-1"><button type="button" class="btn btn-primary rounded-0">Zakończ</button></td>
                        <td class="col-1"><button type="button" class="btn btn-primary rounded-0">Przedłuż</button></td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <table class="table">
                    <thead>
                    <tr class="d-flex">
                        <th class="col-2">Moje produkty</th>
                        <th class="col-8"></th>
                        <th class="col-2"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${expiredRentalsOfMyItems}" var="expiredRentalOfMyItem">
                    <tr class="d-flex">
                        <td class="col-2">${expiredRentalOfMyItem.item.name}</td>
                        <td class="col-8">${expiredRentalOfMyItem.created}</td>
                        <td class="col-2"><button type="button" class="btn btn-primary rounded-0">Zgłoś</button></td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>