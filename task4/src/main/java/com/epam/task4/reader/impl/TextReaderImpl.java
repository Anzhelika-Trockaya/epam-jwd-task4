package com.epam.task4.reader.impl;

import com.epam.task4.exception.TextParseException;
import com.epam.task4.reader.TextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextReaderImpl implements TextReader {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String read(String fileName) throws TextParseException {
        if (fileName == null || fileName.isEmpty()) {
            LOGGER.error("fileName is null or empty string");
            throw new TextParseException("Incorrect file name");
        }
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            if (bufferedReader.ready()) {
                contentBuilder.append(bufferedReader.readLine());
            }
            while (bufferedReader.ready()) {
                contentBuilder.append('\n').
                        append(bufferedReader.readLine());
            }
        } catch (IOException ioException) {
            LOGGER.error("Exception when reading from file. FileName='" + fileName + "'", ioException);
            throw new TextParseException("Exception when reading from file. FileName='" + fileName + "'", ioException);
        }
        String content = contentBuilder.toString();
        LOGGER.info("Content read. " + content);
        return content;
    }
}
