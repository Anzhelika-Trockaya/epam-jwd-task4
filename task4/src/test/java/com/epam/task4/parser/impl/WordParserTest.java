package com.epam.task4.parser.impl;

import com.epam.task4.composite.*;
import com.epam.task4.exception.TextParseException;
import com.epam.task4.parser.TextComponentParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WordParserTest {
    @DataProvider(name = "words-data")
    public static Object[][] createWordsData() {
        Object[][] data = new Object[3][2];
        data[0] = new Object[]{
                "Summer",
                createSummerWordComponent()
        };
        data[1] = new Object[]{
                "more-or-less",
                createMoreOrLessWordComponent()
        };
        data[2] = new Object[]{
                "here'",
                createHereWordComponent()
        };
        return data;
    }

    @Test(dataProvider = "words-data")
    public void testParse(String wordString, TextComponent expected) throws TextParseException {
        TextComponentParser parser = new WordParser();
        TextComponent actual = parser.parse(wordString);
        Assert.assertEquals(expected, actual);
    }

    private static TextComponent createHereWordComponent() {
        Symbol h = new Symbol(SymbolType.LETTER, 'h');
        Symbol e = new Symbol(SymbolType.LETTER, 'e');
        Symbol r = new Symbol(SymbolType.LETTER, 'r');
        Symbol apostrophe = new Symbol(SymbolType.SPELLING_MARK, '\'');
        TextComponent word = new TextComposite(ComponentType.WORD);
        word.add(h);
        word.add(e);
        word.add(r);
        word.add(e);
        word.add(apostrophe);
        return word;
    }

    private static TextComponent createMoreOrLessWordComponent() {
        Symbol m = new Symbol(SymbolType.LETTER, 'm');
        Symbol o = new Symbol(SymbolType.LETTER, 'o');
        Symbol r = new Symbol(SymbolType.LETTER, 'r');
        Symbol e = new Symbol(SymbolType.LETTER, 'e');
        Symbol l = new Symbol(SymbolType.LETTER, 'l');
        Symbol s = new Symbol(SymbolType.LETTER, 's');
        Symbol hyphen = new Symbol(SymbolType.SPELLING_MARK, '-');
        TextComponent word = new TextComposite(ComponentType.WORD);
        word.add(m);
        word.add(o);
        word.add(r);
        word.add(e);
        word.add(hyphen);
        word.add(o);
        word.add(r);
        word.add(hyphen);
        word.add(l);
        word.add(e);
        word.add(s);
        word.add(s);
        return word;
    }

    private static TextComponent createSummerWordComponent() {
        Symbol s = new Symbol(SymbolType.LETTER, 'S');
        Symbol u = new Symbol(SymbolType.LETTER, 'u');
        Symbol m = new Symbol(SymbolType.LETTER, 'm');
        Symbol e = new Symbol(SymbolType.LETTER, 'e');
        Symbol r = new Symbol(SymbolType.LETTER, 'r');
        TextComponent word = new TextComposite(ComponentType.WORD);
        word.add(s);
        word.add(u);
        word.add(m);
        word.add(m);
        word.add(e);
        word.add(r);
        return word;
    }
}
