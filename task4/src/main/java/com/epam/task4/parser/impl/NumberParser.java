package com.epam.task4.parser.impl;

import com.epam.task4.composite.*;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.TextComponentParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberParser implements TextComponentParser {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public TextComponent parse(String source) throws TextParseException {
        TextComponent number = new TextComposite(ComponentType.NUMBER);
        char[] sourceChars = source.toCharArray();
        int i = 0;
        TextComponent currentSymbol;
        if (sourceChars[i] == '-') {
            currentSymbol = new Symbol(SymbolType.MINUS, sourceChars[i]);
            number.add(currentSymbol);
            i++;
        }
        SymbolType currentSymbolType;
        for (; i < sourceChars.length; i++) {
            if (Character.isDigit(sourceChars[i])) {
                currentSymbolType = SymbolType.DIGIT;
            } else if ('.' == sourceChars[i] || ',' == sourceChars[i]) {
                currentSymbolType = SymbolType.FRACTIONAL_COMMA;
            } else {
                LOGGER.error("Unknown symbol '" + sourceChars[i] + "'");
                throw new TextParseException("Unknown symbol '" + sourceChars[i] + "'");
            }
            currentSymbol = new Symbol(currentSymbolType, sourceChars[i]);
            number.add(currentSymbol);
        }
        return number;
    }
}
