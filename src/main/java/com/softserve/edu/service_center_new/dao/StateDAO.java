package com.softserve.edu.service_center_new.dao;

import com.softserve.edu.service_center_new.entity.State;

import java.util.List;

public interface StateDAO {
    State getStateById(int id);

    List<State> getAllStates();

    void addState(State state);

    void updateState(State state);

    void deleteState(State state);
}
