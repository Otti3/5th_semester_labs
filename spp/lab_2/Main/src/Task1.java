import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;


public class Task1 {

    public static void main(String[] args) throws IOException {
            task1();
    }


    public static String task1() throws IOException{
            String fileContents = Files.readString(Path.of("task1.txt"));
            String fileContentsWithoutDuplicates = Arrays.stream(fileContents.split("[\s,.!-]+"))
                    .distinct()
                    .collect(Collectors.joining(" "));
            System.out.println(fileContentsWithoutDuplicates);
            return fileContentsWithoutDuplicates;

    }


}
