package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.ListOfMeals;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;
import ru.javawebinar.topjava.util.UserMealsUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<UserMeal> meals = ListOfMeals.mealsTo;
        List<UserMealWithExcess> mealsWithExcess = UserMealsUtil.filteredByStreams(meals,LocalTime.of(0, 0), LocalTime.of(23, 0), 2000);
        request.setAttribute("meals", mealsWithExcess);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
//        response.sendRedirect("index.jsp");
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        log.debug("redirect to users");
//
////        request.getRequestDispatcher("/users.jsp").forward(request, response);
//        response.sendRedirect("index.jsp");
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
