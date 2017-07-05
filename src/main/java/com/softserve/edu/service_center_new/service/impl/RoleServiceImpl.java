package com.softserve.edu.service_center_new.service.impl;

import com.softserve.edu.service_center_new.dao.RoleDAO;
import com.softserve.edu.service_center_new.entity.Role;
import com.softserve.edu.service_center_new.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleDAO roleDAO;

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public void addRole(Role role) {
        roleDAO.addElement(role);
    }

    @Override
    public void updateRole(Role role) {
        roleDAO.updateElement(role);
    }

    @Override
    public Role getRoleById(int id) {
        return roleDAO.getElementById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAllElements();
    }

    @Override
    public void deleteRole(Role role) {
        roleDAO.deleteElement(role);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }
}
