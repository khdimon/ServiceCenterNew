package com.softserve.edu.service_center_new.dao.impl;

import com.softserve.edu.service_center_new.dao.UserDAO;
import com.softserve.edu.service_center_new.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends ElementDAOImpl<User> implements UserDAO {

    public UserDAOImpl() {
        super(User.class);
    }
}
