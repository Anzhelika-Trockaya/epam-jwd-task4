package com.epam.task4.parser.impl;

import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.TextComponent;
import com.epam.task4.composite.TextComposite;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.TextComponentParser;

public class SentenceParser implements TextComponentParser {
    private final static String SPACE = " ";
    private final TextComponentParser lexemeParser = new LexemeParser();

    @Override
    public TextComponent parse(String source) throws TextParseException {
        TextComponent sentence = new TextComposite(ComponentType.SENTENCE);
        String[] lexemesStrings = source.split(SPACE);
        for (String lexemeString : lexemesStrings) {
            TextComponent lexeme = lexemeParser.parse(lexemeString);
            sentence.add(lexeme);
        }
        return sentence;
    }
}
