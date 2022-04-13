package com.epam.task4.interpreter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PolishNotationParser {
    private static final Logger LOGGER = LogManager.getLogger();

    public List<MathExpression> parse(List<String> polishNotation) {
        List<MathExpression> expression = new ArrayList<>();
        polishNotation.forEach(token -> {
                    switch (token) {
                        case MathOperation.PLUS:
                            expression.add(c -> c.push(c.pop() + c.pop()));
                            break;
                        case MathOperation.MINUS:
                            expression.add(c -> c.push(-c.pop() + c.pop()));
                            break;
                        case MathOperation.MULTIPLY:
                            expression.add(c -> c.push(c.pop() * c.pop()));
                            break;
                        case MathOperation.DIVIDE:
                            expression.add(c -> c.push(1 / c.pop() * c.pop()));
                            break;
                        case MathOperation.UNARY_MINUS:
                            expression.add(c -> c.push(-c.pop()));
                            break;
                        default:
                            expression.add(c -> c.push(Double.parseDouble(token)));
                    }
                }
        );
        LOGGER.info("Expression parsed successfully. Polish notation: '"+polishNotation+"', result="+expression);
        return expression;
    }
}
