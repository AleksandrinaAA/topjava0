package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> meals = Arrays.asList(
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
        );

        List<UserMealWithExcess> mealsTo = filteredByCycles(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        mealsTo.forEach(System.out::println);

//        System.out.println(filteredByStreams(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000));
    }

    public static List<UserMealWithExcess> filteredByCycles(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

        Map<LocalDate,Integer> caloriesSumPerDay = new HashMap<>();
        meals.forEach(meal -> caloriesSumPerDay.merge(meal.getDateTime().toLocalDate(),meal.getCalories(),(c1,c2)-> c1+c2));

        List<UserMealWithExcess> mealExcess = new ArrayList<>();
        for (UserMeal meal :meals){
            LocalDateTime dateTime = meal.getDateTime();
            if(TimeUtil.isBetweenHalfOpen(dateTime.toLocalTime(),startTime,endTime)){
                mealExcess.add(new UserMealWithExcess(dateTime,meal.getDescription(),meal.getCalories(),
                        caloriesSumPerDay.get(dateTime.toLocalDate())>caloriesPerDay));
            }
        }
//        List<UserMealWithExcess> mealsTo = new ArrayList<>();
//        boolean excess = false;
//        float Calories=0;
//        for (int i=0; i<meals.size();i++){
////            Cycles усложняют код. Смотри TimeComplexity
//            for (int j=0; j<meals.size();j++){
//                if (meals.get(j).getDateTime().getDayOfMonth()==meals.get(i).getDateTime().getDayOfMonth()){
//                    Calories+=meals.get(j).getCalories();
//                }
//            }
//            if(TimeUtil.isBetweenHalfOpen(LocalTime.of(meals.get(i).getDateTime().getHour(),meals.get(i).getDateTime().getMinute()),
//                    startTime,endTime)){
//                if (Calories>caloriesPerDay){
//                    excess= true;
//                }
//                System.out.println(meals.get(i));
//                mealsTo.add(new UserMealWithExcess(meals.get(i).getDateTime(),meals.get(i).getDescription(),meals.get(i).getCalories(),excess));
//
//            }
//        }

        return mealExcess;
    }

    public static List<UserMealWithExcess> filteredByStreams(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

        List<UserMealWithExcess> ListUserMealWithExcess = new ArrayList<>();

        Map<LocalDate, Integer> caloriesSumByDay = meals.stream()
                .collect(Collectors.groupingBy(user -> user.getDateTime().toLocalDate(),
                        Collectors.summingInt(UserMeal::getCalories)));

        return meals.stream().filter(meal -> TimeUtil.isBetweenHalfOpen(meal.getDateTime().toLocalTime(), startTime, endTime))
                .map(meal -> new UserMealWithExcess(meal.getDateTime(), meal.getDescription(), meal.getCalories(),
                        caloriesSumByDay.get(meal.getDateTime().toLocalDate()) > caloriesPerDay))
                .collect(Collectors.toList());
    }
}
