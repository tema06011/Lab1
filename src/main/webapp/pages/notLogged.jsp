<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>You are not logged</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/notLogged.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="notLogg">
    <p>You are not logged...</p>
</div>
<div class="login">
    <p>Login here..</p>
    <a href="/login">
        <button type="button" class="btn btn-outline-primary me-2">Login</button>
    </a>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
