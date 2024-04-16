package functions;

import java.util.Stack;
import java.util.function.DoubleUnaryOperator;

public class ExpressionParser {
    private static class Expression {
        enum TokenType {
            NUMBER, ADD, SUBTRACT, MULTIPLY, DIVIDE, EXPONENT, LEFT_PAREN, RIGHT_PAREN
        }

        TokenType type;
        double value;
        String text;

        Expression(TokenType type, double value, String text) {
            this.type = type;
            this.value = value;
            this.text = text;
        }

        Expression(TokenType type, String text) {
            this.type = type;
            this.text = text;
        }
    }

    private static double parse(String input) {
        Stack<Expression> stack = new Stack<>();

        for (String token : input.split("\\s+")) {
            if (token.isEmpty()) {
                continue;
            }

            try {
                double number = Double.parseDouble(token);
                stack.push(new Expression(Expression.TokenType.NUMBER, number, token));
            } catch (NumberFormatException e) {
                Expression right = stack.pop();
                Expression left = stack.pop();

                switch (token.charAt(0)) {
                    case '+':
                        stack.push(new Expression(Expression.TokenType.NUMBER, left.value + right.value, left.text + " + " + right.text));
                        break;
                    case '-':
                        stack.push(new Expression(Expression.TokenType.NUMBER, left.value - right.value, left.text + " - " + right.text));
                        break;
                    case '*':
                        stack.push(new Expression(Expression.TokenType.NUMBER, left.value * right.value, left.text + " * " + right.text));
                        break;
                    case '/':
                        stack.push(new Expression(Expression.TokenType.NUMBER, left.value / right.value, left.text + " / " + right.text));
                        break;
                    case '^':
                        stack.push(new Expression(Expression.TokenType.NUMBER, Math.pow(left.value, right.value), left.text + " ^ " + right.text));
                        break;
                    default:
                        throw new RuntimeException("Invalid token: " + token);
                }
            }
        }

        if (stack.size() != 1) {
            throw new RuntimeException("Invalid expression");
        }

        Expression expression = stack.pop();
        if (expression.type != Expression.TokenType.NUMBER) {
            throw new RuntimeException("Invalid expression");
        }

        return expression.value;
    }

    public static DoubleUnaryOperator parseFunction(String input) {
        return x -> parse(input.replace("x", String.valueOf(x)));
    }
}