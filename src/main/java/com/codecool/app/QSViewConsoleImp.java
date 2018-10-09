package com.codecool.app;

public class QSViewConsoleImp implements QSView{
    @Override
    public void println(String text) {
        System.out.println(text);
    }

    @Override
    public void printMenu(String[] options) {
        for (int i=0; i<options.length; i++){
            println(String.format("(%d) %s", i+1, options[i]));
        }
    }
}
