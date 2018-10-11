package com.codecool.app;

import com.codecool.app.dao.AppDAOs;
import com.codecool.app.dao.SQLImpl.AppDAOsSQL;
import com.codecool.app.view.AppViews;
import com.codecool.app.view.consoleimpl.AppViewsConsoleImpl;

public class Main {
    public static void main(String[] args){
        AppViews appViews = new AppViewsConsoleImpl();
        AppDAOs appDAOs = new AppDAOsSQL();
        QuestStore questStore = new QuestStore(appViews, appDAOs);
        questStore.run();
    }
}
