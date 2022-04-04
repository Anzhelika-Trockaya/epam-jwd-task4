package com.epam.task4.parser.impl;

import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.Delimiter;
import com.epam.task4.composite.TextComponent;
import com.epam.task4.composite.TextComposite;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.TextComponentParser;

public class TextParser implements TextComponentParser {
    private static final String PARAGRAPH_PREFIX_REGEX = "\\t|\\s{4}";
    private final ParagraphParser paragraphParser = new ParagraphParser();

    @Override
    public TextComponent parse(String source) throws TextParseException {
        TextComponent text = new TextComposite(ComponentType.TEXT);
        if (source.isEmpty()) {
            return text;
        }
        String sourceWithoutParagraphsPrefixes = source.replaceAll(PARAGRAPH_PREFIX_REGEX, Delimiter.EMPTY.getValue());
        String[] paragraphStrings = sourceWithoutParagraphsPrefixes.split(Delimiter.NEWLINE.getValue());
        for (String paragraphString : paragraphStrings) {
            TextComponent paragraph = paragraphParser.parse(paragraphString);
            text.add(paragraph);
        }
        return text;
    }
}
