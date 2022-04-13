package com.epam.task4.converter;

import com.epam.task4.exception.TextParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class MathExpressionConverter {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String OPERATORS = "+-*/";
    private static final String DELIMITERS = "() +-*/";
    private static final String SPACE = " ";
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String OPEN_BRACKET = "(";
    private static final String CLOSING_BRACKET = ")";
    private static final String UNARY_MINUS = "u-";
    private static final String EMPTY = "";
    private List<String> result;
    private Deque<String> stack;

    public List<String> convertToPolishNotation(String expressionString) throws TextParseException {
        result = new ArrayList<>();
        stack = new ArrayDeque<>();
        StringTokenizer tokenizer = new StringTokenizer(expressionString, DELIMITERS, true);
        String prev = EMPTY;
        String curr;
        while (tokenizer.hasMoreTokens()) {
            curr = tokenizer.nextToken();
            if (!tokenizer.hasMoreTokens() && isOperator(curr)) {//todo if ( is last symbol
                LOGGER.error("Incorrect expression: '" + expressionString + "'");
                throw new TextParseException("Incorrect expression: '" + expressionString + "'");
            }
            switch (curr) {
                case SPACE:
                    continue;
                case OPEN_BRACKET:
                    stack.push(curr);
                    break;
                case CLOSING_BRACKET:
                    processClosingBracket();
                    break;
                default: {
                    if (isOperator(curr)) {
                        processOperator(curr, prev);
                    } else {
                        result.add(curr);
                    }
                }
            }
            prev = curr;
        }
        addStackElementsToResult();
        LOGGER.info("Expression '" + expressionString + "' converted successfully to polish notation " + result);
        return result;
    }

    private void processClosingBracket() throws TextParseException {
        if (stack.isEmpty()) {
            LOGGER.error("Brackets are not matched");
            throw new TextParseException("Brackets are not matched");
        }
        while (!OPEN_BRACKET.equals(stack.peek())) {
            result.add(stack.pop());
            if (stack.isEmpty()) {
                LOGGER.error("Brackets are not matched");
                throw new TextParseException("Brackets are not matched");
            }
        }
        stack.pop();
    }

    private void processOperator(String curr, String prev) {
        if (curr.equals(MINUS) && (prev.isEmpty() || (isDelimiter(prev) && !prev.equals(CLOSING_BRACKET)))) {
            curr = UNARY_MINUS;
        } else {
            while (!stack.isEmpty() && (priority(curr) <= priority(stack.peek()))) {
                result.add(stack.pop());
            }
        }
        stack.push(curr);
    }

    private void addStackElementsToResult() throws TextParseException {
        while (!stack.isEmpty()) {
            if (isOperator(stack.peek())) {
                result.add(stack.pop());
            } else {
                LOGGER.error("Incorrect symbol '" + stack.peek() + "'");
                throw new TextParseException("Incorrect symbol '" + stack.peek() + "'");
            }
        }
    }

    private boolean isDelimiter(String token) {
        if (token.length() != 1) {
            return false;
        }
        for (int i = 0; i < DELIMITERS.length(); i++) {
            if (token.charAt(0) == DELIMITERS.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOperator(String token) {
        if (UNARY_MINUS.equals(token)) {
            return true;
        }
        for (int i = 0; i < OPERATORS.length(); i++) {
            if (token.charAt(0) == OPERATORS.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private int priority(String token) {
        switch (token) {
            case OPEN_BRACKET:
                return 1;
            case PLUS:
            case MINUS:
                return 2;
            default:
                return 3;
        }
    }
}
