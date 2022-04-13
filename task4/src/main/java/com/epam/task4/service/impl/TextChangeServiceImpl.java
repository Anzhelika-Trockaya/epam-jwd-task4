package com.epam.task4.service.impl;

import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.TextComponent;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.service.TextChangeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TextChangeServiceImpl implements TextChangeService {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void sortParagraphsBySentencesNumber(TextComponent text) throws TextParseException {
        if (ComponentType.TEXT != text.getComponentType()) {
            LOGGER.error("TextComponent must be TEXT! " + text);
            throw new TextParseException("TextComponent must be TEXT! " + text);
        }
        List<TextComponent> paragraphs = text.getChildren();
        if (paragraphs.size() == 0) {
            LOGGER.info("Text is empty. " + text);
            return;
        }
        int size1;
        int size2;
        TextComponent temp;
        for (int i = 0; i < paragraphs.size() - 1; i++) {
            size1 = paragraphs.get(i).getChildren().size();
            for (int j = i; j < paragraphs.size(); j++) {
                size2 = paragraphs.get(j).getChildren().size();
                if (size1 > size2) {
                    temp = paragraphs.get(i);
                    paragraphs.set(i, paragraphs.get(j));
                    paragraphs.set(j, temp);
                }
            }
        }
        LOGGER.info("Paragraphs sorted. Text: '" + text.getAsString() + "'");
    }

    @Override
    public void removeSentencesWithWordsQuantityLessThanNumber(TextComponent text, int number) throws TextParseException {
        if (ComponentType.TEXT != text.getComponentType()) {
            LOGGER.error("TextComponent must be TEXT! " + text);
            throw new TextParseException("TextComponent must be TEXT! " + text);
        }
        List<TextComponent> paragraphs = text.getChildren();
        if (paragraphs.size() == 0) {
            LOGGER.info("Text is empty. " + text);
            return;
        }
        int currentWordsQuantity;
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getChildren();
            for (TextComponent sentence : sentences) {
                currentWordsQuantity = countNumberOfWordsInSentence(sentence);
                if (currentWordsQuantity < number) {
                    paragraph.remove(sentence);
                    LOGGER.info("Removed sentence: '" + sentence.getAsString() + "'");
                }
            }
        }
    }

    private int countNumberOfWordsInSentence(TextComponent sentence) {
        int number = 0;
        List<TextComponent> lexemes = sentence.getChildren();
        for (TextComponent lexeme : lexemes) {
            List<TextComponent> lexemeParts = lexeme.getChildren();
            for (TextComponent lexemePart : lexemeParts) {
                if (ComponentType.WORD == lexemePart.getComponentType()) {
                    number++;
                }
            }
        }
        return number;
    }
}
