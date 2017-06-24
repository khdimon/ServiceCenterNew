package com.softserve.edu.service_center_new.service;

import com.softserve.edu.service_center_new.dao.DAOFactory;
import com.softserve.edu.service_center_new.dao.StateDAO;
import com.softserve.edu.service_center_new.entity.State;

import java.util.List;

public class StateService {
    private StateDAO stateDAO = DAOFactory.getInstance().getStateDAO();

    public void addState(State state) {
        stateDAO.addState(state);
    }

    public void updateState(State state) {
        stateDAO.updateState(state);
    }

    public State getStateById(int id) {
        return stateDAO.getStateById(id);
    }

    public List<State> getAllState() {
        return stateDAO.getAllStates();
    }

    public void deleteState(State state) {
        stateDAO.deleteState(state);
    }
}
