package com.softserve.edu.service_center_new.dao.impl;

import com.softserve.edu.service_center_new.dao.RoleDAO;
import com.softserve.edu.service_center_new.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl extends ElementDAOImpl<Role> implements RoleDAO {

    public RoleDAOImpl() {
        super(Role.class);
    }
}
