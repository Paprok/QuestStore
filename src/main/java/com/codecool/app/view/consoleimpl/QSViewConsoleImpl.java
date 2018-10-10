package com.codecool.app.view.consoleimpl;

import com.codecool.app.view.QSView;

public class QSViewConsoleImp extends ViewConsoleImp implements QSView {

    @Override
    public void printMenu(String[] options) {
        for (int i=0; i<options.length; i++){
            println(String.format("(%d) %s", i+1, options[i]));
        }
    }
}
