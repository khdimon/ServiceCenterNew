package com.softserve.edu.service_center_new.dao.impl;

import com.softserve.edu.service_center_new.dao.OrderDAO;
import com.softserve.edu.service_center_new.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAOImpl extends ElementDAOImpl<Order> implements OrderDAO {

    public OrderDAOImpl() {
        super(Order.class);
    }
}
