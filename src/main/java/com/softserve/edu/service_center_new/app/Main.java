package com.softserve.edu.service_center_new.app;

import com.softserve.edu.service_center_new.dao.util.HibernateUtil;
import com.softserve.edu.service_center_new.entity.State;
import com.softserve.edu.service_center_new.service.StateService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx =
                new ClassPathXmlApplicationContext("spring-app.xml");
        StateService stateService = appCtx.getBean(StateService.class);

        List<State> states = stateService.getAllStates();
        for (State s : states) {
            System.out.println(s.getName());
        }

        appCtx.close();
        HibernateUtil.shutdown();
    }
}
