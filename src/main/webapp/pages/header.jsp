<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="container header">

    <a href="./index.html"> <img src="../images/mylogo2.png" width="85" height="65" alt="Logo" class="rightpic"></a>
    <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">

        </a>

        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a href="${pageContext.request.contextPath}/" class="nav-link px-2 link-secondary">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/allHotels" class="nav-link px-2 link-dark">All hotels</a>
            </li>
            <%
                Long userID = (Long) session.getAttribute("id");
                if (userID != null) {
            %>
            <li><a href="${pageContext.request.contextPath}/favorite" class="nav-link px-2 link-dark">Favorites</a></li>
            <li><a href="${pageContext.request.contextPath}/YourBooking" class="nav-link px-2 link-dark">My bookings</a>
            </li>
            <% }%>
            <li><a href="/addOwnObject" class="nav-link px-2 link-dark">Add own object</a></li>
        </ul>

        <div class="col-md-3 text-end">
            <%
                Long userId = (Long) session.getAttribute("id");
                if (userId == null) {
            %>
            <a href="/login">
                <button type="button" class="btn btn-outline-primary me-2">Login</button>
            </a>
            <a href="/registration">
                <button id="singUp" type="button" class="btn btn-primary">Sing-up</button>
            </a>
            <% } else { %>

            <a href="/logout">
                <button id="logout" type="button" class="btn btn-primary">Logout</button>
            </a>
            <% }%>
        </div>

    </div>
</div>

</body>
</html>
