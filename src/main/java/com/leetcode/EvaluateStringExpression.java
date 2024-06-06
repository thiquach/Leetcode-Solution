package main.java.com.leetcode;

import java.util.Stack;

public class EvaluateStringExpression {
    public static void main (String[] args) {
        String s = "5 * 4 - 3 - 5 ^ 3";
        Stack<String> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();

        String[] subStrings = s.split(" ");
        for (int i=0; i<subStrings.length; i++) {
            if (!(subStrings[i].equals("-") || subStrings[i].equals("*") ||
                    subStrings[i].equals("^"))) {
                operands.push(Integer.parseInt(subStrings[i]));
            } else {
                String currentOperator = subStrings[i];
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(currentOperator)) {
                    evaluateTop(operators, operands);
                }
                operators.push(currentOperator);
            }
        }

        while (!operators.isEmpty()) {
            evaluateTop(operators,operands);
        }

        System.out.println("Result: " + operands.pop());
    }

    private static void evaluateTop(Stack<String> operators, Stack<Integer> operands) {
        String op = operators.pop();
        int b = operands.pop();
        int a = operands.pop();

        switch (op) {
            case "^":
                operands.push((int) Math.pow(a,b));
                break;
            case "*":
                operands.push((int) (a * b));
                break;
            case "/":
                operands.push((int) (a / b));
                break;
            case "-":
                operands.push((int) (a - b));
                break;
            case "+":
                operands.push((int) (a + b));
                break;
        }
    }

    private static int precedence (String op) {
        switch (op) {
            case "^": return 3;
            case "*": return 2;
            case "/": return 2;
            case "+": return 1;
            case "-": return 1;
            default: return 0;
        }
    }
}