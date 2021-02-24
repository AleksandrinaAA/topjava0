package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

//        List<UserMealWithExcess> mealsTo = filteredByCycles(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
//        mealsTo.forEach(System.out::println);

//        List<UserMealWithExcess> mealsTo = filteredByCycles(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
//        mealsTo.forEach(System.out::println);

        System.out.println(filteredByStreams(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000));
    }

    public static List<UserMealWithExcess> filteredByCycles(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO return filtered list with excess. Implement by cycles
        List<UserMealWithExcess> mealsTo = new ArrayList<>();
        boolean excess = false;
        float Calories=0;
        for (int i=0; i<meals.size();i++){
            for (int j=0; j<meals.size();j++){
                if (meals.get(j).getDateTime().getDayOfMonth()==meals.get(i).getDateTime().getDayOfMonth()){
                    Calories+=meals.get(j).getCalories();
                }
            }
            if(TimeUtil.isBetweenHalfOpen(LocalTime.of(meals.get(i).getDateTime().getHour(),meals.get(i).getDateTime().getMinute()),
                    startTime,endTime)){
                if (Calories>caloriesPerDay){
                    excess= true;
                }
                System.out.println(meals.get(i));
                mealsTo.add(new UserMealWithExcess(meals.get(i).getDateTime(),meals.get(i).getDescription(),meals.get(i).getCalories(),excess));

            }
        }

        return mealsTo;
    }

    public static List<UserMealWithExcess> filteredByStreams(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO Implement by streams
        List<UserMeal> mealsTo = new ArrayList<>();
        List<UserMeal> ofCalories = new ArrayList<>();

        Map<LocalDateTime, Integer> map5 = meals.stream()
                .collect(Collectors.groupingBy(UserMeal::getDateTime,
                        Collectors.summingInt(UserMeal::getCalories)));

        meals.stream().filter(m -> TimeUtil.isBetweenHalfOpen(LocalTime.of(m.getDateTime().getHour(),m.getDateTime().getMinute()),
                startTime,endTime)).forEach(m -> mealsTo.add(m));

        return null;
    }
}
