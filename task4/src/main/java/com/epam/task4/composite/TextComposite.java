package com.epam.task4.composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private final ComponentType type;
    private final List<TextComponent> components;

    public TextComposite(ComponentType type) {
        this.type = type;
        components = new ArrayList<>();
    }

    @Override
    public boolean add(TextComponent component) {
        return components.add(component);
    }

    @Override
    public boolean remove(TextComponent component) {
        return components.remove(component);
    }

    @Override
    public List<TextComponent> getChildren() {
        return components;
    }

    @Override
    public String getAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        String prefix = type.getPrefix();
        String postfix = type.getPostfix();
        if (components.size() > 0) {
            for (int i = 0; i < components.size() - 1; i++) {
                stringBuilder.append(prefix).append(components.get(i).getAsString())
                        .append(postfix);
            }
            stringBuilder.append(prefix).append(components.get(components.size() - 1).getAsString());
        }
        return stringBuilder.toString();
    }

    @Override
    public ComponentType getComponentType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        TextComposite that = (TextComposite) o;
        return type == that.type &&
                components.equals(that.components);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        int prime = 31;
        result = result * prime + components.hashCode();
        return result;
    }

    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        StringBuilder stringBuilder = new StringBuilder(className);
        stringBuilder.append("{type=").append(type).
                append(", components=").append(components).
                append('}');
        return stringBuilder.toString();
    }
}
