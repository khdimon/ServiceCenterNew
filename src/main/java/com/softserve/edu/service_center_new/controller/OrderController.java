package com.softserve.edu.service_center_new.controller;

import com.softserve.edu.service_center_new.dto.OrderDTO;
import com.softserve.edu.service_center_new.entity.*;
import com.softserve.edu.service_center_new.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {

    private OrderService orderService;
    private UserService userService;
    private StateService stateService;
    private ServiceService serviceService;
    private TeamService teamService;

    @Autowired
    public OrderController(OrderService orderService, UserService userService,
                           StateService stateService, ServiceService serviceService,
                           TeamService teamService) {
        this.orderService = orderService;
        this.userService = userService;
        this.stateService = stateService;
        this.serviceService = serviceService;
        this.teamService = teamService;
    }

    @RequestMapping(value = "orders")
    public ModelAndView getAllOrders() {
        ModelAndView modelAndView = new ModelAndView("pages/order/orders");
        List<Order> orders = orderService.getAllOrders();
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }

    @RequestMapping(value = "deleteOrder/{id}")
    public String deleteOrderById(@PathVariable("id") int id,
                                  HttpServletRequest request) {
        Order order = orderService.getOrderById(id);
        orderService.deleteOrder(order);
        String rootPath = request.getSession()
                .getServletContext()
                .getContextPath();
        return "redirect: " + rootPath + "/orders";
    }

    @RequestMapping(value = "editOrder/{id}")
    public String editOrderById(@PathVariable("id") int id, Model model) {
        Order order = orderService.getOrderById(id);
        OrderDTO orderDTO = new OrderDTO(order);
        model.addAttribute("order", orderDTO);
        List<Service> services = serviceService.getAllServices();
        List<Team> teams = teamService.getAllTeams();
        List<State> states = stateService.getAllStates();
        model.addAttribute("services", services);
        model.addAttribute("teams", teams);
        model.addAttribute("states", states);
        return "pages/order/editOrder";
    }

    @RequestMapping(value = "editOrder", method = RequestMethod.POST)
    public String editOrder(@ModelAttribute("order") OrderDTO orderDTO) {
        Order order = orderService.getOrderById(orderDTO.getId());
        order.setUser(userService.getUserById(orderDTO.getUserId()));
        order.setAddress(orderDTO.getAddress());
        order.setPhone(orderDTO.getPhone());
        order.setService(serviceService.getServiceByName(orderDTO.getServiceName()));
        if (!orderDTO.getTeamName().isEmpty()) {
            order.setTeam(teamService.getTeamByName(orderDTO.getTeamName()));
        }
        order.setState(stateService.getStateByName(orderDTO.getStateName()));
        order.setCreationDate(orderDTO.getCreationDate());
        if (orderDTO.getExecutionDate() != null) {
            order.setExecutionDate(orderDTO.getExecutionDate());
        }
        if (!orderDTO.getComment().isEmpty()) {
            order.setComment(orderDTO.getComment());
        }
        orderService.updateOrder(order);
        return "redirect: orders";
    }

    @RequestMapping(value = "createOrderForm")
    public String createOrderForm(Model model) {
        OrderDTO orderDTO = new OrderDTO();
        model.addAttribute("order", orderDTO);
        List<Service> services = serviceService.getAllServices();
        model.addAttribute("services", services);
        return "pages/order/createOrder";
    }

    @RequestMapping(value = "createOrder")
    public String createOrder(@ModelAttribute("order") OrderDTO orderDTO,
                              HttpServletRequest request) {
        Order order = new Order();
        User user = userService.getUserById(orderDTO.getUserId());
        order.setAddress(orderDTO.getAddress());
        order.setPhone(orderDTO.getPhone());
        order.setState(stateService.getStateByName("Прийнятий"));
        order.setUser(user);
        order.setService(serviceService.getServiceByName(orderDTO.getServiceName()));
        if (!orderDTO.getComment().isEmpty()) {
            order.setComment(orderDTO.getComment());
        }
        orderService.addOrder(order);
        String rootPath = request.getSession()
                .getServletContext()
                .getContextPath();
        return "redirect: " + rootPath + "/orders";
    }
}
