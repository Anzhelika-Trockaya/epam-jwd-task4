package com.epam.task4.service.impl;

import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.Symbol;
import com.epam.task4.composite.TextComponent;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.service.TextFindService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TextFindServiceImpl implements TextFindService {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public TextComponent findSentenceWithLongestWord(TextComponent text) throws TextParseException {
        if (ComponentType.TEXT != text.getComponentType()) {
            LOGGER.error("TextComponent must be TEXT! " + text);
            throw new TextParseException("TextComponent must be TEXT! " + text);
        }
        List<TextComponent> paragraphs = text.getChildren();
        if (paragraphs.size() == 0) {
            LOGGER.error("Text has no sentences! " + text);
            throw new TextParseException("Text has no sentences! " + text);
        }
        TextComponent sentenceResult = null;
        int maxWordsLength = 0;
        int currentLength;
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getChildren();
            for (TextComponent sentence : sentences) {
                currentLength = findMaxWordsLength(sentence);
                if (maxWordsLength < currentLength) {
                    maxWordsLength = currentLength;
                    sentenceResult = sentence;
                }
            }
        }
        if (sentenceResult != null) {
            LOGGER.info("Sentence with longest word: '" + sentenceResult.getAsString() + "'");
        } else {
            LOGGER.warn("Sentence with longest word not found. Result is null.");
        }
        return sentenceResult;
    }

    @Override
    public List<TextComponent> findAllRepeatingWords(TextComponent text) throws TextParseException {
        Set<TextComponent> words = new HashSet<>();
        List<TextComponent> repeatingWords = new ArrayList<>();
        if (ComponentType.TEXT != text.getComponentType()) {
            LOGGER.error("TextComponent must be TEXT! " + text);
            throw new TextParseException("TextComponent must be TEXT! " + text);
        }
        List<TextComponent> paragraphs = text.getChildren();
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getChildren();
            for (TextComponent sentence : sentences) {
                List<TextComponent> lexemes = sentence.getChildren();
                for (TextComponent lexeme : lexemes) {
                    List<TextComponent> lexemeParts = lexeme.getChildren();
                    for (TextComponent lexemePart : lexemeParts) {
                        if (ComponentType.WORD == lexemePart.getComponentType()) {
                            if (words.contains(lexemePart)) {
                                if (!repeatingWords.contains(lexemePart)) {
                                    repeatingWords.add(lexemePart);
                                }
                                repeatingWords.add(lexemePart);
                            } else {
                                words.add(lexemePart);
                            }
                        }
                    }
                }
            }
        }
        LOGGER.info("Repeating words: '" + words + "'");
        return repeatingWords;
    }

    @Override
    public int findNumberOfRepeatingWords(TextComponent text) throws TextParseException {
        List<TextComponent> repeatingWords = findAllRepeatingWords(text);
        LOGGER.info("Number of repeating words: '" + repeatingWords.size() + "'");
        return repeatingWords.size();
    }

    @Override
    public int countNumberOfVowels(TextComponent text) throws TextParseException {
        if (ComponentType.TEXT != text.getComponentType()) {
            LOGGER.error("TextComponent must be TEXT! " + text);
            throw new TextParseException("TextComponent must be TEXT! " + text);
        }
        List<TextComponent> paragraphs = text.getChildren();
        int currentNumber;
        int result = 0;
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getChildren();
            for (TextComponent sentence : sentences) {
                List<TextComponent> lexemes = sentence.getChildren();
                for (TextComponent lexeme : lexemes) {
                    List<TextComponent> lexemeParts = lexeme.getChildren();
                    for (TextComponent lexemePart : lexemeParts) {
                        if (ComponentType.WORD == lexemePart.getComponentType()) {
                            currentNumber = countNumberOfVowelsInWord(lexemePart);
                            result += currentNumber;
                        }
                    }
                }
            }
        }
        LOGGER.info("Number of vowels = " + result);
        return result;
    }

    @Override
    public int countNumberOfConsonants(TextComponent text) throws TextParseException {
        if (ComponentType.TEXT != text.getComponentType()) {
            LOGGER.error("TextComponent must be TEXT! " + text);
            throw new TextParseException("TextComponent must be TEXT! " + text);
        }
        List<TextComponent> paragraphs = text.getChildren();
        int currentNumber;
        int result = 0;
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getChildren();
            for (TextComponent sentence : sentences) {
                List<TextComponent> lexemes = sentence.getChildren();
                for (TextComponent lexeme : lexemes) {
                    List<TextComponent> lexemeParts = lexeme.getChildren();
                    for (TextComponent lexemePart : lexemeParts) {
                        if (ComponentType.WORD == lexemePart.getComponentType()) {
                            currentNumber = countNumberOfConsonantsInWord(lexemePart);
                            result += currentNumber;
                        }
                    }
                }
            }
        }
        LOGGER.info("Number of consonants = " + result);
        return result;
    }

    private int findMaxWordsLength(TextComponent sentence) {
        int max = 0;
        int current;
        List<TextComponent> lexemes = sentence.getChildren();
        for (TextComponent lexeme : lexemes) {
            List<TextComponent> lexemeParts = lexeme.getChildren();
            for (TextComponent lexemePart : lexemeParts) {
                if (ComponentType.WORD == lexemePart.getComponentType()) {
                    current = lexemePart.getChildren().size();
                    if (max < current) {
                        max = current;
                    }
                }
            }
        }
        return max;
    }

    private int countNumberOfVowelsInWord(TextComponent word) {
        List<TextComponent> letters = word.getChildren();
        int number = 0;
        Symbol currentSymbol;
        char currentChar;
        for (TextComponent letter : letters) {
            currentSymbol = (Symbol) letter;
            currentChar = currentSymbol.getValue();
            if (isVowel(currentChar)) {
                number++;
            }
        }
        return number;
    }

    private boolean isVowel(char letter) {
        char[] vowels = {'a', 'e', 'u', 'i', 'o', 'y', 'а', 'я', 'е', 'э', 'у', 'ю', 'и', 'ы', 'о', 'ё'};
        char letterInLowerCase = Character.toLowerCase(letter);
        for (char vowel : vowels) {
            if (letterInLowerCase == vowel) {
                return true;
            }
        }
        return false;
    }

    private int countNumberOfConsonantsInWord(TextComponent word) {
        List<TextComponent> letters = word.getChildren();
        int number = 0;
        Symbol currentSymbol;
        char currentChar;
        for (TextComponent letter : letters) {
            currentSymbol = (Symbol) letter;
            currentChar = currentSymbol.getValue();
            if (isConsonants(currentChar)) {
                number++;
            }
        }
        return number;
    }

    private boolean isConsonants(char letter) {
        return Character.isAlphabetic(letter) && !isVowel(letter);
    }
}
