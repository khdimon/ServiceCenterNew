package com.softserve.edu.service_center_new.app;

import com.softserve.edu.service_center_new.dao.HibernateUtil;
import com.softserve.edu.service_center_new.entity.State;
import com.softserve.edu.service_center_new.service.StateService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StateService stateService = new StateService();
        State state = stateService.getStateById(6);
        stateService.deleteState(state);
        List<State> states = stateService.getAllState();
        for (State s : states) {
            System.out.println(s.getName());
        }
        HibernateUtil.shutdown();
    }
}
