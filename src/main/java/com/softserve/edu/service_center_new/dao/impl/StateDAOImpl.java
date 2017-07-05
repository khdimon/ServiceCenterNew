package com.softserve.edu.service_center_new.dao.impl;

import com.softserve.edu.service_center_new.dao.StateDAO;
import com.softserve.edu.service_center_new.dao.util.HibernateUtil;
import com.softserve.edu.service_center_new.entity.State;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO class for entity State
 */
@Repository
public class StateDAOImpl extends ElementDAOImpl<State> implements StateDAO {

    public StateDAOImpl() {
        super(State.class);
    }

    @Override
    public State getStateByName(String name) {
        State state = null;
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            Query query =
                    session.createQuery("from State where name = :stateName");
            query.setParameter("stateName", name);
            List states = query.list();
            if (!states.isEmpty()) {
                state = (State) states.get(0);
            }
        }
        return state;
    }
}
