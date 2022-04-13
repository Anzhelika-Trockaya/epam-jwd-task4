package com.epam.task4.parser.impl;

import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.TextComponent;
import com.epam.task4.composite.TextComposite;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.TextComponentParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser implements TextComponentParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String PARAGRAPHS_DELIMITER_REGEX = "\\n\\t|\\s{4}";
    private final TextComponentParser paragraphParser = new ParagraphParser();

    @Override
    public TextComponent parse(String source) throws TextParseException {
        TextComponent text = new TextComposite(ComponentType.TEXT);
        if (source.isEmpty()) {
            return text;
        }
        String trimmedSource = source.trim();
        String[] paragraphStrings = trimmedSource.split(PARAGRAPHS_DELIMITER_REGEX);
        for (String paragraphString : paragraphStrings) {
            TextComponent paragraph = paragraphParser.parse(paragraphString);
            text.add(paragraph);
        }
        LOGGER.info("Text parsed. " + text);
        return text;
    }
}
