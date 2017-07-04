package com.softserve.edu.service_center_new.dao;

import com.softserve.edu.service_center_new.entity.User;

import java.util.List;

public interface UserDAO extends ElementDAO<User> {
    List<User> getAllClients();
}
