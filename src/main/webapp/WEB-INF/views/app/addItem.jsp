<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Wypożycz, co tylko chcesz!</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<body>
<%@ include file="headerForAdmin.jsp" %>

<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <%@ include file="sidePanelForAdmin.jsp" %>

        <div class="m-4 p-3 width-medium text-color-darker">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <!-- fix action, method -->
                <!-- add name attribute for all inputs -->
                <form:form action="/app/item/add" method="post" modelAttribute="item">
                    <div class="mt-4 ml-4 mr-4">
                        <div class="row border-bottom border-3">
                            <div class="col"><h3 class="color-header text-uppercase">Nowy przedmiot</h3></div>
                            <div class="col d-flex justify-content-end mb-2">
                                <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Wystaw</button>
                            </div>
                        </div>

                        <table class="table borderless">
                            <tbody>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Nazwa przedmiotu</th>
                                <td class="col-7">
                                    <form:input path="name" class="w-100 p-1" value="" />
                                    <form:errors path="name" />
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Opis przedmiotu</th>
                                <td class="col-7">
                                    <form:textarea path="description" class="w-100 p-1" rows="5"></form:textarea>
                                    <form:errors path="description" />
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Minimalny okres wypożyczenia (dni)</th>
                                <td class="col-3">
                                    <form:input path="minimumRentalPeriodInDays" class="p-1" type="number" value="" />
                                    <form:errors path="minimumRentalPeriodInDays" />
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Koszt wynajmu (PLN/dzień)</th>
                                <td class="col-3">
                                    <form:input path="rentalCostPerDay" class="p-1" type="number" value="" />
                                    <form:errors path="rentalCostPerDay" />
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Kaucja zwrotna (PLN)</th>
                                <td class="col-3">
                                    <form:input path="refundableDeposit" class="p-1" type="number" value="" />
                                    <form:errors path="refundableDeposit" />
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Kwota za opóźnienie (PLN/dzień)</th>
                                <td class="col-3">
                                    <form:input path="amountForDelay" class="p-1" type="number" value="" />
                                    <form:errors path="amountForDelay" />
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Kategoria</th>
                                <td class="col-3">
                                    <form:select itemValue="id" itemLabel="name" path="category.id" items="${categories}" class="p-1" />
                                </td>
                            </tr>
                            </tbody>
                        </table>

                        <div class="row d-flex">
                            <div class="col-5 border-bottom border-3"><h3 class="text-uppercase">Uwagi</h3></div>
                            <div class="col-2"></div>
                        </div>
                        <div class="row d-flex">
                            <div class="col-5 p-4">
<%--                                <form:textarea path="pickupAddress" class="w-100 p-1" rows="10"></form:textarea>--%>
                            </div>
                            <div class="col-2"></div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>
<%@ include file="../footer.jsp" %>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>
