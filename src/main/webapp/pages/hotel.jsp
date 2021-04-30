<%--
  Created by IntelliJ IDEA.
  User: Martusichka
  Date: 15.04.2021
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">-->
    <link href="<c:url value='../css/hotel.css'/>" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css">
    <link href="<c:url value='../css/hotel.css'/>" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="header.jsp"/>

<h1 class="nameHotel">${hotelDTO.hotelName}</h1>
<h4 class="starr">
    <script>
        for (var i = 1; i <=${hotelDTO.starAmount}; i++) {
            document.write('<i  class="fas fa-star fa-2x" ></i>');
        }
    </script>
</h4>
<img src="${hotelDTO.photo}" class="pic"/>
<h4 class="aboutHotel">${hotelDTO.about}</h4>
<h5 class="adressHotel">You can find us:</h5>
<h2 class="adress">${hotelDTO.cityName}, ${hotelDTO.street} ${hotelDTO.numberOfBuilding}</h2>
<h3 class="number">You can call us:  <br>
<a  href="tel:${hotelDTO.phoneNumber}">${hotelDTO.phoneNumber}</a>
</h3>
<h6 class="price">
<table class="table">
    <tr>
        <th class="th">Category</th>
        <th class="th">Price</th>
    </tr>

    <c:forEach var="room" items="${requestScope.roomList}">
        <tr>
            <td class="td">${room.category.name}</td>
            <td class="td">${room.cost}</td>
        </tr>
    </c:forEach>
</table>
</h6>
<jsp:include page="footer.jsp"/>
</body>
</html>
