package com.epam.task4.composite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Symbol implements TextComponent {
    private static final Logger LOGGER = LogManager.getLogger();
    private final SymbolType symbolType;
    private final char value;

    public Symbol(SymbolType type, char value) {
        this.symbolType = type;
        this.value = value;
    }

    @Override
    public boolean add(TextComponent component) {
        LOGGER.error("Add operation is not supported for Symbol");
        throw new UnsupportedOperationException("Add operation is not supported for Symbol");
    }

    @Override
    public boolean remove(TextComponent component) {
        LOGGER.error("Remove operation is not supported for Symbol");
        throw new UnsupportedOperationException("Remove operation is not supported for Symbol");
    }

    @Override
    public List<TextComponent> getChildren() {
        LOGGER.error("GetComponents operation is not supported for Symbol");
        throw new UnsupportedOperationException("GetComponents operation is not supported for Symbol");
    }

    public char getValue(){
        return value;
    }

    @Override
    public String getAsString() {
        return String.valueOf(value);
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.SYMBOL;
    }

    public SymbolType getSymbolType() {
        return symbolType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Symbol that = (Symbol) o;
        return symbolType == that.symbolType &&
                value == that.value;
    }

    @Override
    public int hashCode() {
        int result = symbolType.hashCode();
        int prime = 31;
        result = result * prime + value;
        return result;
    }

    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        StringBuilder stringBuilder = new StringBuilder(className);
        stringBuilder.append("{symbolType=").append(symbolType).
                append(", value=").append(value).
                append('}');
        return stringBuilder.toString();
    }
}
