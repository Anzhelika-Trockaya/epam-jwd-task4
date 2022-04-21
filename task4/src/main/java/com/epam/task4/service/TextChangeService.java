package com.epam.task4.service;

import com.epam.task4.composite.TextComponent;
import com.epam.task4.exception.TextParseException;

public interface TextChangeService {
    void sortParagraphsBySentencesNumber(TextComponent text) throws TextParseException;

    void removeSentencesWithWordsQuantityLessThanNumber(TextComponent text, int number) throws TextParseException;
}
