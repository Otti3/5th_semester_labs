import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public final class Utilities {
    public static void calculatorInput(String fileName, StackCalculator stackCalculator) throws IOException, InvalidExpressionException {

        Scanner scanner;
        if (fileName == null){
            scanner = new Scanner(System.in);
        }else {
            scanner = new Scanner(new File(fileName));
        }

        while (scanner.hasNextLine())
        {
            String token = scanner.nextLine();
            System.out.println(stackCalculator.processExpression(token));
        }

        scanner.close();
    }
}
