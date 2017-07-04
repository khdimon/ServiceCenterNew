package com.softserve.edu.service_center_new.dao.impl;

import com.softserve.edu.service_center_new.dao.UserDAO;
import com.softserve.edu.service_center_new.dao.util.HibernateUtil;
import com.softserve.edu.service_center_new.entity.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl extends ElementDAOImpl<User> implements UserDAO {

    public UserDAOImpl() {
        super(User.class);
    }

    @Override
    public List<User> getAllClients() {
        List<User> clients;
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            String query = "from User where role.name = 'client'";
            clients = (List<User>) session.createQuery(query).list();
        }
        return clients;
    }
}
