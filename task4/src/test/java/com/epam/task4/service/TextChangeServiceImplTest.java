package com.epam.task4.service;

import com.epam.task4.composite.TextComponent;
import com.epam.task4.data.TextFromFileReaderParser;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.service.impl.TextChangeServiceImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextChangeServiceImplTest {
    private static final String TEXT_FILE_NAME = "testText.txt";
    private static final String TEXT_WITH_SORTED_PARAGRAPHS_FILE_NAME = "sortParagraphsResult.txt";
    public static final String TEXT_REMOVE_RESULT_FILE_NAME = "removeSentencesResult.txt";

    @Test
    public void testSortParagraphsBySentencesNumber() throws TextParseException {
        TextFromFileReaderParser textFromFileReaderParser = TextFromFileReaderParser.getInstance();
        TextComponent actualText = null;
        TextComponent expectedText = null;
        try {
            actualText = textFromFileReaderParser.readAndParse(TEXT_FILE_NAME);
            expectedText = textFromFileReaderParser.readAndParse(TEXT_WITH_SORTED_PARAGRAPHS_FILE_NAME);
        } catch (TextParseException exception) {
            Assert.fail("Exception when parsed from file! " + exception);
        }
        TextChangeService changeService = new TextChangeServiceImpl();
        changeService.sortParagraphsBySentencesNumber(actualText);
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void testRemoveSentencesWithWordsQuantityLessThanNumber() throws TextParseException {
        int wordsNumber = 8;
        TextFromFileReaderParser textFromFileReaderParser = TextFromFileReaderParser.getInstance();
        TextComponent actualText = null;
        TextComponent expectedText = null;
        try {
            actualText = textFromFileReaderParser.readAndParse(TEXT_FILE_NAME);
            expectedText = textFromFileReaderParser.readAndParse(TEXT_REMOVE_RESULT_FILE_NAME);
        } catch (TextParseException exception) {
            Assert.fail("Exception when parsed from file! " + exception);
        }
        TextChangeService changeService = new TextChangeServiceImpl();
        changeService.removeSentencesWithWordsQuantityLessThanNumber(actualText, wordsNumber);
        Assert.assertEquals(actualText, expectedText);
    }
}
