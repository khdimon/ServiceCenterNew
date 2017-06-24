package com.softserve.edu.service_center_new.dao;

public class DAOFactory {
    private StateDAO stateDAO = null;

    private static DAOFactory instance = null;

    private DAOFactory() {
        this.stateDAO = new StateDAO();
    }

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public StateDAO getStateDAO() {
        return stateDAO;
    }
}

