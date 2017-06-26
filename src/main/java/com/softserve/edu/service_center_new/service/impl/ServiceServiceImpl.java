package com.softserve.edu.service_center_new.service.impl;

import com.softserve.edu.service_center_new.dao.ServiceDAO;
import com.softserve.edu.service_center_new.entity.Service;
import com.softserve.edu.service_center_new.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    private ServiceDAO serviceDAO;

    @Autowired
    public void setServiceDAO(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    @Override
    public void addService(Service service) {
        serviceDAO.addElement(service);
    }

    @Override
    public void updateService(Service service) {
        serviceDAO.updateElement(service);
    }

    @Override
    public Service getServiceById(int id) {
        return serviceDAO.getElementById(id);
    }

    @Override
    public List<Service> getAllServices() {
        return serviceDAO.getAllElements();
    }

    @Override
    public void deleteService(Service service) {
        serviceDAO.deleteElement(service);
    }
}
