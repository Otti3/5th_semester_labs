import java.io.IOException;

public class Task2 {
    public static void main(String[] args) throws IOException, InvalidExpressionException {
        StackCalculator stackCalculator = new StackCalculator();
        if (args.length == 0) {
            Utilities.calculatorInput(null, stackCalculator);
            return;
            }
        Utilities.calculatorInput(args[0], stackCalculator);
        }

    }

