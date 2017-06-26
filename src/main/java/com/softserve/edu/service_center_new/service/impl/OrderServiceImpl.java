package com.softserve.edu.service_center_new.service.impl;

import com.softserve.edu.service_center_new.dao.OrderDAO;
import com.softserve.edu.service_center_new.entity.Order;
import com.softserve.edu.service_center_new.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    @Autowired
    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public void addOrder(Order order) {
        orderDAO.addElement(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderDAO.updateElement(order);
    }

    @Override
    public Order getOrderById(int id) {
        return orderDAO.getElementById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDAO.getAllElements();
    }

    @Override
    public void deleteOrder(Order order) {
        orderDAO.deleteElement(order);
    }
}
