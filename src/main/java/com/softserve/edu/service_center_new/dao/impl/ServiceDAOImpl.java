package com.softserve.edu.service_center_new.dao.impl;

import com.softserve.edu.service_center_new.dao.ServiceDAO;
import com.softserve.edu.service_center_new.entity.Service;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceDAOImpl extends ElementDAOImpl<Service>
        implements ServiceDAO {
    public ServiceDAOImpl() {
        super(Service.class);
    }
}
