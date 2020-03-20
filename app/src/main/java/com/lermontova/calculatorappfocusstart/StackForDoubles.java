package com.lermontova.calculatorappfocusstart;

import java.util.ArrayList;

public class StackForDoubles {
    private ArrayList<Double> elements;

    public StackForDoubles() {
        elements = new ArrayList<Double>();
    }

    public void placeOnTopOfStack(Double element) {
        elements.add(element);
    }

    public Double removeFromTopOfStack() {
        double d = elements.get(elements.size() - 1);
        elements.remove(elements.size() - 1);
        return d;
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
