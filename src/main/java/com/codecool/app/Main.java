package com.codecool.app;

import com.codecool.app.connectors.SQLConnector;
import com.codecool.app.view.AppViews;
import com.codecool.app.view.QSView;
import com.codecool.app.view.consoleimpl.AppViewsConsoleImpl;
import com.codecool.app.view.consoleimpl.QSViewConsoleImpl;

public class Main {
    public static void main(String[] args){
        AppViews appViews = new AppViewsConsoleImpl();
        QuestStore questStore = new QuestStore(appViews);
        questStore.run();
    }
}
