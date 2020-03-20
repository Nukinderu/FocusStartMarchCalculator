package com.lermontova.calculatorappfocusstart;

import java.util.ArrayList;

public class InfixToPostfix {
    private StackForChars stackInfixToPostfix;
    private String inputInfix;
    private ArrayList outputPostfixArray;

    public InfixToPostfix(String infix) {
        inputInfix = infix;
        stackInfixToPostfix = new StackForChars();
        outputPostfixArray = new ArrayList();
    }

    public boolean isValid() {
        if (inputInfix.matches(".*[^-+*/().,0-9].*")) {
            return false;
        } else {
            return true;
        }
    }

    public void transformInfixExpression() {
        double temp = 0;
        double counter = 0;
        boolean comma = false;
        for (int i = 0; i < inputInfix.length(); i++) {
            char inputCharacter = inputInfix.charAt(i);
            switch (inputCharacter) {
                case '+':
                case '-':
                    if (temp != 0) {
                        outputPostfixArray.add(temp);
                    }
                    comma = false;
                    temp = 0;
                    getOperator(inputCharacter, 1);
                    break;
                case '/':
                case '*':
                    if (temp != 0) {
                        outputPostfixArray.add(temp);
                    }
                    comma = false;
                    temp = 0;
                    getOperator(inputCharacter, 2);
                    break;
                case '(':
                    if (temp != 0) {
                        outputPostfixArray.add(temp);
                    }
                    comma = false;
                    temp = 0;
                    stackInfixToPostfix.placeOnTopOfStack(inputCharacter);
                    break;
                case ',':
                case '.':
                    comma = true;
                    counter = 0.1;
                    break;
                case ')':
                    if (temp != 0) {
                        outputPostfixArray.add(temp);
                    }
                    comma = false;
                    temp = 0;
                    getClosingBracket(inputCharacter);
                    break;
                default:
                    if (comma) {
                        temp = temp + Double.parseDouble(String.valueOf(inputCharacter)) * counter;
                        counter = counter * 0.1;
                    } else {
                        temp = temp * 10 + Double.parseDouble(String.valueOf(inputCharacter));
                    }
            }
        }
        outputPostfixArray.add(temp);
        while (!stackInfixToPostfix.isEmpty()) {
            outputPostfixArray.add(stackInfixToPostfix.removeFromTopOfStack());
        }
    }

    public void getOperator(char inputCharacter, int precondition1) {
        int precondition2;
        while (!stackInfixToPostfix.isEmpty()) {
            char operatorOnTop = stackInfixToPostfix.removeFromTopOfStack();
            if (operatorOnTop == '(') {
                stackInfixToPostfix.placeOnTopOfStack(operatorOnTop);
                break;
            } else {
                if (operatorOnTop == '+' || operatorOnTop == '-') {
                    precondition2 = 1;
                } else {
                    precondition2 = 2;
                }
                if (precondition1 > precondition2) {
                    stackInfixToPostfix.placeOnTopOfStack(operatorOnTop);
                    break;
                } else {
                    outputPostfixArray.add(operatorOnTop);
                }
            }
        }
        stackInfixToPostfix.placeOnTopOfStack(inputCharacter);
    }

    public void getClosingBracket(char inputCharacter) {
        while (!stackInfixToPostfix.isEmpty()) {
            char symbol = stackInfixToPostfix.removeFromTopOfStack();
            if (symbol == '(') {
                break;
            } else {
                outputPostfixArray.add(symbol);
            }
        }
    }

    public ArrayList getPostfixArray() {
        return outputPostfixArray;
    }
}