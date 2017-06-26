package com.softserve.edu.service_center_new.service.impl;

import com.softserve.edu.service_center_new.dao.UserDAO;
import com.softserve.edu.service_center_new.entity.User;
import com.softserve.edu.service_center_new.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void addUser(User user) {
        userDAO.addElement(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateElement(user);
    }

    @Override
    public User getUserById(int id) {
        return userDAO.getElementById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllElements();
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteElement(user);
    }
}
