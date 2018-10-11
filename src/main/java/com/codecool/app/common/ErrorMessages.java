package com.codecool.app.common;

public class ErrorMessages {
    private final String NO_ACCESS_MESSAGE = "Controller for user with given access level is not implemented";
    private final String NO_OPTION_MESSAGE = "Option not found";
    private final String EMPTY_INPUT_MESSAGE = "Please enter something";

    public String getNO_ACCESS_MESSAGE() {
        return NO_ACCESS_MESSAGE;
    }

    public String getNO_OPTION_MESSAGE() {
        return NO_OPTION_MESSAGE;
    }

    public String getEMPTY_INPUT_MESSAGE() {
        return EMPTY_INPUT_MESSAGE;
    }
}
