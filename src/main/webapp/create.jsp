<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 28.02.2021
  Time: 00:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add meal</title>
</head>
<%--<form action="index">--%>
<%--    <a href="index.jsp">back</a>--%>
<%--</form>--%>
<body>
<h3>Add meal</h3>
<form action="create" method="post">
    <label>DateTime</label><br>
    <input name="DateTime" type="datetime-local"/><br><br>
    <label>Description</label><br>
    <input name="Description"/><br><br>
    <label>Calories</label><br>
    <input name="Calories" type="number"/><br><br>
    <input type="submit" value="Save" />
</form>
</body>
</html>
