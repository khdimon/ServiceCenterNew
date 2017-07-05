package com.softserve.edu.service_center_new.dao.impl;

import com.softserve.edu.service_center_new.dao.RoleDAO;
import com.softserve.edu.service_center_new.dao.util.HibernateUtil;
import com.softserve.edu.service_center_new.entity.Role;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOImpl extends ElementDAOImpl<Role> implements RoleDAO {

    public RoleDAOImpl() {
        super(Role.class);
    }

    @Override
    public Role getRoleByName(String name) {
        Role role = null;
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            Query query =
                    session.createQuery("from Role where name = :roleName");
            query.setParameter("roleName", name);
            List roles = query.list();
            if (!roles.isEmpty()) {
                role = (Role) roles.get(0);
            }
        }
        return role;
    }
}
