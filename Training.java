package dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
public class Training extends Dictionary {
    List<String> trainingWords = new ArrayList<>();

    public void createTraining() {
        Path pathToFile = Path.of("words.txt");
        trainingWords.clear();
        try {
        trainingWords = Files.readAllLines(pathToFile);

        } catch (IOException e) {
            System.out.println("error in recording words to List trainingWords");
        }
    }
}
