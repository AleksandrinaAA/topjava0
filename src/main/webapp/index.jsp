<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 28.02.2021
  Time: 00:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Meal</title>
</head>
<body>
<h2>Meals</h2>
<p><a href='<c:url value="/create" />'>Add meal</a></p>
<table>
    <tr><th>Date</th><th>Description</th><th>Calories</th><th></th></tr>
    <c:forEach var="meal" items="${meals}">
        <tr><td>${meal.date}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td>
                <a href='<c:url value="/edit?id=${meal.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${meal.id}">
                    <input type="submit" value="Delete">
                </form>
            </td></tr>
    </c:forEach>
</table>
</body>
</html>