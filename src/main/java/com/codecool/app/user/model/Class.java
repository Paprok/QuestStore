package com.codecool.app.user.model;

import java.util.ArrayList;
import java.util.List;

public class Class {
    private List<Mentor> mentors;
    private List<Codecooler> codecoolers;
    private String name;
    private int class_id;

    public Class() {
        this.mentors = new ArrayList<>();
        this.codecoolers = new ArrayList<>();
    }

    public List<Mentor> getMentors() {
        return mentors;
    }

    public List<Codecooler> getCodecoolers() {
        return codecoolers;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public void addMentor(Mentor mentor){
        this.mentors.add(mentor);
    }

    public void addCodecooler(Codecooler codecooler){
        this.codecoolers.add(codecooler);
    }
}
