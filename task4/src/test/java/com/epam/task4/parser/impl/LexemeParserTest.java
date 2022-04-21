package com.epam.task4.parser.impl;

import com.epam.task4.composite.TextComponent;
import com.epam.task4.data.StaticParserDataProvider;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.TextComponentParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LexemeParserTest {
    @Test(dataProvider = "lexemes-data", dataProviderClass = StaticParserDataProvider.class)
    public void testWordParse(TextComponent expected, String lexemeString) throws TextParseException {
        TextComponentParser parser = new LexemeParser();
        TextComponent actual = parser.parse(lexemeString);
        Assert.assertEquals(expected, actual);
    }
}
