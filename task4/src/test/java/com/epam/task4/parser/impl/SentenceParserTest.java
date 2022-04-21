package com.epam.task4.parser.impl;

import com.epam.task4.composite.TextComponent;
import com.epam.task4.data.StaticParserDataProvider;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.TextComponentParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SentenceParserTest {
    @Test(dataProvider = "sentences-data", dataProviderClass = StaticParserDataProvider.class)
    public void testWordParse(TextComponent expected, String sentenceString) throws TextParseException {
        TextComponentParser parser = new SentenceParser();
        TextComponent actual = parser.parse(sentenceString);
        Assert.assertEquals(expected, actual);
    }
}
