package com.epam.task4.composite;

public enum Delimiter {
    SPACE(" "),
    TABULATION("\t"),
    NEWLINE("\n"),
    EMPTY("");
    private final String value;

    Delimiter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
