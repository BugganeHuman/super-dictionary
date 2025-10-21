package dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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

    public void trainingToWriteRandom () {
        createTraining();
        while (true) {
        int sizeArray = trainingWords.size();
        Random random = new Random();
        int randomIndexInWrite = random.nextInt (sizeArray);
        String randomString = trainingWords.get(randomIndexInWrite);
        String firstElement = randomString.split("-")[0];
        String secondElement = randomString.split("-")[1];
        Scanner input = new Scanner(System.in);
        System.out.printf ("Write translate for |%s|: \n", secondElement);
        String usersTranslate = input.nextLine();
        if (usersTranslate.equals(firstElement)) {
            System.out.println("Correct");
        }
        else if (usersTranslate.equals("0")) {break;}
        else {
            System.out.printf ("not correct, correct is |%s|\n", firstElement);
        }

    }
        }

    public void trainingToWriteOrder() {
        createTraining();
        int sizeArray = trainingWords.size();
        while (sizeArray > -1) {
            int index = sizeArray - 1;
            String ArrayStringToOrder = trainingWords.get(index);
            String firstElement = ArrayStringToOrder.split("-")[0];
            String secondElement = ArrayStringToOrder.split("-")[1];
            Scanner input = new Scanner(System.in);
            System.out.printf ("Write translate for |%s|: \n", secondElement);
            String usersTranslate = input.nextLine();
            if (usersTranslate.equals(firstElement)) {
                System.out.println("Correct");}
            else if (usersTranslate.equals("0")) {break;}
             else {
                System.out.printf ("not correct, correct is |%s|\n", firstElement);
            }

            sizeArray--;
            if (sizeArray == 0) {
                sizeArray = trainingWords.size();
            }
        }
    }

    public void trainingToSpeakRandom() {
        createTraining();
        while (true) {

        Random random = new Random();
        int randomIndex = random.nextInt(trainingWords.size());
        String randomStringForSpeak = trainingWords.get(randomIndex);
        String firstElement = randomStringForSpeak.split("-")[0];
        String secondElement = randomStringForSpeak.split("-")[1];
        Scanner input = new Scanner(System.in);
        System.out.printf ("Say translate for |%s|\nand press enter: ", secondElement);
        String usersWatchToTranslate = input.nextLine();
        if (usersWatchToTranslate.equals("0")) {break;}
        System.out.printf("\nCorrect translate is |%s|\n\n" , firstElement);

        }
    }

    public void trainingToSpeakOrder() {
        createTraining();
        int sizeArray = trainingWords.size();
        while (sizeArray > -1) {
            int index = sizeArray -1;
            String stringForSpeakToOrder = trainingWords.get(index);
            String firstElement = stringForSpeakToOrder.split("-")[0];
            String secondElement = stringForSpeakToOrder.split ("-")[1];
            Scanner input = new Scanner(System.in);
            System.out.printf ("Say translate for |%s|\nand press enter: ", secondElement);
            String usersWatchToTranslate = input.nextLine();
            if (usersWatchToTranslate.equals("0")) {break;}
            System.out.printf("\nCorrect translate is |%s|\n\n" , firstElement);

            sizeArray--;
            if (sizeArray == 0) {
                sizeArray = trainingWords.size();
            }
        }
    }
}
