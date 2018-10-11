package com.codecool.app.user.model;

import java.util.List;

public class Class {
    private List<Mentor> mentors;
    private List<Codecooler> codecoolers;

    public Class(List<Mentor> mentors, List<Codecooler> codecoolers) {
        this.mentors = mentors;
        this.codecoolers = codecoolers;
    }

    public List<Mentor> getMentors() {
        return mentors;
    }

    public List<Codecooler> getCodecoolers() {
        return codecoolers;
    }
}
