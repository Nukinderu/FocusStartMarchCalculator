package com.lermontova.calculatorappfocusstart;

import java.util.ArrayList;

public class PostfixCalculator {
    public StackForDoubles stackPostfixCalculator;
    private ArrayList inputPostfix;

    public PostfixCalculator(ArrayList inputPostfix) {
        this.inputPostfix = inputPostfix;
        stackPostfixCalculator = new StackForDoubles();
    }

    public double calculate() {
        double last = 0;
        double previous = 0;
        double result = 0;

        for (int i = 0; i < inputPostfix.size(); i++) {
            char symbol = inputPostfix.get(i).toString().charAt(0);
            switch (symbol) {
                case '+':
                    last = (double) stackPostfixCalculator.removeFromTopOfStack();
                    previous = stackPostfixCalculator.isEmpty() ? result : (double) stackPostfixCalculator.removeFromTopOfStack();
                    result = previous + last;
                    stackPostfixCalculator.placeOnTopOfStack(result);
                    break;
                case '-':
                    last = (double) stackPostfixCalculator.removeFromTopOfStack();
                    previous = stackPostfixCalculator.isEmpty() ? result : (double) stackPostfixCalculator.removeFromTopOfStack();
                    result = previous - last;
                    stackPostfixCalculator.placeOnTopOfStack(result);
                    break;
                case '*':
                    last = (double) stackPostfixCalculator.removeFromTopOfStack();
                    previous = stackPostfixCalculator.isEmpty() ? result : (double) stackPostfixCalculator.removeFromTopOfStack();
                    result = previous * last;
                    stackPostfixCalculator.placeOnTopOfStack(result);
                    break;
                case '/':
                    last = (double) stackPostfixCalculator.removeFromTopOfStack();
                    previous = stackPostfixCalculator.isEmpty() ? result : (double) stackPostfixCalculator.removeFromTopOfStack();
                    result = previous / last;
                    stackPostfixCalculator.placeOnTopOfStack(result);
                    break;
                default:
                    stackPostfixCalculator.placeOnTopOfStack((Double) inputPostfix.get(i));
            }

        }
        return result;
    }

}