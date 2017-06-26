package com.softserve.edu.service_center_new.service;

import com.softserve.edu.service_center_new.dao.StateDAO;
import com.softserve.edu.service_center_new.entity.State;
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
