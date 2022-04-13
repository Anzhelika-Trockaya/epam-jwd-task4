package com.epam.task4.parser.impl;

import com.epam.task4.composite.*;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.TextComponentParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberParserTest {
    @Test
    public void testParse() throws TextParseException {
        String numberString = "-134.9";
        Symbol minus = new Symbol(SymbolType.MINUS, '-');
        Symbol d1 = new Symbol(SymbolType.DIGIT, '1');
        Symbol d2 = new Symbol(SymbolType.DIGIT, '3');
        Symbol d3 = new Symbol(SymbolType.DIGIT, '4');
        Symbol comma = new Symbol(SymbolType.FRACTIONAL_COMMA, '.');
        Symbol d4 = new Symbol(SymbolType.DIGIT, '9');
        TextComponent expected = new TextComposite(ComponentType.NUMBER);
        expected.add(minus);
        expected.add(d1);
        expected.add(d2);
        expected.add(d3);
        expected.add(comma);
        expected.add(d4);
        TextComponentParser parser = new NumberParser();
        TextComponent actual = parser.parse(numberString);
        Assert.assertEquals(expected, actual);
    }


}
