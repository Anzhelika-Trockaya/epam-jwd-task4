package com.epam.task4.service;

import com.epam.task4.composite.TextComponent;
import com.epam.task4.exception.TextParseException;

import java.util.List;

public interface TextFindService {
    TextComponent findSentenceWithLongestWord(TextComponent text) throws TextParseException;

    List<TextComponent> findAllRepeatingWords(TextComponent text) throws TextParseException;

    int findNumberOfRepeatingWords(TextComponent text) throws TextParseException;

    int countNumberOfVowels(TextComponent text) throws TextParseException;

    int countNumberOfConsonants(TextComponent text) throws TextParseException;
}
