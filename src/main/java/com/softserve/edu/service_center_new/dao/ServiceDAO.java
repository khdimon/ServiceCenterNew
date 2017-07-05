package com.softserve.edu.service_center_new.dao;

import com.softserve.edu.service_center_new.entity.Service;

public interface ServiceDAO extends ElementDAO<Service> {
    Service getServiceByName(String name);
}
