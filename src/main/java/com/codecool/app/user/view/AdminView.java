package com.codecool.app.user.view;

import com.codecool.app.user.model.Mentor;
import com.codecool.app.view.QSView;

import java.util.List;

public interface AdminView extends QSView {
    public void showMentorsAndTheirClassess(List<Mentor> mentors);
}
