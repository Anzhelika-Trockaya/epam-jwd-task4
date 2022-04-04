package com.epam.task4.composite;

public interface TextComponent {
    boolean add(TextComponent component);
    boolean remove(TextComponent component);
    String getAsString();
    ComponentType getComponentType();
}
