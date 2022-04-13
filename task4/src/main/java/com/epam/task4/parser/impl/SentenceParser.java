package com.epam.task4.parser.impl;

import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.TextComponent;
import com.epam.task4.composite.TextComposite;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.TextComponentParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser implements TextComponentParser {
    private static final Logger LOGGER = LogManager.getLogger();
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
        LOGGER.info("Sentence parsed. " + sentence);
        return sentence;
    }
}
