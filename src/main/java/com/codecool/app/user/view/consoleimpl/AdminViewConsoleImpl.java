package com.codecool.app.user.view.consoleimpl;

import com.codecool.app.user.model.Mentor;
import com.codecool.app.user.view.AdminView;
import com.codecool.app.view.consoleimpl.QSViewConsoleImpl;

import java.util.List;

public class AdminViewConsoleImpl extends QSViewConsoleImpl implements AdminView {
    @Override
    public void showMentorsAndTheirClassess(List<Mentor> mentors) {
        for (Mentor mentor : mentors) {
            println(String.format("(%d) %s %s  |  e-mail: %s  | classess: %s",
                    mentor.getId(), mentor.getFirstName(), mentor.getLastName(), mentor.getEmail(), mentor.getClassess().toString()
            ));
        }
    }
}
