package com.epam.task4.interpreter;

import java.util.ArrayDeque;

public class ExpressionContext {
    private final ArrayDeque<Double> contextValue = new ArrayDeque<>();

    public Double pop() {
        return contextValue.pop();
    }

    public void push(Double number) {
        contextValue.push(number);
    }
}
