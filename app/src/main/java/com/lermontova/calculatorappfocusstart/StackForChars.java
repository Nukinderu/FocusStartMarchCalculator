package com.lermontova.calculatorappfocusstart;

import java.util.ArrayList;

public class StackForChars {
    private ArrayList<Character> elements;

    public StackForChars() {
        elements = new ArrayList<Character>();
    }

    public void placeOnTopOfStack(char element) {

        elements.add(element);
    }

    public char removeFromTopOfStack() {
        char ch = elements.get(elements.size() - 1);
        elements.remove(elements.size() - 1);
        return ch;
    }

    public boolean isEmpty() {

        return elements.isEmpty();
    }

}
