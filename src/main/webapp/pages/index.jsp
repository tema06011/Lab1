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
<head >
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="/css/index.css" rel="stylesheet" type="text/css">
    <style>
        .rightpic {
            float: left; /* Выравнивание по правому краю */
        }
        .form-group{overflow:hidden;width:200px}

        .box div{width:90px;display:inline-block;border:1px solid black}
        .form-group{
            background: #eee;
            border: 1px solid #ccc;
            padding: 10px;
            float: left;
            width: 23.5%;
            margin-right: 2%;
            margin-left: 0;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
        }
        .form-group:last-child {
            margin-right: 0;
            margin-left: 0;
        }
        .date{
            margin-top: 10%;
            margin-bottom: 15%;
            margin-left: 10%;
            margin-right: 10%;
            background: aliceblue;
        }
        .btn{
            margin-left: 20px;
        }
        form.example button {
            float: left;
            width: 44%;
            height: 12%;
            padding: 0px;
            background: #2196F3;
            color: white;
            font-size: 40px;
            border: 1px solid grey;
            border-left: none; /* Prevent double borders */
            cursor: pointer;
        }


    </style>

</head>

<body>
<div class="container header" >

    <a href="./index.html"> <img src="../images/mylogo2.png" width="85" height="65" alt="Logo" class="rightpic"></a>
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">

        </a>

        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a href="#" class="nav-link px-2 link-secondary">Home</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">All hotels</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">Favourites</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">Your bookings</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">Add own object</a></li>
        </ul>

        <div class="col-md-3 text-end">
            <button type="button" class="btn btn-outline-primary me-2">Login</button>
            <button type="button" class="btn btn-primary">Sign-up</button>
        </div>
    </header>
</div>

<div class="date">
    <div class="form-group">
        <div class="form-outline">
            <label >Enter the city</label>
            <input type="search" id="form1" class="form-control" placeholder="City"
                   aria-label="Search" aria-describedby="search-addon" />
        </div>
    </div>
<div class="form-group">
    <label >Date of entry</label>
    <input type="date" name="bday" max="3000-12-31"
           min="1000-01-01" class="form-control">
</div>
<div class="form-group">
    <label >Date of departure</label>
    <input type="date" name="bday" min="1000-01-01"
           max="3000-12-31" class="form-control">
</div>
    <div class="form-group">
        <form class="example" action="action_page.php">
        <button style="width: 100%; height: 65px;" type="submit"><i class="fa fa-search"></i></button>
    </form>
    </div>
</div>
<jsp:include page="footer.jsp" />
<br>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<!--<c:forEach var="hotel" items="${hotelList}">
    <h1>${hotel.name}</h1>
    <h1>${hotel.starAmount}</h1>
    <h1>${hotel.city}</h1>
    <h1>${hotel.street}</h1>
    <h1>${hotel.numberOfBuilding}</h1>
    <h1>${hotel.phoneNumber}</h1>
</c:forEach>-->

</body>
</html>
