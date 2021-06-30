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

</head>
<body>
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
                <td><input type="text" name="login" value="" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="pass" value="" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Login" class="login" /></td>
                <td><input type="reset" value="Reset" class="reset" /></td>
            </tr>
            <tr>
                <td colspan="2">Yet Not Registered!! <a href="register.jsp">Register Here</a></td>
            </tr>
            </tbody>
        </table>
    </center>
</form>
</body>
</html>
