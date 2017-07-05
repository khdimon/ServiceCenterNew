package com.softserve.edu.service_center_new.service;

import com.softserve.edu.service_center_new.entity.Role;

import java.util.List;

public interface RoleService {

    void addRole(Role role);

    void updateRole(Role role);

    Role getRoleById(int id);

    List<Role> getAllRoles();

    void deleteRole(Role role);

    Role getRoleByName(String name);
}
