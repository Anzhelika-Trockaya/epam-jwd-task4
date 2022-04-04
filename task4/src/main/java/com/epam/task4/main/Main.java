package com.epam.task4.main;

import com.epam.task4.composite.*;

public class Main {
    public static void main(String[] args) {
        TextComponent text = new TextComposite(ComponentType.TEXT);
        TextComponent paragraph1 = new TextComposite(ComponentType.PARAGRAPH);
        TextComponent paragraph2 = new TextComposite(ComponentType.PARAGRAPH);
        TextComponent sentence1 = new TextComposite(ComponentType.SENTENCE);
        TextComponent sentence2 = new TextComposite(ComponentType.SENTENCE);
        TextComponent sentence3 = new TextComposite(ComponentType.SENTENCE);
        TextComponent sentence4 = new TextComposite(ComponentType.SENTENCE);
        TextComponent lexeme1 = new TextComposite(ComponentType.LEXEME);
        TextComponent lexeme2 = new TextComposite(ComponentType.LEXEME);
        TextComponent lexeme3 = new TextComposite(ComponentType.LEXEME);
        TextComponent lexeme4 = new TextComposite(ComponentType.LEXEME);
        TextComponent lexeme5 = new TextComposite(ComponentType.LEXEME);
        TextComponent lexeme6 = new TextComposite(ComponentType.LEXEME);
        TextComponent lexeme7 = new TextComposite(ComponentType.LEXEME);
        TextComponent lexeme8 = new TextComposite(ComponentType.LEXEME);
        TextComponent symbol1 = new Symbol(SymbolType.LETTER,'A');
        TextComponent symbol2 = new Symbol(SymbolType.LETTER,'b');
        TextComponent symbol3 = new Symbol(SymbolType.LETTER,'c');
        TextComponent symbol4 = new Symbol(SymbolType.PUNCTUATION,'.');
        TextComponent symbol5 = new Symbol(SymbolType.LETTER,'e');
        TextComponent symbol6 = new Symbol(SymbolType.PUNCTUATION,',');
        TextComponent symbol7 = new Symbol(SymbolType.DIGIT,'1');
        TextComponent symbol8 = new Symbol(SymbolType.DIGIT,'2');
        TextComponent symbol9 = new Symbol(SymbolType.LETTER,'K');
        TextComponent symbol10 = new Symbol(SymbolType.LETTER,'l');
        TextComponent symbol11 = new Symbol(SymbolType.LETTER,'M');
        TextComponent symbol12 = new Symbol(SymbolType.PUNCTUATION,'!');
        TextComponent symbol13 = new Symbol(SymbolType.LETTER,'o');
        TextComponent symbol14 = new Symbol(SymbolType.LETTER,'p');
        TextComponent symbol15 = new Symbol(SymbolType.LETTER,'r');
        TextComponent symbol16 = new Symbol(SymbolType.PUNCTUATION,'?');
        lexeme1.add(symbol1);
        lexeme1.add(symbol2);
        lexeme2.add(symbol3);
        lexeme2.add(symbol4);
        lexeme3.add(symbol5);
        lexeme3.add(symbol6);
        lexeme4.add(symbol7);
        lexeme4.add(symbol8);
        lexeme5.add(symbol9);
        lexeme5.add(symbol10);
        lexeme6.add(symbol11);
        lexeme6.add(symbol12);
        lexeme7.add(symbol13);
        lexeme7.add(symbol14);
        lexeme8.add(symbol15);
        lexeme8.add(symbol16);
        sentence1.add(lexeme1);
        sentence1.add(lexeme2);
        sentence2.add(lexeme3);
        sentence2.add(lexeme4);
        sentence3.add(lexeme5);
        sentence3.add(lexeme6);
        sentence4.add(lexeme7);
        sentence4.add(lexeme8);
        paragraph1.add(sentence1);
        paragraph1.add(sentence2);
        paragraph2.add(sentence3);
        paragraph2.add(sentence4);
        text.add(paragraph1);
        text.add(paragraph2);
        System.out.println(text.getAsString());

    }
}
