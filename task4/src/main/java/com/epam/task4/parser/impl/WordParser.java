package com.epam.task4.parser.impl;

import com.epam.task4.composite.*;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.TextComponentParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser implements TextComponentParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final char HYPHEN = '-';
    private static final char UNDERSCORE = '_';
    private static final char APOSTROPHE = '\'';
    private static final char APOSTROPHE_2 = '’';

    @Override
    public TextComponent parse(String source) throws TextParseException {
        TextComponent word = new TextComposite(ComponentType.WORD);
        char[] wordChars = source.toCharArray();
        SymbolType currentSymbolType;
        Symbol currentSymbol;
        for (char wordChar : wordChars) {
            currentSymbolType = defineSymbolType(wordChar);
            currentSymbol = new Symbol(currentSymbolType, wordChar);
            word.add(currentSymbol);
        }
        return word;
    }

    private SymbolType defineSymbolType(char ch) throws TextParseException {
        SymbolType type;
        if (Character.isAlphabetic(ch)) {
            type = SymbolType.LETTER;
        } else if (HYPHEN == ch || APOSTROPHE == ch || UNDERSCORE == ch || APOSTROPHE_2 == ch) {
            type = SymbolType.SPELLING_MARK;
        } else {
            LOGGER.error("Unknown symbol '" + ch + "'");
            throw new TextParseException("Unknown symbol '" + ch + "'");
        }
        return type;
    }
}
