package com.lermontova.calculatorappfocusstart;

public class Calculator {
    InfixToPostfix infixToPostfix;
    PostfixCalculator postfixCalculator;

    public String calculate(String infixExpression) {
        infixToPostfix = new InfixToPostfix(infixExpression);
        if (infixToPostfix.isValid()) {
            try {
                infixToPostfix.transformInfixExpression();
                postfixCalculator = new PostfixCalculator(infixToPostfix.getPostfixArray());
                double result = postfixCalculator.calculate();
                return String.valueOf(result);
            } catch (Exception e) {
                return "Упс, что-то пошло не так. Введите пример ещё раз:";
            }
        } else {
            return "Упс, что-то пошло не так. Введите пример ещё раз:";
        }


    }
}

