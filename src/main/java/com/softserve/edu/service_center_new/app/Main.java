package com.softserve.edu.service_center_new.app;

import com.softserve.edu.service_center_new.dao.util.HibernateUtil;
import com.softserve.edu.service_center_new.entity.Order;
import com.softserve.edu.service_center_new.entity.State;
import com.softserve.edu.service_center_new.service.OrderService;
import com.softserve.edu.service_center_new.service.RoleService;
import com.softserve.edu.service_center_new.service.StateService;
import com.softserve.edu.service_center_new.service.UserService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx = null;
        try {
            appCtx =
                    new ClassPathXmlApplicationContext("spring-app.xml");
            UserService userService = appCtx.getBean(UserService.class);

            System.out.println(userService.getUserById(1).getName());

            /*List<Order> orders = orderService.getAllOrders();
            for (Order ord : orders) {
                System.out.println(ord.getUser().getName());
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (appCtx != null) {
                appCtx.close();
            }
            HibernateUtil.shutdown();
        }
    }
}
