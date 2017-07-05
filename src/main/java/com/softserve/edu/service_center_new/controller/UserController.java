package com.softserve.edu.service_center_new.controller;

import com.softserve.edu.service_center_new.dto.OrderDTO;
import com.softserve.edu.service_center_new.dto.UserDTO;
import com.softserve.edu.service_center_new.entity.Order;
import com.softserve.edu.service_center_new.entity.Role;
import com.softserve.edu.service_center_new.entity.User;
import com.softserve.edu.service_center_new.service.RoleService;
import com.softserve.edu.service_center_new.service.ServiceService;
import com.softserve.edu.service_center_new.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;
    private RoleService roleService;
    private ServiceService serviceService;

    @Autowired
    public UserController(UserService userService, RoleService roleService,
                          ServiceService serviceService) {
        this.userService = userService;
        this.roleService = roleService;
        this.serviceService = serviceService;
    }

    @RequestMapping(value = "clients")
    public ModelAndView getAllClients() {
        ModelAndView modelAndView = new ModelAndView("pages/client/clients");
        List<User> clients = userService.getAllClients();
        modelAndView.addObject("clients", clients);
        return modelAndView;
    }

    @RequestMapping(value = "addClientForm")
    public String addClientForm(Model model) {
        User client = new User();
        model.addAttribute("client", client);
        return "pages/client/addClient";
    }

    @RequestMapping(value = "deleteClient/{id}")
    public String deleteClient(@PathVariable("id") int id,
                               HttpServletRequest request) {
        User client = userService.getUserById(id);
        Collection<Order> orders = client.getOrders();
        if (orders.isEmpty()) {
            userService.deleteUser(client);
        }
        String rootPath = request.getSession()
                .getServletContext()
                .getContextPath();
        return "redirect: " + rootPath + "/clients";
    }

    @RequestMapping(value = "addClient", method = RequestMethod.POST)
    public String addClient(@ModelAttribute("client") User client,
                            HttpServletRequest request) {
        Role clientRole = roleService.getRoleByName("client");
        client.setRole(clientRole);
        client.setPassword("1111");
        userService.addUser(client);
        String rootPath = request.getSession()
                .getServletContext()
                .getContextPath();
        return "redirect: " + rootPath + "/clients";
    }

    @RequestMapping(value = "editClient/{id}")
    public String editClientById(@PathVariable("id") int id, Model model) {
        User client = userService.getUserById(id);
        UserDTO clientDTO = new UserDTO(client);
        model.addAttribute("client", clientDTO);
        return "pages/client/editClient";
    }

    @RequestMapping(value = "editClient", method = RequestMethod.POST)
    public String editClient(@ModelAttribute("client") UserDTO clientDTO,
                            HttpServletRequest request) {
        User client = userService.getUserById(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setAddress(clientDTO.getAddress());
        client.setPhone(clientDTO.getPhone());
        client.setMail(clientDTO.getMail());
        userService.updateUser(client);
        String rootPath = request.getSession()
                .getServletContext()
                .getContextPath();
        return "redirect: " + rootPath + "/clients";
    }

    @RequestMapping("chooseClientTable")
    public ModelAndView chooseClientTable() {
        ModelAndView modelAndView = new ModelAndView("pages/client/chooseClient");
        List<User> clients = userService.getAllClients();
        modelAndView.addObject("clients", clients);
        return modelAndView;
    }

    @RequestMapping(value = "chooseClient/{id}")
    public String chooseClient(@PathVariable("id") int id, Model model) {
        User client = userService.getUserById(id);
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(id);
        orderDTO.setUserName(client.getName());
        orderDTO.setAddress(client.getAddress());
        orderDTO.setPhone(client.getPhone());
        model.addAttribute("order", orderDTO);
        model.addAttribute("services", serviceService.getAllServices());
        return "pages/order/createOrder";
    }

    @RequestMapping("chooseClientTableEdit")
    public ModelAndView chooseClientTableEdit() {
        ModelAndView modelAndView = new ModelAndView("pages/client/chooseClientEdit");
        List<User> clients = userService.getAllClients();
        modelAndView.addObject("clients", clients);
        return modelAndView;
    }

    @RequestMapping(value = "chooseClientEdit/{id}")
    public String chooseClientEdit(@PathVariable("id") int id, Model model) {
        User client = userService.getUserById(id);
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(id);
        orderDTO.setUserName(client.getName());
        orderDTO.setAddress(client.getAddress());
        orderDTO.setPhone(client.getPhone());
        model.addAttribute("order", orderDTO);
        model.addAttribute("services", serviceService.getAllServices());
        return "pages/order/editOrder";
    }
}
