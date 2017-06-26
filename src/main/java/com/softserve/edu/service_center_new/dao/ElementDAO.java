package com.softserve.edu.service_center_new.dao;

import java.util.List;

public interface ElementDAO<E> {
    E getElementById(int id);

    List<E> getAllElements();

    void addElement(E element);

    void updateElement(E element);

    void deleteElement(E Element);
}
