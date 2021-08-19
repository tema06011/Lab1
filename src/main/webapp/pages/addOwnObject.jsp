<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add own object</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/addOwnObject.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<form method="post" action="${pageContext.request.contextPath}/addOwnObject" enctype="multipart/form-data">
    <center>
        <table border="1" width="30%" cellpadding="5" class="tableAddOwnObject">
            <thead>
            <tr>
                <th colspan="2">Enter Information Here</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value=""/></td>
            </tr>
            <tr>
                <td>Star amount:</td>
                <td><input type="text" name="star_amount" value=""/></td>
            </tr>
            <tr>
                <td>Street:</td>
                <td><input type="text" name="street"></td>
            </tr>
            <tr>
                <td>Number of building:</td>
                <td><input type="text" name="number_of_building"></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><select name="cityName" id="cityID" class="form-control">
                    <c:forEach var="city" items="${cityList}">
                        <option>${city.name}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td>Phone number:</td>
                <td><input type="text" id="phone_number" name="phone_number"></td>
            </tr>
            <tr>
                <td>Photo:</td>
                <td><input type="file" name="photo" multiple="true"></td>
            </tr>
            <tr>
                <td>About</td>
                <td><input type="text" name="about"></td>
            </tr>
            <tr>
                <td><c:forEach var="category" items="${categoryArrayList}">
                    <option>${category.name}</option>

                    <input type="text" name="cost${category.name}">

                </c:forEach></td>

            </tr>
            <tr>
                <td><input class="btn_singUp" type="submit" value="Create"/></td>
                <td><input class="btn_reset" type="reset" value="Reset"/></td>
            </tr>
            </tbody>
        </table>
    </center>
</form>
</body>
<jsp:include page="footer.jsp"/>
</html>
