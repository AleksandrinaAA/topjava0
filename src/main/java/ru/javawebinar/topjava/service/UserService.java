package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.entity.User;

import java.util.List;


public interface UserService {

    List<User> findAll();

    void save(User user);

    User getById(int id);

    void delete(int id);

    void update(User user);

}
