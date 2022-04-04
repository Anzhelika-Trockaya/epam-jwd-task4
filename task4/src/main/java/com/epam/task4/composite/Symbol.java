package com.epam.task4.composite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        LOGGER.warn("Add operation is not supported for Symbol");
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(TextComponent component) {
        LOGGER.warn("Remove operation is not supported for Symbol");
        throw new UnsupportedOperationException();
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
}
