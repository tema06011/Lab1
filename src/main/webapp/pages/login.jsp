<%--
  Created by IntelliJ IDEA.
  User: Martusichka
  Date: 25.06.2021
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<form method="post" action="${pageContext.request.contextPath}/login">
    <center>
        <table border="1" width="30%" cellpadding="3">
            <thead>
            <tr>
                <th colspan="2">Login Here</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Login</td>
                <td><input type="text" name="login" value=""/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" value=""/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Login" class="login"/></td>
                <td><input type="reset" value="Reset" class="reset"/></td>
            </tr>
            <tr>
                <td colspan="2">Yet Not Registered!! <a href="register.jsp">Register Here</a></td>
            </tr>
            </tbody>
        </table>
    </center>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
