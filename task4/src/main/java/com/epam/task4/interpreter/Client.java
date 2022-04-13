package com.epam.task4.interpreter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Client {
    private static final Logger LOGGER = LogManager.getLogger();
    private final ExpressionContext context = new ExpressionContext();

    public double handleExpression(List<MathExpression> expression) {
        for (MathExpression terminal : expression) {
            terminal.interpret(context);
        }
        double result = context.pop();
        LOGGER.info("Expression " + expression + " result = " + result);
        return result;
    }
}
