package com.codecool.app.dao.SQLImpl;

import com.codecool.app.connectors.SQLConnector;
import com.codecool.app.dao.DAOMentors;
import com.codecool.app.user.model.Mentor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOMentorsSQL implements DAOMentors {
    private Connection connection;

    public DAOMentorsSQL() {
        this.connection = SQLConnector.getConnection();
    }

    @Override
    public void insertMentor(Mentor newMentor) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO mentors (user_id, email, name, surname) " +
                    "VALUES (?, ?, ?, ?)");
            ps.setInt(1, newMentor.getId());
            ps.setString(2, newMentor.getEmail());
            ps.setString(3, newMentor.getFirstName());
            ps.setString(4, newMentor.getLastName());
            ps.execute();
            ps.close();
        } catch (SQLException e){
            System.out.println("Couldn't insert new Mentor");
            e.printStackTrace();
        }
    }

    @Override
    public void updateMentor(int id, Mentor updatedMentor) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO mentors (email, name, surname) " +
                    "VALUES (?, ?, ?)");
            ps.setString(2, updatedMentor.getEmail());
            ps.setString(3, updatedMentor.getFirstName());
            ps.setString(4, updatedMentor.getLastName());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e){
            System.out.println("Couldn't insert new Mentor, check id");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMentor(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM mentors WHERE user_id = ? ");
            ps.setInt(1, id);
            ps.execute();
            ps.close();
        } catch (SQLException e){
            System.out.println("Couldn't find mentor with given id");
        }
    }

    @Override
    public Mentor getMentor(int id) {
        Mentor mentor = null;
        String sql = "SELECT * FROM mentors WHERE user_id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email = resultSet.getString("email");
                mentor = new Mentor(name, surname, email);
            }
        }catch (SQLException e) {
            System.out.println("Couldn't find mentor with given id");
        }
        return mentor;
    }

    @Override
    public List<Mentor> getAllMentors() {
        List<Mentor> mentors = new ArrayList<>();
        String sql = "SELECT * FROM mentors";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email = resultSet.getString("email");
                mentors.add(new Mentor(name, surname, email));
            }
        }catch (SQLException e) {
            System.out.println("Couldn't find mentor with given id");
        }
        return mentors;
    }
}
