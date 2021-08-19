<%--
  Created by IntelliJ IDEA.
  User: Martusichka
  Date: 29.03.2021
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
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
<form action="${pageContext.request.contextPath}/hotelList" method="post">
    <div class="date">
        <div class="form-group">
            <div class="form-outline">
                <label>Select a city</label>
                <select name="city" class="form-control">
                    <c:forEach var="city" items="${cityList}">
                        <option>${city.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label>Date of entry</label>
            <input type="date" name="entry" max="3000-12-31"
                   min="1000-01-01" class="form-control">
        </div>
        <div class="form-group">
            <label>Date of departure</label>
            <input type="date" name="departure" min="1000-01-01"
                   max="3000-12-31" class="form-control">
        </div>
        <div class="form-group">

            <button style="width: 100%; height: 65px;" type="submit"><i class="fa fa-search"></i></button>

        </div>
    </div>
</form>
<jsp:include page="footer.jsp"/>
<br>
</body>
</html>
