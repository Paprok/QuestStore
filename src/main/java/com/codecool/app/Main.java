package com.codecool.app;

import com.codecool.app.view.QSView;
import com.codecool.app.view.consoleimpl.QSViewConsoleImp;

public class Main {
    public static void main(String[] args){
        QSView qsView = new QSViewConsoleImp();
        QuestStore questStore = new QuestStore(qsView);
        questStore.run();
    }
}
