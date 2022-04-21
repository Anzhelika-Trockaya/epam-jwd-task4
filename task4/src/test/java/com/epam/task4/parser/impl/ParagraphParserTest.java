package com.epam.task4.parser.impl;

import com.epam.task4.composite.TextComponent;
import com.epam.task4.data.StaticParserDataProvider;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.TextComponentParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParagraphParserTest {
    @Test(dataProvider = "paragraphs-data", dataProviderClass = StaticParserDataProvider.class)
    public void testWordParse(TextComponent expected, String paragraphString) throws TextParseException {
        TextComponentParser parser = new ParagraphParser();
        TextComponent actual = parser.parse(paragraphString);
        Assert.assertEquals(expected, actual);
    }
}
