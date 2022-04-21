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
            for (int j = i + 1; j < paragraphs.size(); j++) {
                size1 = paragraphs.get(i).getChildren().size();
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
        TextComponent currentParagraph;
        for (int i = 0; i < paragraphs.size(); i++) {
            currentParagraph = paragraphs.get(i);
            removeSentencesFromParagraphWithWordsQuantityLessThanNumber(currentParagraph, number);
            if (currentParagraph.getChildren().size() == 0) {
                text.remove(currentParagraph);
                LOGGER.info("Removed paragraph: '" + currentParagraph.getAsString() + "'. ");
                i--;
            }
        }
    }

    private void removeSentencesFromParagraphWithWordsQuantityLessThanNumber(TextComponent paragraph, int number) {
        List<TextComponent> sentences = paragraph.getChildren();
        int currentWordsQuantity;
        TextComponent currentSentence;
        for (int i = 0; i < sentences.size(); i++) {
            currentSentence = sentences.get(i);
            currentWordsQuantity = countNumberOfWordsInSentence(currentSentence);
            if (currentWordsQuantity < number) {
                paragraph.remove(currentSentence);
                LOGGER.info("Removed sentence: '" + currentSentence.getAsString() + "'");
                i--;
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
