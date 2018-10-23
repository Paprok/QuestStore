package com.codecool.app.dao;

import com.codecool.app.user.model.Class;

import java.util.List;

public interface DAOClasses {
    void insertClass(Class newClass);
    void updateClass(int id, Class updateClass);
    Class getClass(int id);
    List<Class> getAllClasses();
    void deleteClass(int id);
}
