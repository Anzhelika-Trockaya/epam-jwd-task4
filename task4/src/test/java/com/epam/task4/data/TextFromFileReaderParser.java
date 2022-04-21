package com.epam.task4.data;

import com.epam.task4.composite.TextComponent;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.TextComponentParser;
import com.epam.task4.parser.impl.TextParser;
import com.epam.task4.reader.TextReader;
import com.epam.task4.reader.impl.TextReaderImpl;
import com.epam.task4.util.ResourcePathUtil;

public class TextFromFileReaderParser {
    private static TextFromFileReaderParser instance;
    private TextFromFileReaderParser(){}

    public static TextFromFileReaderParser getInstance() {
        if(instance==null){
            instance=new TextFromFileReaderParser();
        }
        return instance;
    }

    public TextComponent readAndParse(String fileName) throws TextParseException {
        String fileContent = read(fileName);
        TextComponentParser parser = new TextParser();
        return parser.parse(fileContent);
    }

    public String read(String fileName) throws TextParseException {
        String filePath = ResourcePathUtil.getResourcePath(fileName);
        TextReader reader = new TextReaderImpl();
        String fileContent = reader.read(filePath);
        return fileContent;
    }
}
