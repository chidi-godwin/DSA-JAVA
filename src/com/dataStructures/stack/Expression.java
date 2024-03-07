package com.dataStructures.stack;

import java.util.HashMap;

public class Expression {
    private String expression;
    private final HashMap<Character, Character> brackets;

    public Expression(String expression) {
        this.expression = expression;

        brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        brackets.put('>', '<');
    }

    public boolean isBalanced() {
        var stack = new Stack<Character>();

        for (var letter : expression.toCharArray()) {
            if (brackets.containsValue(letter))
                stack.push(letter);
            else if (brackets.containsKey(letter)) {
                if (!(brackets.get(letter) == stack.pop()))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
