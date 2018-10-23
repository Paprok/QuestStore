package com.codecool.app.dao.SQLImpl;

import com.codecool.app.connectors.SQLConnector;
import com.codecool.app.dao.DAOClasses;
import com.codecool.app.user.model.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOClassesSQL implements DAOClasses {
    private Connection connection;

    public DAOClassesSQL() {
        this.connection = SQLConnector.getConnection();
    }

    @Override
    public void insertClass(Class newClass) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO classes (name) VALUES (?)");
            ps.setString(1, newClass.getName());
            ps.execute();
            ps.close();
        } catch (SQLException e){
            System.out.println("Couldn't insert new Class");
            e.printStackTrace();
        }
    }

    @Override
    public void updateClass(int id, Class updateClass) {
        try{
            PreparedStatement ps = connection.prepareStatement("UPDATE classes SET name=? WHERE class_id=?");
            ps.setString(1, updateClass.getName());
            ps.setInt(2, id);
            ps.execute();
            ps.close();
        } catch (SQLException e){
            System.out.println("Couldn't update Class with given id");
        }
    }

    @Override
    public Class getClass(int id) {
        Class myClass = new Class();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM classes WHERE class_id=?");
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                setClassBasedOnResultSet(myClass, resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Couldn't get Class with given id");
        }
        return myClass;
    }

    @Override
    public List<Class> getAllClasses() {
        List<Class> classes = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM classes");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                Class newClass = new Class();
                setClassBasedOnResultSet(newClass, resultSet);
                classes.add(newClass);
            }
        } catch (SQLException e) {
            System.out.println("Couldn't get Class with given id");
        }
        return classes;
    }

    @Override
    public void deleteClass(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM classes WHERE user_id = ? ");
            ps.setInt(1, id);
            ps.execute();
            ps.close();
        } catch (SQLException e){
            System.out.println("Couldn't find class with given id");
        }
    }

    private Class setClassBasedOnResultSet(Class myClass, ResultSet resultSet) throws SQLException{
        String name = resultSet.getString("name");
        int id = resultSet.getInt("class_id");
        myClass.setName(name);
        myClass.setClass_id(id);
        return myClass;
    }
}
