package com.softserve.edu.service_center_new.service.impl;

import com.softserve.edu.service_center_new.dao.StateDAO;
import com.softserve.edu.service_center_new.entity.State;
import com.softserve.edu.service_center_new.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {

    private StateDAO stateDAO;

    @Autowired
    public StateServiceImpl(StateDAO stateDAO) {
        this.stateDAO = stateDAO;
    }

    @Override
    public void addState(State state) {
        stateDAO.addElement(state);
    }

    @Override
    public void updateState(State state) {
        stateDAO.updateElement(state);
    }

    @Override
    public State getStateById(int id) {
        return stateDAO.getElementById(id);
    }

    @Override
    public List<State> getAllStates() {
        return stateDAO.getAllElements();
    }

    @Override
    public void deleteState(State state) {
        stateDAO.deleteElement(state);
    }

    @Override
    public State getStateByName(String name) {
        return stateDAO.getStateByName(name);
    }
}
