package com.epam.task4.composite;

import com.epam.task4.exception.TextParseException;

import java.util.List;

public interface TextComponent {
    boolean add(TextComponent component);
    boolean remove(TextComponent component);
    List<TextComponent> getChildren();

    void setComponents(List<TextComponent> components);

    TextComponent getChild(int index) throws TextParseException;

    void setChild(int index, TextComponent component) throws TextParseException;

    String getAsString();
    ComponentType getComponentType();
}
