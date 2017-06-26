package com.softserve.edu.service_center_new.dao.impl;

import com.softserve.edu.service_center_new.dao.StateDAO;
import com.softserve.edu.service_center_new.entity.State;
import org.springframework.stereotype.Repository;

/**
 * DAO class for entity State
 */
@Repository
public class StateDAOImpl extends ElementDAOImpl<State> implements StateDAO {

    public StateDAOImpl() {
        super(State.class);
    }
}
