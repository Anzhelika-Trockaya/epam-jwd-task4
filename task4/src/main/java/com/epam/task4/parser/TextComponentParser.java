package com.epam.task4.parser;

import com.epam.task4.composite.TextComponent;
import com.epam.task4.exception.TextParseException;

public interface TextComponentParser {
    TextComponent parse(String source) throws TextParseException;
}
