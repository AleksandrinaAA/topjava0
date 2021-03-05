package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.DAO.UserDAO;
import ru.javawebinar.topjava.entity.User;
import ru.javawebinar.topjava.mapper.UserMapper;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    public UserDAO userDAO;
    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

    public void update(User user) {
        userDAO.update(user);
    }

}
