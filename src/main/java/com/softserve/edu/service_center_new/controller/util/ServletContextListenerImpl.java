package com.softserve.edu.service_center_new.controller.util;

import com.softserve.edu.service_center_new.dao.util.HibernateUtil;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

public class ServletContextListenerImpl extends ContextLoaderListener {
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        HibernateUtil.shutdown();
        super.contextDestroyed(event);
    }
}
