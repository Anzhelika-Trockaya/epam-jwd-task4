package com.epam.task4.parser.impl;

import com.epam.task4.composite.*;
import com.epam.task4.data.StaticParserDataProvider;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.TextComponentParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WordParserTest {
    @Test(dataProvider = "words-data", dataProviderClass = StaticParserDataProvider.class)
    public void testWordParse(TextComponent expected, String wordString) throws TextParseException {
        TextComponentParser parser = new WordParser();
        TextComponent actual = parser.parse(wordString);
        Assert.assertEquals(expected, actual);
    }
}
