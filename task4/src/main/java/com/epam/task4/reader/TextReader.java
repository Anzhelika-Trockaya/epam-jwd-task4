package com.epam.task4.reader;

import com.epam.task4.exception.TextParseException;

public interface TextReader {
    String read(String fileName) throws TextParseException;
}
