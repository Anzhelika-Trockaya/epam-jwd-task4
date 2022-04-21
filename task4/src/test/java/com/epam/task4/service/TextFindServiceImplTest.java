package com.epam.task4.service;

import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.TextComponent;
import com.epam.task4.composite.TextComposite;
import com.epam.task4.data.TextFromFileReaderParser;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.service.impl.TextFindServiceImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextFindServiceImplTest {
    private static final String TEXT_FILE_NAME = "testText.txt";
    private static final String REPEATING_WORDS_FILE_NAME = "repeatingWords.txt";
    private static final String TEXT_FOR_COUNTING_VOWELS_AND_CONSONANTS_FILE_NAME = "textForCountVowelsAndConsonants.txt";

    @Test
    public void testFindSentenceWithLongestWord() throws TextParseException {
        TextFromFileReaderParser textFromFileReaderParser = TextFromFileReaderParser.getInstance();
        TextComponent text = null;
        try {
            text = textFromFileReaderParser.readAndParse(TEXT_FILE_NAME);
        } catch (TextParseException exception) {
            Assert.fail("Exception when parsed from file! " + exception);
        }
        TextFindService findService = new TextFindServiceImpl();
        TextComponent resultSentence = findService.findSentenceWithLongestWord(text);
        String actual = resultSentence.getAsString();
        String expected = "My favorite was the Louvre, a well-known museum.";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindAllRepeatingWords() throws TextParseException {
        TextFromFileReaderParser textFromFileReaderParser = TextFromFileReaderParser.getInstance();
        TextComponent text = null;
        try {
            text = textFromFileReaderParser.readAndParse(TEXT_FILE_NAME);
        } catch (TextParseException exception) {
            Assert.fail("Exception when parsed from file! " + exception);
        }
        List<String> expected = null;
        try {
            expected = getExpectedRepeatingWordsList();
        } catch (TextParseException exception) {
            Assert.fail("Exception when reading expected List!" + exception);
        }
        TextFindService findService = new TextFindServiceImpl();
        List<TextComponent> actualTextComponentsList = findService.findAllRepeatingWords(text);
        expected = expected.stream().sorted().collect(Collectors.toList());
        List<String> actual = actualTextComponentsList.stream().map(TextComponent::getAsString).sorted().collect(Collectors.toList());
        Assert.assertEquals(actual.size(), expected.size());
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindNumberOfRepeatingWords() throws TextParseException {
        TextFromFileReaderParser textFromFileReaderParser = TextFromFileReaderParser.getInstance();
        TextComponent text = null;
        try {
            text = textFromFileReaderParser.readAndParse(TEXT_FILE_NAME);
        } catch (TextParseException exception) {
            Assert.fail("Exception when parsed from file! " + exception);
        }
        TextFindService findService = new TextFindServiceImpl();
        int actualNumber = findService.findNumberOfRepeatingWords(text);
        int expectedNumber = 46;
        Assert.assertEquals(actualNumber, expectedNumber);
    }

    @Test
    public void testCountNumberOfVowels() throws TextParseException {
        TextFromFileReaderParser textFromFileReaderParser = TextFromFileReaderParser.getInstance();
        TextComponent text = null;
        try {
            text = textFromFileReaderParser.readAndParse(TEXT_FOR_COUNTING_VOWELS_AND_CONSONANTS_FILE_NAME);
        } catch (TextParseException exception) {
            Assert.fail("Exception when parsed from file! " + exception);
        }
        TextFindService findService = new TextFindServiceImpl();
        int actual = findService.countNumberOfVowels(text);
        int expected = 94;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCountNumberOfConsonants() throws TextParseException {
        TextFromFileReaderParser textFromFileReaderParser = TextFromFileReaderParser.getInstance();
        TextComponent text = null;
        try {
            text = textFromFileReaderParser.readAndParse(TEXT_FOR_COUNTING_VOWELS_AND_CONSONANTS_FILE_NAME);
        } catch (TextParseException exception) {
            Assert.fail("Exception when parsed from file! " + exception);
        }
        TextFindService findService = new TextFindServiceImpl();
        int actual = findService.countNumberOfConsonants(text);
        int expected = 122;
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = TextParseException.class, expectedExceptionsMessageRegExp = "Text has no sentences! .+")
    public void testFindSentenceWithLongestWordEmptyText() throws TextParseException {
        TextComponent text = new TextComposite(ComponentType.TEXT);
        TextFindService findService = new TextFindServiceImpl();
        findService.findSentenceWithLongestWord(text);
    }

    @Test
    public void testFindAllRepeatingWordsEmptyText() throws TextParseException {
        TextComponent text = new TextComposite(ComponentType.TEXT);
        TextFindService findService = new TextFindServiceImpl();
        List<TextComponent> actualTextComponentsList = findService.findAllRepeatingWords(text);
        Assert.assertEquals(actualTextComponentsList.size(), 0);
    }

    @Test
    public void testFindNumberOfRepeatingWordsEmptyText() throws TextParseException {
        TextComponent text = new TextComposite(ComponentType.TEXT);
        TextFindService findService = new TextFindServiceImpl();
        int actualNumber = findService.findNumberOfRepeatingWords(text);
        int expectedNumber = 0;
        Assert.assertEquals(actualNumber, expectedNumber);
    }

    @Test
    public void testCountNumberOfVowelsEmptyText() throws TextParseException {
        TextComponent text = new TextComposite(ComponentType.TEXT);
        TextFindService findService = new TextFindServiceImpl();
        int actual = findService.countNumberOfVowels(text);
        int expected = 0;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCountNumberOfConsonantsEmptyText() throws TextParseException {
        TextComponent text = new TextComposite(ComponentType.TEXT);
        TextFindService findService = new TextFindServiceImpl();
        int actual = findService.countNumberOfConsonants(text);
        int expected = 0;
        Assert.assertEquals(actual, expected);
    }

    private List<String> getExpectedRepeatingWordsList() throws TextParseException {
        TextFromFileReaderParser readerParser = TextFromFileReaderParser.getInstance();
        String content = readerParser.read(REPEATING_WORDS_FILE_NAME);
        String[] repeatingWordsArray = content.split("\\s");
        return new ArrayList<>(Arrays.asList(repeatingWordsArray));
    }
}
