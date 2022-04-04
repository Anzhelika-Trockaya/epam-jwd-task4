package com.epam.task4.parser.impl;

import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.Delimiter;
import com.epam.task4.composite.TextComponent;
import com.epam.task4.composite.TextComposite;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.TextComponentParser;

public class SentenceParser implements TextComponentParser {
    private final LexemeParser lexemeParser = new LexemeParser();

    @Override
    public TextComponent parse(String source) throws TextParseException {
        TextComponent sentence = new TextComposite(ComponentType.SENTENCE);
        String[] lexemesStrings = source.split(Delimiter.SPACE.getValue());
        for (String lexemeString : lexemesStrings) {
            TextComponent lexeme = lexemeParser.parse(lexemeString);
            sentence.add(lexeme);
        }
        return sentence;
    }
}
