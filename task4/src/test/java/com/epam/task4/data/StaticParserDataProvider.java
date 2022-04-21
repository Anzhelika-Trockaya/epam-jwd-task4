package com.epam.task4.data;

import com.epam.task4.composite.*;
import org.testng.annotations.DataProvider;

import static com.epam.task4.data.SymbolData.*;

public class StaticParserDataProvider {

    @DataProvider(name = "words-data")
    public static Object[][] createWordsData() {
        Object[][] data = new Object[18][];
        TextComponent word0 = new TextComposite(ComponentType.WORD);
        word0.add(ENGLISH_BIG_LETTERS[4]);
        word0.add(ENGLISH_SMALL_LETTERS[21]);
        word0.add(ENGLISH_SMALL_LETTERS[4]);
        word0.add(ENGLISH_SMALL_LETTERS[17]);
        word0.add(ENGLISH_SMALL_LETTERS[24]);
        data[0] = new Object[]{word0, "Every"};
        TextComponent word1 = new TextComposite(ComponentType.WORD);
        word1.add(ENGLISH_SMALL_LETTERS[3]);
        word1.add(ENGLISH_SMALL_LETTERS[0]);
        word1.add(ENGLISH_SMALL_LETTERS[24]);
        word1.add(APOSTROPHE);
        data[1] = new Object[]{word1, "day'"};
        TextComponent word2 = new TextComposite(ComponentType.WORD);
        word2.add(ENGLISH_SMALL_LETTERS[8]);
        word2.add(ENGLISH_SMALL_LETTERS[13]);
        data[2] = new Object[]{word2, "in"};
        TextComponent word3 = new TextComposite(ComponentType.WORD);
        word3.add(ENGLISH_SMALL_LETTERS[18]);
        word3.add(ENGLISH_SMALL_LETTERS[2]);
        word3.add(ENGLISH_SMALL_LETTERS[7]);
        word3.add(ENGLISH_SMALL_LETTERS[14]);
        word3.add(ENGLISH_SMALL_LETTERS[14]);
        word3.add(ENGLISH_SMALL_LETTERS[11]);
        data[3] = new Object[]{word3, "school"};
        TextComponent word4 = new TextComposite(ComponentType.WORD);
        word4.add(ENGLISH_BIG_LETTERS[1]);
        word4.add(ENGLISH_SMALL_LETTERS[4]);
        word4.add(ENGLISH_SMALL_LETTERS[6]);
        word4.add(ENGLISH_SMALL_LETTERS[8]);
        word4.add(ENGLISH_SMALL_LETTERS[13]);
        word4.add(ENGLISH_SMALL_LETTERS[18]);
        data[4] = new Object[]{word4, "Begins"};
        TextComponent word5 = new TextComposite(ComponentType.WORD);
        word5.add(ENGLISH_SMALL_LETTERS[0]);
        word5.add(ENGLISH_SMALL_LETTERS[19]);
        data[5] = new Object[]{word5, "at"};
        TextComponent word6 = new TextComposite(ComponentType.WORD);
        word6.add(ENGLISH_BIG_LETTERS[12]);
        word6.add(ENGLISH_SMALL_LETTERS[0]);
        word6.add(ENGLISH_SMALL_LETTERS[13]);
        word6.add(ENGLISH_SMALL_LETTERS[24]);
        data[6] = new Object[]{word6, "Many"};
        TextComponent word7 = new TextComposite(ComponentType.WORD);
        word7.add(ENGLISH_SMALL_LETTERS[1]);
        word7.add(ENGLISH_SMALL_LETTERS[20]);
        word7.add(ENGLISH_SMALL_LETTERS[19]);
        data[7] = new Object[]{word7, "but"};
        TextComponent word8 = new TextComposite(ComponentType.WORD);
        word8.add(ENGLISH_SMALL_LETTERS[8]);
        word8.add(ENGLISH_SMALL_LETTERS[18]);
        word8.add(ENGLISH_SMALL_LETTERS[13]);
        word8.add(APOSTROPHE);
        word8.add(ENGLISH_SMALL_LETTERS[19]);
        data[8] = new Object[]{word8, "isn't"};
        TextComponent word9 = new TextComposite(ComponentType.WORD);
        word9.add(ENGLISH_BIG_LETTERS[2]);
        word9.add(ENGLISH_SMALL_LETTERS[14]);
        word9.add(ENGLISH_SMALL_LETTERS[11]);
        word9.add(ENGLISH_SMALL_LETTERS[3]);
        data[9] = new Object[]{word9, "Cold"};
        TextComponent word10 = new TextComposite(ComponentType.WORD);
        word10.add(RUSSIAN_SMALL_LETTERS[4]);
        word10.add(RUSSIAN_SMALL_LETTERS[15]);
        word10.add(RUSSIAN_SMALL_LETTERS[7]);
        word10.add(RUSSIAN_SMALL_LETTERS[4]);
        word10.add(RUSSIAN_SMALL_LETTERS[27]);
        data[10] = new Object[]{word10, "дождь"};
        TextComponent word11 = new TextComposite(ComponentType.WORD);
        word11.add(RUSSIAN_SMALL_LETTERS[9]);
        word11.add(RUSSIAN_SMALL_LETTERS[4]);
        word11.add(RUSSIAN_SMALL_LETTERS[6]);
        word11.add(RUSSIAN_SMALL_LETTERS[19]);
        data[11] = new Object[]{word11, "идёт"};
        TextComponent word12 = new TextComposite(ComponentType.WORD);
        word12.add(RUSSIAN_BIG_LETTERS[12]);
        word12.add(RUSSIAN_SMALL_LETTERS[20]);
        word12.add(RUSSIAN_SMALL_LETTERS[24]);
        data[12] = new Object[]{word12, "Луч"};
        TextComponent word13 = new TextComposite(ComponentType.WORD);
        word13.add(RUSSIAN_SMALL_LETTERS[15]);
        word13.add(RUSSIAN_SMALL_LETTERS[11]);
        data[13] = new Object[]{word13, "ок"};
        TextComponent word14 = new TextComposite(ComponentType.WORD);
        word14.add(RUSSIAN_BIG_LETTERS[32]);
        word14.add(RUSSIAN_SMALL_LETTERS[17]);
        word14.add(UNDERSCORE);
        word14.add(RUSSIAN_SMALL_LETTERS[11]);
        word14.add(RUSSIAN_SMALL_LETTERS[15]);
        data[14] = new Object[]{word14, "Яр_ко"};
        TextComponent word15 = new TextComposite(ComponentType.WORD);
        word15.add(RUSSIAN_SMALL_LETTERS[18]);
        word15.add(RUSSIAN_SMALL_LETTERS[19]);
        word15.add(RUSSIAN_SMALL_LETTERS[15]);
        word15.add(RUSSIAN_SMALL_LETTERS[16]);
        data[15] = new Object[]{word15, "стоп"};
        TextComponent word16 = new TextComposite(ComponentType.WORD);
        word16.add(ENGLISH_SMALL_LETTERS[12]);
        word16.add(ENGLISH_SMALL_LETTERS[14]);
        word16.add(ENGLISH_SMALL_LETTERS[17]);
        word16.add(ENGLISH_SMALL_LETTERS[4]);
        word16.add(HYPHEN);
        word16.add(ENGLISH_SMALL_LETTERS[14]);
        word16.add(ENGLISH_SMALL_LETTERS[17]);
        word16.add(HYPHEN);
        word16.add(ENGLISH_SMALL_LETTERS[11]);
        word16.add(ENGLISH_SMALL_LETTERS[4]);
        word16.add(ENGLISH_SMALL_LETTERS[18]);
        word16.add(ENGLISH_SMALL_LETTERS[18]);
        data[16] = new Object[]{word16, "more-or-less"};
        TextComponent word17 = new TextComposite(ComponentType.WORD);
        word17.add(RUSSIAN_BIG_LETTERS[11]);
        word17.add(RUSSIAN_SMALL_LETTERS[15]);
        word17.add(RUSSIAN_SMALL_LETTERS[14]);
        word17.add(RUSSIAN_SMALL_LETTERS[5]);
        word17.add(RUSSIAN_SMALL_LETTERS[23]);
        data[17] = new Object[]{word17, "Конец"};
        return data;
    }

    @DataProvider(name = "numbers-data")
    public static Object[][] createNumbersData() {
        Object[][] data = new Object[5][];
        TextComponent number1 = new TextComposite(ComponentType.NUMBER);
        number1.add(DIGITS[9]);
        data[0] = new Object[]{number1, "9"};
        TextComponent number2 = new TextComposite(ComponentType.NUMBER);
        number2.add(DIGITS[1]);
        number2.add(DIGITS[0]);
        number2.add(DIGITS[9]);
        data[1] = new Object[]{number2, "109"};
        TextComponent number3 = new TextComposite(ComponentType.NUMBER);
        number3.add(DIGITS[2]);
        number3.add(DIGITS[7]);
        number3.add(DIGITS[3]);
        number3.add(FRACTIONAL_POINT);
        number3.add(DIGITS[5]);
        number3.add(DIGITS[4]);
        data[2] = new Object[]{number3, "273.54"};
        TextComponent number4 = new TextComposite(ComponentType.NUMBER);
        number4.add(MINUS);
        number4.add(DIGITS[6]);
        number4.add(DIGITS[8]);
        data[3] = new Object[]{number4, "-68"};
        TextComponent number5 = new TextComposite(ComponentType.NUMBER);
        number5.add(MINUS);
        number5.add(DIGITS[1]);
        number5.add(FRACTIONAL_COMMA);
        number5.add(DIGITS[5]);
        data[4] = new Object[]{number5, "-1,5"};
        return data;
    }

    @DataProvider(name = "expressions-data")
    public static Object[][] createExpressionsData() {
        Object[][] data = new Object[5][];
        TextComponent answer1 = new TextComposite(ComponentType.NUMBER);
        answer1.add(DIGITS[9]);
        answer1.add(FRACTIONAL_POINT);
        answer1.add(DIGITS[0]);
        data[0] = new Object[]{answer1, "5+4"};
        TextComponent answer2 = new TextComposite(ComponentType.NUMBER);
        answer2.add(MINUS);
        answer2.add(DIGITS[7]);
        answer2.add(DIGITS[7]);
        answer2.add(FRACTIONAL_POINT);
        answer2.add(DIGITS[0]);
        data[1] = new Object[]{answer2, "(-77)"};
        TextComponent answer3 = new TextComposite(ComponentType.NUMBER);
        answer3.add(DIGITS[1]);
        answer3.add(FRACTIONAL_POINT);
        answer3.add(DIGITS[6]);
        data[2] = new Object[]{answer3, "16/(5*(10-8))"};
        TextComponent answer4 = new TextComposite(ComponentType.NUMBER);
        answer4.add(MINUS);
        answer4.add(DIGITS[0]);
        answer4.add(FRACTIONAL_POINT);
        answer4.add(DIGITS[3]);
        answer4.add(DIGITS[9]);
        data[3] = new Object[]{answer4, "((3-8)*6-9)/100"};
        TextComponent answer5 = new TextComposite(ComponentType.NUMBER);
        answer5.add(DIGITS[3]);
        answer5.add(FRACTIONAL_POINT);
        answer5.add(DIGITS[0]);
        data[4] = new Object[]{answer5, "-(-3)"};
        return data;
    }

    @DataProvider(name = "lexemes-data")
    public static Object[][] createLexemesData() {
        Object[][] data = new Object[27][];
        Object[][] wordsData = createWordsData();
        Object[][] numbersData = createNumbersData();
        Object[][] expressionsData = createExpressionsData();
        TextComponent lexeme0 = new TextComposite(ComponentType.LEXEME);
        lexeme0.add((TextComponent) wordsData[0][0]);
        data[0] = new Object[]{lexeme0, "Every"};
        TextComponent lexeme1 = new TextComposite(ComponentType.LEXEME);
        lexeme1.add((TextComponent) wordsData[1][0]);
        lexeme1.add(COMMA);
        data[1] = new Object[]{lexeme1, "day',"};
        TextComponent lexeme2 = new TextComposite(ComponentType.LEXEME);
        lexeme2.add((TextComponent) wordsData[2][0]);
        data[2] = new Object[]{lexeme2, "in"};
        TextComponent lexeme3 = new TextComposite(ComponentType.LEXEME);
        lexeme3.add((TextComponent) wordsData[3][0]);
        data[3] = new Object[]{lexeme3, "school"};
        TextComponent lexeme4 = new TextComposite(ComponentType.LEXEME);
        lexeme4.add(QUOTE);
        lexeme4.add((TextComponent) wordsData[4][0]);
        lexeme4.add(QUOTE);
        data[4] = new Object[]{lexeme4, "\"Begins\""};
        TextComponent lexeme5 = new TextComposite(ComponentType.LEXEME);
        lexeme5.add((TextComponent) wordsData[5][0]);
        data[5] = new Object[]{lexeme5, "at"};
        TextComponent lexeme6 = new TextComposite(ComponentType.LEXEME);
        lexeme6.add((TextComponent) numbersData[0][0]);
        lexeme6.add(DOT);
        data[6] = new Object[]{lexeme6, "9."};
        TextComponent lexeme7 = new TextComposite(ComponentType.LEXEME);
        lexeme7.add(OPEN_ANGLE_QUOTE);
        lexeme7.add((TextComponent) wordsData[6][0]);
        lexeme7.add(CLOSE_ANGLE_QUOTE);
        lexeme7.add(COMMA);
        data[7] = new Object[]{lexeme7, "«Many»,"};
        TextComponent lexeme8 = new TextComposite(ComponentType.LEXEME);
        lexeme8.add((TextComponent) numbersData[2][0]);
        data[8] = new Object[]{lexeme8, "273.54"};
        TextComponent lexeme9 = new TextComposite(ComponentType.LEXEME);
        lexeme9.add((TextComponent) wordsData[7][0]);
        lexeme9.add(COLON);
        data[9] = new Object[]{lexeme9, "but:"};
        TextComponent lexeme10 = new TextComposite(ComponentType.LEXEME);
        lexeme10.add((TextComponent) wordsData[8][0]);
        lexeme10.add(DOT);
        data[10] = new Object[]{lexeme10, "isn't."};
        TextComponent lexeme11 = new TextComposite(ComponentType.LEXEME);
        lexeme11.add((TextComponent) wordsData[9][0]);
        data[11] = new Object[]{lexeme11, "Cold"};
        TextComponent lexeme12 = new TextComposite(ComponentType.LEXEME);
        lexeme12.add((TextComponent) expressionsData[0][0]);
        lexeme12.add(EXCLAMATION_MARK);
        data[12] = new Object[]{lexeme12, "5+4!"};
        TextComponent lexeme13 = new TextComposite(ComponentType.LEXEME);
        lexeme13.add((TextComponent) expressionsData[1][0]);
        data[13] = new Object[]{lexeme13, "(-77)"};
        TextComponent lexeme14 = new TextComposite(ComponentType.LEXEME);
        lexeme14.add((TextComponent) wordsData[10][0]);
        data[14] = new Object[]{lexeme14, "дождь"};
        TextComponent lexeme15 = new TextComposite(ComponentType.LEXEME);
        lexeme15.add(DASH);
        data[15] = new Object[]{lexeme15, "—"};
        TextComponent lexeme16 = new TextComposite(ComponentType.LEXEME);
        lexeme16.add((TextComponent) wordsData[11][0]);
        lexeme16.add(ELLIPSIS);
        data[16] = new Object[]{lexeme16, "идёт…"};
        TextComponent lexeme17 = new TextComposite(ComponentType.LEXEME);
        lexeme17.add(OPEN_PARENTHESIS);
        lexeme17.add((TextComponent) wordsData[12][0]);
        data[17] = new Object[]{lexeme17, "(Луч"};
        TextComponent lexeme18 = new TextComposite(ComponentType.LEXEME);
        lexeme18.add((TextComponent) expressionsData[2][0]);
        lexeme18.add(SEMICOLON);
        data[18] = new Object[]{lexeme18, "16/(5*(10-8));"};
        TextComponent lexeme19 = new TextComposite(ComponentType.LEXEME);
        lexeme19.add((TextComponent) wordsData[13][0]);
        lexeme19.add(CLOSE_PARENTHESIS);
        lexeme19.add(QUESTION_MARK);
        data[19] = new Object[]{lexeme19, "ок)?"};
        TextComponent lexeme20 = new TextComposite(ComponentType.LEXEME);
        lexeme20.add((TextComponent) wordsData[14][0]);
        data[20] = new Object[]{lexeme20, "Яр_ко"};
        TextComponent lexeme21 = new TextComposite(ComponentType.LEXEME);
        lexeme21.add(OPEN_CURLY_BRACKET);
        lexeme21.add((TextComponent) wordsData[15][0]);
        lexeme21.add(CLOSE_CURLY_BRACKET);
        data[21] = new Object[]{lexeme21, "{стоп}"};
        TextComponent lexeme22 = new TextComposite(ComponentType.LEXEME);
        lexeme22.add((TextComponent) wordsData[16][0]);
        lexeme22.add(DOT);
        data[22] = new Object[]{lexeme22, "more-or-less."};
        TextComponent lexeme23 = new TextComposite(ComponentType.LEXEME);
        lexeme23.add((TextComponent) expressionsData[3][0]);
        lexeme23.add(COMMA);
        data[23] = new Object[]{lexeme23, "((3-8)*6-9)/100,"};
        TextComponent lexeme24 = new TextComposite(ComponentType.LEXEME);
        lexeme24.add((TextComponent) expressionsData[4][0]);
        lexeme24.add(DOT);
        data[24] = new Object[]{lexeme24, "-(-3)."};
        TextComponent lexeme25 = new TextComposite(ComponentType.LEXEME);
        lexeme25.add((TextComponent) numbersData[4][0]);
        lexeme25.add(QUESTION_MARK);
        data[25] = new Object[]{lexeme25, "-1,5?"};
        TextComponent lexeme26 = new TextComposite(ComponentType.LEXEME);
        lexeme26.add((TextComponent) wordsData[17][0]);
        lexeme26.add(DOT);
        data[26] = new Object[]{lexeme26, "Конец."};
        return data;
    }

    @DataProvider(name = "sentences-data")
    public static Object[][] createSentencesData() {
        Object[][] data = new Object[9][];
        Object[][] lexemesData = createLexemesData();
        TextComponent sentence0 = new TextComposite(ComponentType.SENTENCE);
        sentence0.add((TextComponent) lexemesData[0][0]);
        sentence0.add((TextComponent) lexemesData[1][0]);
        sentence0.add((TextComponent) lexemesData[2][0]);
        sentence0.add((TextComponent) lexemesData[3][0]);
        sentence0.add((TextComponent) lexemesData[4][0]);
        sentence0.add((TextComponent) lexemesData[5][0]);
        sentence0.add((TextComponent) lexemesData[6][0]);
        data[0] = new Object[]{sentence0, "Every day', in school \"Begins\" at 9."};
        TextComponent sentence1 = new TextComposite(ComponentType.SENTENCE);
        sentence1.add((TextComponent) lexemesData[7][0]);
        sentence1.add((TextComponent) lexemesData[8][0]);
        sentence1.add((TextComponent) lexemesData[9][0]);
        sentence1.add((TextComponent) lexemesData[10][0]);
        data[1] = new Object[]{sentence1, "«Many», 273.54 but: isn't."};
        TextComponent sentence2 = new TextComposite(ComponentType.SENTENCE);
        sentence2.add((TextComponent) lexemesData[11][0]);
        sentence2.add((TextComponent) lexemesData[12][0]);
        data[2] = new Object[]{sentence2, "Cold 5+4!"};
        TextComponent sentence3 = new TextComposite(ComponentType.SENTENCE);
        sentence3.add((TextComponent) lexemesData[13][0]);
        sentence3.add((TextComponent) lexemesData[14][0]);
        sentence3.add((TextComponent) lexemesData[15][0]);
        sentence3.add((TextComponent) lexemesData[16][0]);
        data[3] = new Object[]{sentence3, "(-77) дождь — идёт…"};
        TextComponent sentence4 = new TextComposite(ComponentType.SENTENCE);
        sentence4.add((TextComponent) lexemesData[17][0]);
        sentence4.add((TextComponent) lexemesData[18][0]);
        sentence4.add((TextComponent) lexemesData[19][0]);
        data[4] = new Object[]{sentence4, "(Луч 16/(5*(10-8)); ок)?"};
        TextComponent sentence5 = new TextComposite(ComponentType.SENTENCE);
        sentence5.add((TextComponent) lexemesData[20][0]);
        sentence5.add((TextComponent) lexemesData[21][0]);
        sentence5.add((TextComponent) lexemesData[22][0]);
        data[5] = new Object[]{sentence5, "Яр_ко {стоп} more-or-less."};
        TextComponent sentence6 = new TextComposite(ComponentType.SENTENCE);
        sentence6.add((TextComponent) lexemesData[23][0]);
        sentence6.add((TextComponent) lexemesData[24][0]);
        data[6] = new Object[]{sentence6, "((3-8)*6-9)/100, -(-3)."};
        TextComponent sentence7 = new TextComposite(ComponentType.SENTENCE);
        sentence7.add((TextComponent) lexemesData[25][0]);
        data[7] = new Object[]{sentence7, "-1,5?"};
        TextComponent sentence8 = new TextComposite(ComponentType.SENTENCE);
        sentence8.add((TextComponent) lexemesData[26][0]);
        data[8] = new Object[]{sentence8, "Конец."};
        return data;
    }

    @DataProvider(name = "paragraphs-data")
    public static Object[][] createParagraphsData() {
        Object[][] data = new Object[4][];
        Object[][] sentencesData = createSentencesData();
        TextComponent paragraph0 = new TextComposite(ComponentType.PARAGRAPH);
        paragraph0.add((TextComponent) sentencesData[0][0]);
        paragraph0.add((TextComponent) sentencesData[1][0]);
        paragraph0.add((TextComponent) sentencesData[2][0]);
        data[0] = new Object[]{paragraph0, "Every day', in school \"Begins\" at 9. «Many», 273.54 but: isn't. Cold 5+4!"};
        TextComponent paragraph1 = new TextComposite(ComponentType.PARAGRAPH);
        paragraph1.add((TextComponent) sentencesData[3][0]);
        paragraph1.add((TextComponent) sentencesData[4][0]);
        data[1] = new Object[]{paragraph1, "(-77) дождь — идёт… (Луч 16/(5*(10-8)); ок)?"};
        TextComponent paragraph2 = new TextComposite(ComponentType.PARAGRAPH);
        paragraph2.add((TextComponent) sentencesData[5][0]);
        paragraph2.add((TextComponent) sentencesData[6][0]);
        paragraph2.add((TextComponent) sentencesData[7][0]);
        data[2] = new Object[]{paragraph2, "Яр_ко {стоп} more-or-less. ((3-8)*6-9)/100, -(-3). -1,5?"};
        TextComponent paragraph3 = new TextComposite(ComponentType.PARAGRAPH);
        paragraph3.add((TextComponent) sentencesData[8][0]);
        data[3] = new Object[]{paragraph3, "Конец."};
        return data;
    }

    @DataProvider(name = "text-data")
    public static Object[][] createTextData() {
        Object[][] data = new Object[1][];
        Object[][] paragraphsData = createParagraphsData();
        TextComponent text = new TextComposite(ComponentType.TEXT);
        text.add((TextComponent) paragraphsData[0][0]);
        text.add((TextComponent) paragraphsData[1][0]);
        text.add((TextComponent) paragraphsData[2][0]);
        text.add((TextComponent) paragraphsData[3][0]);
        StringBuilder textBuilder = new StringBuilder();
        textBuilder.append("\tEvery day', in school \"Begins\" at 9. «Many», 273.54 but: isn't. Cold 5+4!\n").
                append("    (-77) дождь — идёт… (Луч 16/(5*(10-8)); ок)?\n").
                append("\tЯр_ко {стоп} more-or-less. ((3-8)*6-9)/100, -(-3). -1,5?\n").
                append("\tКонец.");
        data[0] = new Object[]{text, textBuilder.toString()};
        return data;
    }

    @DataProvider(name = "text-as-string-data")
    public static Object[][] createTextStringData() {
        StringBuilder textBuilder = new StringBuilder();
        textBuilder.append("\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting").
                append(", remaining -3-5 essentially 6*9/(3+4) unchanged. It was popularised in the 5*(1+2*(3/(4-").
                append("(1-56-47)*73)+(-89+4/(42/7)))+1) with the release of Letraset sheets containing Lorem Ipsum").
                append(" passages, and more recently with desktop publishing software like Aldus PageMaker including").
                append(" versions of Lorem Ipsum.\n\tIt is a long established fact that a reader will be distracted ").
                append("by the readable content of a page when looking at its layout. The point of using (-71+(2+3/(3*(").
                append("2+1/2+2)-2)/10+2))/7 Ipsum is that it has a more-or-less normal distribution of letters, ").
                append("as opposed to using (Content here), content here', making it look like readable English.\n\t").
                append("It is a (7+5*12*(2+5-2-71))/12 established fact that a reader will be of a page when looking ").
                append("at its layout.\n\tBye.");
        StringBuilder regexBuilder = new StringBuilder();
        regexBuilder.append("\tIt has survived - not only \\(five\\) centuries, but also the leap into electronic typesetting").
                append(", remaining -8.0 essentially \\d+\\.\\d+ unchanged\\. It was popularised in the -?\\d+\\.\\d+").
                append(" with the release of Letraset sheets containing Lorem Ipsum").
                append(" passages, and more recently with desktop publishing software like Aldus PageMaker including").
                append(" versions of Lorem Ipsum\\.\\n\\tIt is a long established fact that a reader will be distracted ").
                append("by the readable content of a page when looking at its layout\\. The point of using -?\\d+\\.\\d+").
                append(" Ipsum is that it has a more-or-less normal distribution of letters, ").
                append("as opposed to using \\(Content here\\), content here', making it look like readable English\\.").
                append("\\n\\tIt is a -?\\d+\\.\\d+ established fact that a reader will be of a page when looking ").
                append("at its layout\\.\\n\\tBye\\.");
        Object[][] data = new Object[1][];
        data[0]=new Object[]{textBuilder.toString(), regexBuilder.toString()};
        return data;
    }
}
