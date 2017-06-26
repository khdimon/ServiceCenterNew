package com.softserve.edu.service_center_new.dao;

import com.softserve.edu.service_center_new.dao.util.HibernateUtil;
import com.softserve.edu.service_center_new.entity.State;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO class for entity State
 */
@Repository
public class StateDAOImpl implements StateDAO {

    public State getStateById(int id) {
        State state;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            state = session.get(State.class, id);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return state;
    }

    public List<State> getAllStates() {
        List<State> states;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            states = session.createQuery("from State").list();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return states;
    }

    public void addState(State state) {
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(state);
            transaction.commit();
        }
    }

    public void updateState(State state) {
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(state);
            transaction.commit();
        }
    }

    public void deleteState(State state) {
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(state);
            transaction.commit();
        }
    }
}
