package com.epam.task4.parser.impl;

import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.TextComponent;
import com.epam.task4.composite.TextComposite;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.TextComponentParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements TextComponentParser {
    private static final String SENTENCE_REGEX = "([\\wа-яА-яЁё,:;(){}—'\"«»\\-+*/]+(\\s[\\wа-яА-яЁё,:;(){}—'\"«»\\-+*/]+)*[.!?…])\\s?";
    private final SentenceParser sentenceParser = new SentenceParser();

    @Override
    public TextComponent parse(String source) throws TextParseException {
        TextComponent paragraph = new TextComposite(ComponentType.PARAGRAPH);
        Pattern sentencePattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = sentencePattern.matcher(source);
        String currentSentenceString;
        TextComponent currentSentence;
        while (matcher.find()) {
            currentSentenceString = matcher.group(1);
            currentSentence = sentenceParser.parse(currentSentenceString);
            paragraph.add(currentSentence);
        }
        return paragraph;
    }
}
