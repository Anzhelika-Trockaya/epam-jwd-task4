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
    public String getAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        String delimiter = Delimiter.EMPTY.getValue();
        switch (type) {
            case TEXT:
                delimiter = Delimiter.NEWLINE.getValue();
                break;
            case PARAGRAPH:
                stringBuilder.append(Delimiter.TABULATION.getValue());
            case SENTENCE:
                delimiter = Delimiter.SPACE.getValue();
                break;
        }
        if (components.size() > 0) {
            //fixme
           /* if(type==ComponentType.LEXEME) {
                for(TextComponent component:components) {
                    System.out.println(component.getAsString() +" "+component.getComponentType()+ "\n");
                }
            }*/
            //fixme

            for (int i = 0; i < components.size() - 1; i++) {
                stringBuilder.append(components.get(i).getAsString())
                        .append(delimiter);
            }
            stringBuilder.append(components.get(components.size() - 1).getAsString());
        }
        return stringBuilder.toString();
    }

    @Override
    public ComponentType getComponentType() {
        return type;
    }
}
