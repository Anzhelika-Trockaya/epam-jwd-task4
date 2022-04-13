package com.epam.task4.composite;

public enum ComponentType {
    TEXT("\t", "\n"),
    PARAGRAPH("", " "),
    SENTENCE("", " "),
    LEXEME("", ""),
    WORD("", ""),
    NUMBER("", ""),
    SYMBOL("", "");
    private final String prefix;
    private final String postfix;

    ComponentType(String prefix, String postfix) {
        this.prefix = prefix;
        this.postfix = postfix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getPostfix() {
        return postfix;
    }
}
