package com.softserve.edu.service_center_new.controller;

import com.softserve.edu.service_center_new.entity.Order;
import com.softserve.edu.service_center_new.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public ModelAndView getAllOrders() {
        ModelAndView modelAndView = new ModelAndView("pages/orders");
        List<Order> orders = orderService.getAllOrders();
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }

    @RequestMapping(value = "deleteOrder/{id}")
    public ModelAndView deleteOrderById(@PathVariable("id") int id) {
        Order order = orderService.getOrderById(id);
        orderService.deleteOrder(order);
        return getAllOrders();
    }

    @RequestMapping(value = "editOrder/{id}")
    public String editOrderById(@PathVariable("id") int id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "pages/editOrder";
    }

    @RequestMapping(value = "editOrder", method = RequestMethod.POST)
    public String editOrder(@ModelAttribute("order") Order order) {
        orderService.updateOrder(order);
        return "redirect: orders";
    }
}
