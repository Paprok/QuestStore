package com.codecool.app;

import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class ViewConsoleImp implements View{
    Scanner scanner;
    private final String EMPTY_INPUT_ERROR = "Input is empty";

    @Override
    public void println(String text) {
        System.out.println(text);
    }

    @Override
    public String getInput() throws NoSuchElementException {
        String result;

        try{
            scanner = new Scanner(System.in);
            result = scanner.next().trim();
        } catch (NoSuchElementException e){
            throw e;
        }

        if (result.length() < 1){
            throw new NoSuchElementException(EMPTY_INPUT_ERROR);
        }

        return result;
    }
}
