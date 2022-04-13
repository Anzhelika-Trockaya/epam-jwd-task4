package com.epam.task4.util.comparator;

import com.epam.task4.composite.TextComponent;

import java.util.Comparator;
import java.util.List;

public class TextComponentComponentsComparator implements Comparator<TextComponent> {//fixme

    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        List<TextComponent> children1 = o1.getChildren();
        List<TextComponent> children2 = o2.getChildren();
        int size1 = children1.size();
        int size2 = children2.size();
        return Integer.compare(size1, size2);
    }
}
