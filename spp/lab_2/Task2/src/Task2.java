import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws IOException {
        String resultData = "";
        Scanner scanner = new Scanner(System.in);
        String parametersStr = scanner.nextLine();
        String[] parameters = parametersStr.split(" ");

        if (!parameters[0].equals("cat")){
            throw new IllegalArgumentException("Invalid instruction (cat is needed)");
        }

        for (int i = 1; i < parameters.length; i++) {
            if (parameters[i].equals("-")) {
                resultData += scanner.nextLine() + System.lineSeparator();
            } else if (parameters[i].equals(">")) {
                Files.writeString(Path.of(parameters[i + 1]), resultData);
                return;
            } else {
                resultData += Files.readString(Path.of(parameters[i])) + System.lineSeparator();
            }

        }
        System.out.print(resultData);
    }
}