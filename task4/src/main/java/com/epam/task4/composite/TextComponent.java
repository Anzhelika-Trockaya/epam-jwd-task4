package com.epam.task4.composite;

import com.epam.task4.exception.TextParseException;

import java.util.List;

public interface TextComponent {
    boolean add(TextComponent component);

    boolean remove(TextComponent component);

    List<TextComponent> getChildren();

    void setComponents(List<TextComponent> components);

    String getAsString();

    ComponentType getComponentType();
}
