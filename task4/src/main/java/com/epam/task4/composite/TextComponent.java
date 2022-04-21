package com.epam.task4.composite;

import java.util.List;

public interface TextComponent {
    boolean add(TextComponent component);

    boolean remove(TextComponent component);

    List<TextComponent> getChildren();

    String getAsString();

    ComponentType getComponentType();
}
