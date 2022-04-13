package com.epam.task4.main;

import com.epam.task4.composite.TextComponent;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.impl.TextParser;

public class Main2 {
    public static void main(String[] args) throws TextParseException {
        String text = "\tFirst sentence — 3-4*5 end. Второе (\"предложение\")! 145?\n\tА это \"пятое\" предложение… No, this is fifth!";
        TextParser parser = new TextParser();
        TextComponent textComponent = parser.parse(text);
        System.out.println(textComponent.getAsString());
    }
}
