package com.epam.task4.parser.impl;

import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.TextComponent;
import com.epam.task4.composite.TextComposite;
import com.epam.task4.data.StaticParserDataProvider;
import com.epam.task4.data.TextFromFileReaderParser;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.TextComponentParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextParserTest {
    private static final String INCORRECT_TEXT_FILE_NAME = "incorrectText.txt";

    @Test(dataProvider = "text-data", dataProviderClass = StaticParserDataProvider.class)
    public void testWordParse(TextComponent expected, String textString) throws TextParseException {
        TextComponentParser parser = new TextParser();
        TextComponent actual = parser.parse(textString);
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "text-as-string-data", dataProviderClass = StaticParserDataProvider.class)
    public void testGetAsString(String textString, String regex) throws TextParseException {
        TextComponentParser parser = new TextParser();
        TextComponent text = parser.parse(textString);
        String actual = text.getAsString();
        Assert.assertTrue(actual.matches(regex));
    }

    @Test
    public void testParseEmptyString() throws TextParseException {
        TextComponentParser parser = new TextParser();
        TextComponent actual = parser.parse("");
        TextComponent expected = new TextComposite(ComponentType.TEXT);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = TextParseException.class, expectedExceptionsMessageRegExp = "Incorrect lexeme: 'returned\\*'")
    public void testParseIncorrectText() throws TextParseException {
        TextFromFileReaderParser readerParser = TextFromFileReaderParser.getInstance();
        String content = null;
        try {
            content = readerParser.read(INCORRECT_TEXT_FILE_NAME);
        } catch (TextParseException exception) {
            Assert.fail("Exception when read from file" + exception);
        }
        TextComponentParser parser = new TextParser();
        parser.parse(content);
    }
}
