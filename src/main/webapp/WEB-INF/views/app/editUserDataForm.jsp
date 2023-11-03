<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<body>
<%@ include file="headerForAdmin.jsp" %>

<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <%@ include file="sidePanelForAdmin.jsp" %>

        <div class="m-4 p-3 width-medium text-color-darker">
            <div class="m-4 border-dashed view-height">
                <!-- fix action, method -->
                <!-- add name attribute for all inputs -->
                <form:form action="/app/edit/userData" method="post" modelAttribute="userToEditDataDto">
                    <div class="mt-4 ml-4 mr-4">
                        <div class="row border-bottom border-3">
                            <div class="col"><h3 class="color-header text-uppercase">Edytuj dane</h3></div>
                            <div class="col d-flex justify-content-end mb-2">
                                <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz
                                </button>
                            </div>
                        </div>

                        <table class="table borderless">
                            <tbody>
                            <tr class="d-flex">
                                <th scope="row" class="col-2"><h4>Imię</h4></th>
                                <td class="col-7">
                                    <form:input class="w-100 p-1" value="${userToEditDataDto.firstName}" path="firstName" />
                                    <form:errors path="firstName" />
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2"><h4>Nazwisko</h4></th>
                                <td class="col-7">
                                    <form:input class="w-100 p-1" value="${userToEditDataDto.lastName}" path="lastName" />
                                    <form:errors path="lastName" />
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2"><h4>Województwo</h4></th>
                                <td class="col-3">
                                    <form:input class="p-1 w-100" type="text" value="${userToEditDataDto.address.voivodeship}" path="address.voivodeship" />
                                    <form:errors path="address.voivodeship" />
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2"><h4>Miasto</h4></th>
                                <td class="col-3">
                                    <form:input class="p-1 w-100" type="text" value="${userToEditDataDto.address.city}" path="address.city" />
                                    <form:errors path="address.city" />
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2"><h4>Kod pocztowy</h4></th>
                                <td class="col-3">
                                    <form:input class="p-1 w-100" type="text" value="${userToEditDataDto.address.postalCode}" path="address.postalCode" />
                                    <form:errors path="address.postalCode" />
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2"><h4>Ulica</h4></th>
                                <td class="col-3">
                                    <form:input class="p-1 w-100" type="text" value="${userToEditDataDto.address.street}" path="address.street" />
                                    <form:errors path="address.street" />
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2"><h4>Numer ulicy</h4></th>
                                <td class="col-3">
                                    <form:input class="p-1 w-100" type="text" value="${userToEditDataDto.address.streetNumber}" path="address.streetNumber" />
                                    <form:errors path="address.streetNumber" />
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2"><h4>Numer lokalu</h4></th>
                                <td class="col-3">
                                    <form:input class="p-1 w-100" type="text" value="${userToEditDataDto.address.apartmentNumber}" path="address.apartmentNumber" />
                                    <form:errors path="address.apartmentNumber" />
                                </td>
                            </tr>

                            </tbody>
                        </table>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

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