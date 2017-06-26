package com.softserve.edu.service_center_new.service;

import com.softserve.edu.service_center_new.entity.Order;

import java.util.List;

public interface OrderService {

    void addOrder(Order order);

    void updateOrder(Order order);

    Order getOrderById(int id);

    List<Order> getAllOrders();

    void deleteOrder(Order order);
}
