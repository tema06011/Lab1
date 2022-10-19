<%--
  Created by IntelliJ IDEA.
  User: Martusichka
  Date: 02.07.2021
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Your bookings</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/yourBookings.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<p class="heead">Your bookings: </p>
<table class="tableBook">
    <c:forEach var="bookingDTO" items="${requestScope.bookingList}">
    <table class="tableBook">
        <tr>
            <th class="th">Hotel name</th>
            <td class="td">${bookingDTO.hotelName}</td>
        </tr>
        <tr>
            <th class="th">Start living</th>
            <td class="td">${bookingDTO.start}</td>
        </tr>
        <tr>
            <th class="th">End Living</th>
            <td class="td">${bookingDTO.end}</td>
        </tr>
        <tr>
            <th class="th">Room</th>
            <td class="td">${bookingDTO.categoryName}</td>
        </tr>
        <tr>
            <th class="th">Payment type</th>
            <td class="td">${bookingDTO.paymentTypeId}</td>
        </tr>
        <tr>
            <th class="th">Price for night</th>
            <td class="td">${bookingDTO.cost}</td>
        </tr>
    </table>
    </c:forEach>
    <div class="behindfooter"></div>
    <jsp:include page="footer.jsp"/>
</body>
</html>
