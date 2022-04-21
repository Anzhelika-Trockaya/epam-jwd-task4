package com.epam.task4.parser.impl;

import com.epam.task4.composite.*;
import com.epam.task4.data.StaticParserDataProvider;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.TextComponentParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberParserTest {
    @Test(dataProvider = "numbers-data", dataProviderClass = StaticParserDataProvider.class)
    public void testWordParse(TextComponent expected, String numberString) throws TextParseException {
        TextComponentParser parser = new NumberParser();
        TextComponent actual = parser.parse(numberString);
        Assert.assertEquals(expected, actual);
    }
}
