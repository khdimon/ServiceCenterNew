package com.softserve.edu.service_center_new.controller;

import com.softserve.edu.service_center_new.entity.User;
import com.softserve.edu.service_center_new.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "clients")
    public ModelAndView getAllClients() {
        ModelAndView modelAndView = new ModelAndView("pages/clients");
        List<User> clients = userService.getAllClients();
        modelAndView.addObject("clients", clients);
        return modelAndView;
    }

    @RequestMapping(value = "addClientForm")
    public String addClientForm(Model model) {
        User client = new User();
        model.addAttribute("client", client);
        return "pages/addClient";
    }

    @RequestMapping(value = "addClient", method = RequestMethod.POST)
    public String addClient(@ModelAttribute ("client") User client) {
        //client.setRole();
        //userService.addUser();
        return null;
    }
}
