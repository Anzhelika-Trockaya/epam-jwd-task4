package com.epam.task4.parser.impl;

import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.TextComponent;
import com.epam.task4.composite.TextComposite;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.TextComponentParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements TextComponentParser {
    private static final Logger LOGGER = LogManager.getLogger();
    //todo private static final String SENTENCE_REGEX = "([\\wа-яА-яЁё,:;(){}—'\"«»\\-+*/]+(\\s[\\wа-яА-яЁё,:;(){}—'\"«»\\-+*/]+)*[.!?…])(\\s|$)";
    private static final String SENTENCE_REGEX = "(([^!?….]|\\.\\d)+[.!?…])(\\s|$)";
    private final TextComponentParser sentenceParser = new SentenceParser();

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
        LOGGER.info("Paragraph parsed. " + paragraph);
        return paragraph;
    }
}
