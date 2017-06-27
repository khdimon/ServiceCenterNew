package com.softserve.edu.service_center_new.dao.impl;

import com.softserve.edu.service_center_new.dao.ElementDAO;
import com.softserve.edu.service_center_new.dao.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ElementDAOImpl<E> implements ElementDAO<E> {

    private Class<E> elementClass;

    public ElementDAOImpl(Class<E> elementClass) {
        this.elementClass = elementClass;
    }

    @Override
    public E getElementById(int id) {
        E element;
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            element = session.get(elementClass, id);

        }
        return element;
    }

    @Override
    public List<E> getAllElements() {
        List<E> elements;
        try (Session session = HibernateUtil.getSessionFactory()
                             .openSession()) {
            String query = "from " + elementClass.getSimpleName();
            elements = (List<E>) session.createQuery(query).list();
        }
        return elements;
    }

    @Override
    public void addElement(E element) {
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(element);
            transaction.commit();
        }
    }

    @Override
    public void updateElement(E element) {
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(element);
            transaction.commit();
        }
    }

    @Override
    public void deleteElement(E element) {
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(element);
            transaction.commit();
        }
    }
}
