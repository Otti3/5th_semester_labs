import java.util.Stack;

public class StackCalculator {
    private final Stack<Double> valueStack = new Stack<>();

    private boolean isOneTermOperator(String operator) {
        return operator.equals("sqrt");
    }

    private boolean isTwoTermOperator(String operator) {
        return operator.equals("-")||
                operator.equals("+")||
                operator.equals("*")||
                operator.equals("/");
    }


    private void processTwoTermOperator(String operator) throws InvalidExpressionException {
        if (valueStack.size() < 2) {
            throw new InvalidExpressionException();
        }
        double b = valueStack.pop();
        double a = valueStack.pop();

        double result = switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };

        valueStack.push(result);
    }
    private void processOneTermOperator(String operator) throws InvalidExpressionException {
        if (valueStack.size() == 0) {
            throw new InvalidExpressionException();
        }
        double value = valueStack.pop();

        double result = switch (operator) {
            case "sqrt" -> value*value;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };

        valueStack.push(result);
    }


    public double processExpression(String expression) throws InvalidExpressionException {
        if (expression.charAt(0) == '#'){
            return 0;
        }
        if (expression.equals("print")){
            if (valueStack.size() == 0){
                throw new InvalidExpressionException();
            }
            return valueStack.peek();
        }

        if (expression.equals("pop")){
            if (valueStack.size() == 0){
                throw new InvalidExpressionException();
            }
            return valueStack.pop();
        }

        if (isOneTermOperator(expression)){
            processOneTermOperator(expression);
            return valueStack.peek();
        }
        if (isTwoTermOperator(expression)){
            processTwoTermOperator(expression);
            return valueStack.peek();
        }

        double value = Double.parseDouble(expression);
        return valueStack.push(value);
    }
}
