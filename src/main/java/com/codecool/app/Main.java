package com.codecool.app;

public class Main {
    public static void main(String[] args){
        QSView qsView = new QSViewConsoleImp();
        QuestStore questStore = new QuestStore(qsView);
        questStore.run();
    }
}
