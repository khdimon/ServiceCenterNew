package com.softserve.edu.service_center_new.service;

import com.softserve.edu.service_center_new.entity.Service;

import java.util.List;

public interface ServiceService {

    void addService(Service service);

    void updateService(Service service);

    Service getServiceById(int id);

    List<Service> getAllServices();

    void deleteService(Service service);
}
