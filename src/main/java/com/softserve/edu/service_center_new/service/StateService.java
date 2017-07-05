package com.softserve.edu.service_center_new.service;

import com.softserve.edu.service_center_new.entity.State;

import java.util.List;

public interface StateService {

    void addState(State state);

    void updateState(State state);

    State getStateById(int id);

    List<State> getAllStates();

    void deleteState(State state);

    State getStateByName(String name);
}
