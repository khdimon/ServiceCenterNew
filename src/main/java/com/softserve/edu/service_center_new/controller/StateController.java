package com.softserve.edu.service_center_new.controller;

import com.softserve.edu.service_center_new.entity.State;
import com.softserve.edu.service_center_new.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StateController {

    private StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @RequestMapping(value = "states")
    public ModelAndView getAllStates() {
        ModelAndView modelAndView = new ModelAndView("/states");
        List<State> states = stateService.getAllState();
        modelAndView.addObject("states", states);
        return modelAndView;
    }
}
