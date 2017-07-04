package com.softserve.edu.service_center_new.service;

import com.softserve.edu.service_center_new.entity.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    void deleteUser(User user);

    List<User> getAllClients();
}
