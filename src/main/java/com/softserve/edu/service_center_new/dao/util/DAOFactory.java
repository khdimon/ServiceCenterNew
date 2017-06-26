package com.softserve.edu.service_center_new.dao.util;

import com.softserve.edu.service_center_new.dao.impl.StateDAOImpl;

public class DAOFactory {
    private StateDAOImpl stateDAO = null;

    private static DAOFactory instance = null;

    private DAOFactory() {
        this.stateDAO = new StateDAOImpl();
    }

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public StateDAOImpl getStateDAO() {
        return stateDAO;
    }
}

