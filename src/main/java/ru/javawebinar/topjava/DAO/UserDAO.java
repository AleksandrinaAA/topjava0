package ru.javawebinar.topjava.DAO;

import ru.javawebinar.topjava.entity.User;

import java.util.List;

//доступ к базе данных
public interface UserDAO {

    void save(User user);

    User getById(int id);

    void delete(int id);

    void update(User user);

    List <User> findAll();

}
