<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ page import="ru.javawebinar.topjava.model.ListOfMeals" %>
<%@ page import="ru.javawebinar.topjava.model.UserMealWithExcess" %>
<%@ page import="java.util.List" %>

<%@ page import="java.awt.*" %><%--
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
<%--<a href='<c:url value="create" />'>Add meal</a>--%>
<a href="create.jsp">Add meal</a>
<table border="1">
    <tr><th>dateTime</th><th>description</th><th>calories</th><th>exceed</th><th></th></tr>
<%--    <jsp:useBean id="meals" scope="request" type="java.util.List"/>--%>
<%--    <c:forEach items="${meals}" var="meal">--%>
<%--        <tr style="background-color:${meal.exceed ? 'greenyellow' : 'red'}">--%>
<%--            <td>--%>
<%--                <fmt:parseDate value="${ meal.Date }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime"--%>
<%--                               type="both"/>--%>
<%--                <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${ parsedDateTime }"/>--%>
<%--            </td>--%>
<%--            <td><c:out value="${meal.Description}"/></td>--%>
<%--            <td><c:out value="${meal.Calories}"/></td>--%>
<%--&lt;%&ndash;            <td><c:out value="${meal.exceed}"/></td>&ndash;%&gt;--%>
<%--            <td>--%>
<%--                <a href='<c:url value="/edit?id=${meal.id}" />'>Edit</a> |--%>
<%--                <form method="post" action='<c:url value="/delete" />' style="display:inline;">--%>
<%--                    <input type="hidden" name="id" value="${meal.id}">--%>
<%--                    <input type="submit" value="Delete">--%>
<%--                </form>--%>
<%--            </td></tr>--%>
<%--    </c:forEach>--%>

    <c:forEach items="${meals}" var="element">
        <jsp:useBean id="element" type="ru.javawebinar.topjava.model.UserMealWithExcess"/>
<%--        <tr>--%>
        <tr style="color:${element.excess ? 'greenyellow' : 'red'}">
<%--        <tr>--%>
            <td>
                <fmt:parseDate value="${ element.dateTime}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${ parsedDateTime }" />
            </td>
            <td>${element.description}</td>
            <td>${element.calories}</td>
            <td><a href="">Update</a></td>
            <td><a href="">Delete</a></td>
        </tr>
    </c:forEach>
<%--        <tr><td>${meal.date}</td>--%>
<%--            <td>${meal.description}</td>--%>
<%--            <td>${meal.calories}</td>--%>
<%--            <td>--%>
<%--                <a href='<c:url value="/edit?id=${meal.id}" />'>Edit</a> |--%>
<%--                <form method="post" action='<c:url value="/delete" />' style="display:inline;">--%>
<%--                    <input type="hidden" name="id" value="${meal.id}">--%>
<%--                    <input type="submit" value="Delete">--%>
<%--                </form>--%>
<%--            </td></tr>--%>

<%--    <% //MealsUtil MealToForUser = (MealsUtil) request.getAttribute("meals");--%>
<%--        List<UserMealWithExcess> listMealToForUser = (List<UserMealWithExcess>) request.getAttribute("meals");--%>
<%--        for (int i = 0; i < listMealToForUser.size(); i++) {--%>
<%--            //MealTo oneMealTo = listMealToForUser.get(i);--%>
<%--            out.println(--%>
<%--                    "<tr>" +--%>
<%--                            "<td><font  color=" + (listMealToForUser.get(i).isExcess() ? "greenyellow" : "red") + ">" + listMealToForUser.get(i).getDateTime().toString().split("T")[0] +--%>
<%--                            " " + listMealToForUser.get(i).getDateTime().toString().split("T")[1] + "</font></td>" +--%>
<%--                            "<td><font  color=" + (listMealToForUser.get(i).isExcess() ? "greenyellow" : "red") + ">" + listMealToForUser.get(i).getDescription() + "</font></td>" +--%>
<%--                            "<td><font  color=" + (listMealToForUser.get(i).isExcess() ? "greenyellow" : "red") + ">" + Integer.toString(listMealToForUser.get(i).getCalories()) + "</font></td>" +--%>
<%--                            "<td><input type=\"radio\" name=\"edit\" value=edit\"" + (i + 1) + "\">" + (i + 1) + "</td>" +--%>
<%--                            "<td><input type=\"radio\" name=\"delete\" value=delete\"" + (i + 1) + "\">" + (i + 1) + "</td>" +--%>
<%--                            "</tr>");--%>
<%--        }--%>
<%--    %>--%>
</table>
</body>
</html>