package com.codecool.app;

import com.codecool.app.connectors.SQLConnector;
import com.codecool.app.view.QSView;
import com.codecool.app.view.consoleimpl.QSViewConsoleImpl;

public class Main {
    public static void main(String[] args){
        QSView qsView = new QSViewConsoleImpl();
        QuestStore questStore = new QuestStore(qsView);
        questStore.run();
    }
}
