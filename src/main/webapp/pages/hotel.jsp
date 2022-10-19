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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/hotel.css">
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
<img src='data:image/jpeg;base64,${hotelDTO.photo}' class="pic"/>
<h4 class="aboutHotel">${hotelDTO.about}</h4>
<h5 class="adressHotel">You can find us:</h5>
<h2 class="adress">${hotelDTO.cityName}, ${hotelDTO.street} ${hotelDTO.numberOfBuilding}</h2>
<form action="/favorite" >
    <input type="hidden" name="hotelName" value="${hotelDTO.hotelName}">
    <button class="button_favorite"><i id="heart" class="far fa-heart"></i></button>
</form>
<h3 class="number">You can call us: <br>
    <a href="tel:${hotelDTO.phoneNumber}">${hotelDTO.phoneNumber}</a>
</h3>
<div>
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
    <!-- Trigger/Open The Modal -->
    <button class="button_modal" id="myBtnBook">Book</button>

    <!-- The Modal -->
    <div id="myModalBook" class="modal">

        <!-- Modal content -->
        <div class="modal-content">
            <span class="close">&times;</span>
            <p>
            <form method="post" action="/booking">
                <input type="hidden" name="hotelName" id="hotelName" value="${hotelDTO.hotelName}">
                <label>Date of entry</label>
                <input type="date" name="entry" max="3000-12-31"
                       min="1000-01-01" class="form-control">
                <label>Date of departure</label>
                <input type="date" name="departure" min="1000-01-01"
                       max="3000-12-31" class="form-control">
                <label>Select Payment Type:</label><br>
                <select name="paymentType" class="form-control">
                    <c:forEach var="paymentType" items="${requestScope.paymentList}">
                        <option>${paymentType.name}</option>
                    </c:forEach>
                </select>
                <label>Select category:</label><br>
                <select name="category" class="form-control">
                    <c:forEach var="room" items="${requestScope.roomList}">
                        <option>${room.category.name}--->${room.cost}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Book">

            </form>
            </p>
        </div>

    </div>

    <script>
        // Get the modal
        var modal = document.getElementById("myModalBook");

        // Get the button that opens the modal
        var btn = document.getElementById("myBtnBook");

        // Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close")[0];

        // When the user clicks the button, open the modal
        btn.onclick = function () {
            modal.style.display = "block";
        }

        // When the user clicks on <span> (x), close the modal
        span.onclick = function () {
            modal.style.display = "none";
        }

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function (event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    </script>

</div>
<div class="feedback">
    <form action="/hotel" method="post">
        <p class="feedback_head"><b>Enter your feedback:</b></p>
        <input type="hidden" name="hotelName" id="hotelLName" value="${hotelDTO.hotelName}">
        <div class="rating-area">
            <input type="radio" id="star-5" name="rating" value="5">
            <label for="star-5" title="Оценка «5»"></label>
            <input type="radio" id="star-4" name="rating" value="4">
            <label for="star-4" title="Оценка «4»"></label>
            <input type="radio" id="star-3" name="rating" value="3">
            <label for="star-3" title="Оценка «3»"></label>
            <input type="radio" id="star-2" name="rating" value="2">
            <label for="star-2" title="Оценка «2»"></label>
            <input type="radio" id="star-1" name="rating" value="1">
            <label for="star-1" title="Оценка «1»"></label>
        </div>
        <p><textarea rows="10" cols="45" name="feedback"></textarea></p>
        <p><input type="submit" value="Send"></p>
    </form>
</div>
<div class="usersFeedback">
    <div class="headFeedback">
        <strong>Feedback</strong>
    </div>
    <c:choose>
        <c:when test="${empty feedbackList }">
            <p class="no_comments">No comments...</p>

        </c:when>
        <c:otherwise>
            <div class="starFeedback">
            <c:forEach var="feedback" items="${feedbackList}">
                <script>
                    for (var i = 1; i <=${feedback.starAmount}; i++) {
                        document.write('<i  class="fas fa-star fa-1x" ></i>');
                    }
                </script>
                </div>
                <div class="feedbackAbout">
                        ${feedback.feedback}
                </div>
            </c:forEach>

        </c:otherwise>
    </c:choose>

</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
