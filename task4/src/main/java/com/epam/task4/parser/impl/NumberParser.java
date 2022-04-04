package com.epam.task4.parser.impl;

import com.epam.task4.composite.*;
import com.epam.task4.parser.TextComponentParser;

public class NumberParser implements TextComponentParser {
    @Override
    public TextComponent parse(String source) {
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
            if (sourceChars[i] == ',') {
                currentSymbolType = SymbolType.FRACTIONAL_COMMA;
            } else {
                currentSymbolType = SymbolType.DIGIT;
            }
            currentSymbol = new Symbol(currentSymbolType, sourceChars[i]);
            number.add(currentSymbol);
        }
        return number;
    }
}
