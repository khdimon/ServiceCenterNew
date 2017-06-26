package com.softserve.edu.service_center_new.controller;

import com.softserve.edu.service_center_new.entity.Order;
import com.softserve.edu.service_center_new.entity.State;
import com.softserve.edu.service_center_new.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "orders")
    public ModelAndView getAllStates() {
        ModelAndView modelAndView = new ModelAndView("pages/orders");
        List<Order> orders = orderService.getAllOrders();
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }
}
