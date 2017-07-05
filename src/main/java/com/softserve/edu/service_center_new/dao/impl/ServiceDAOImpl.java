package com.softserve.edu.service_center_new.dao.impl;

import com.softserve.edu.service_center_new.dao.ServiceDAO;
import com.softserve.edu.service_center_new.dao.util.HibernateUtil;
import com.softserve.edu.service_center_new.entity.Service;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceDAOImpl extends ElementDAOImpl<Service>
        implements ServiceDAO {
    public ServiceDAOImpl() {
        super(Service.class);
    }

    @Override
    public Service getServiceByName(String name) {
        Service service = null;
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            Query query =
                    session.createQuery("from Service where name = :serviceName");
            query.setParameter("serviceName", name);
            List services = query.list();
            if (!services.isEmpty()) {
                service = (Service) services.get(0);
            }
        }
        return service;
    }
}
