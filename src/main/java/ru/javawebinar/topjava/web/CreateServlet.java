package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.ListOfMeals;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class CreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
//        response.sendRedirect( "/create");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("DateTime"));
            String description = request.getParameter("Description");
            int calories = Integer.parseInt(request.getParameter("Calories"));

            ListOfMeals.mealsTo.add(new UserMeal(dateTime,description,calories));
//            request.setAttribute("meals",ListOfMeals.mealsTo);
//            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            response.sendRedirect("index");
        }
        catch(Exception ex) {
            System.out.println("Mistake");
            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }
}