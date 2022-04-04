package com.epam.task4.parser.impl;

import com.epam.task4.composite.*;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.TextComponentParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements TextComponentParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String PUNCTUATION_REGEX = "[«»\"()'—.,;:!?…]";
    private static final String LEXEME_WITH_NUMBER_REGEX = "(-?\\d+(,\\d+)?)([.,;:!?…])?";
    private static final String MATH_EXPRESSION_REGEX = "([(-]*\\d+[-+*/)]+\\d*[+*/)]*)+";
    private static final String LEXEME_WITH_WORD_REGEX = "([«\"(])?([\\p{Alpha}а-яА-яЁё]+(-[\\p{Alpha}а-яА-яЁё]+)*('[\\p{Alpha}а-яА-яЁё]*)?)([»\").,;:!?…]*)";
    private TextComponent lexeme;
    private TextComponentParser parser;

    @Override
    public TextComponent parse(String source) throws TextParseException {
        lexeme = new TextComposite(ComponentType.LEXEME);
        if (source.matches(LEXEME_WITH_WORD_REGEX)) {
            addWordAndPunctuation(source);
        } else if (source.matches(MATH_EXPRESSION_REGEX)) {
            addMathExpressionResult(source);
        } else if (source.matches(LEXEME_WITH_NUMBER_REGEX)) {
            addNumberAndPunctuation(source);
        } else if (source.matches(PUNCTUATION_REGEX)) {
            addPunctuation(source);
        } else {
            LOGGER.error("Incorrect lexeme: \'" + source + "\'");
            throw new TextParseException("Incorrect lexeme: \'" + source + "\'");
        }
        return lexeme;
    }

    private void addWordAndPunctuation(String source) throws TextParseException {
        Pattern lexemeWithWordPattern = Pattern.compile(LEXEME_WITH_WORD_REGEX);
        Matcher matcher = lexemeWithWordPattern.matcher(source);
        if (matcher.find()) {
            if (matcher.group(1) != null) {
                addPunctuation(matcher.group(1));
            }
            if (matcher.group(2) != null) {
                addWord(matcher.group(2));
            }
            if (matcher.group(5) != null) {
                addPunctuation(matcher.group(5));
            }
        }
    }

    private void addMathExpressionResult(String source) {
        //fixme
    }

    private void addNumberAndPunctuation(String source) throws TextParseException {
        Pattern lexemeWithWordPattern = Pattern.compile(LEXEME_WITH_NUMBER_REGEX);
        Matcher matcher = lexemeWithWordPattern.matcher(source);
        if (matcher.find()) {
            String numberString = matcher.group(1);
            addNumber(numberString);
            if (matcher.group(3) != null) {
                addPunctuation(matcher.group(3));
            }
        }
    }

    private void addNumber(String numberString) throws TextParseException {
        parser = new NumberParser();
        TextComponent number = parser.parse(numberString);
        lexeme.add(number);
    }

    private void addWord(String wordString) throws TextParseException {
        parser = new WordParser();
        TextComponent word = parser.parse(wordString);
        lexeme.add(word);
    }

    private void addPunctuation(String punctuationString) {
        Symbol punctuation;
        for (int i = 0; i < punctuationString.length(); i++) {
            punctuation = new Symbol(SymbolType.PUNCTUATION, punctuationString.charAt(i));
            lexeme.add(punctuation);
        }
    }
}
