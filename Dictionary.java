package dictionary;



import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
    public static List<String> words = new ArrayList<>();

   public void creatFileDictionary() {
        Path pathToFile = Path.of("words.txt");
        try{
            if(!Files.exists(pathToFile)) {
                Files.createFile(pathToFile);
            }
        }catch (IOException e) {
            System.out.println("Error in creat file of dictionary");
        }
        }

        public void addWord(String learnWord, String basicWord) {
                //creatFileDictionary();
                Path pathToFile = Path.of("words.txt");
                try {
                Files.writeString(pathToFile,learnWord + "-" + basicWord + System.lineSeparator() , StandardOpenOption.APPEND);
                words = Files.readAllLines(pathToFile);

                } catch (IOException e) {
                    System.out.println("Error in updates file");
                }

        }

        public void showDictionary() {
            Path pathToFile = Path.of("words.txt");
            try {
            words = Files.readAllLines(pathToFile);

            } catch (IOException e) {
                System.out.println("Error in showDictionary");
            }
            int counter = 0;
            for (String word: words) {
                System.out.println(counter + " " + word);
                counter++;
            }
        }

        public void findWord(String word) { // здесь баг
            Path pathToFile = Path.of("words.txt");
            try {
            words = Files.readAllLines(pathToFile);
            }catch (IOException e) {
                System.out.println ("Error in show the array of words");
            }
            ArrayList <String>  tempArray = new ArrayList<>();
            int counter = 0;
            for (String findWord: words) {
                try {
                String findWordSplitFirst = findWord.split("-") [0];
                String findWordSplitSecond = findWord.split("-")[1];
                tempArray.add(findWordSplitFirst);
                tempArray.add(findWordSplitSecond);

                } catch (Throwable _) {
                    System.out.println("Error in word.split or tempArray.add ");
                }

            try {
                if (tempArray.get(0).equals(word)) {
                    System.out.println(counter + " " + tempArray.get(0) + "-" + tempArray.get(1));
                    break;
                }else if (tempArray.get(1).equals(word)) {
                    System.out.println(counter + " " + tempArray.get(0) + "-" + tempArray.get(1));
                    break;
                }

            }catch (Throwable _) {
                System.out.println("Error in print the tampArray");
            }
            tempArray.clear();
            counter++;

            }
            }

        public void deleteWord(int index) {
            Path pathToFile = Path.of ("words.txt");
            try {
                words = Files.readAllLines(pathToFile);
            } catch (IOException e) {
                System.out.println("Error in Error in update the array of words");
            }
            try {
            Files.write(pathToFile, new byte[0] );

            } catch (IOException e) {
                System.out.println("Error in record the file  ");
            }
            try {
            words.remove(index);

            for (String word: words) {
            Files.writeString(pathToFile, word + System.lineSeparator(), StandardOpenOption.APPEND );

            }
            showDictionary();
            } catch (Throwable _) { // здесь баг
                System.out.println("Error in delete the word");
            }
        }

        public void updateWord(int index) {
                Path pathToFile = Path.of("words.txt");
                try {
                    words = Files.readAllLines(pathToFile);
                } catch (IOException e) {
                    System.out.println("Error in delete-method");

                }
                Scanner input = new Scanner(System.in);

                System.out.print("Enter the learn word: ");
                String learnWord = input.nextLine();
                System.out.print("Enter the basic word: ");
                String basicWord = input.nextLine();

                words.set(index, learnWord + "-" + basicWord );


                try {
                Files.write(pathToFile, new byte[0]);
                } catch (IOException e) {
                    System.out.println("Error in updateWord - method: Files.write... ");
                }
                System.out.printf("word was change on %s-%s\n" ,learnWord, basicWord );
                for (String word: words) {
                    try {
                        Files.writeString(pathToFile, word + System.lineSeparator() , StandardOpenOption.APPEND, StandardOpenOption.CREATE );

                } catch (IOException e) {
                    System.out.println("Error in record the file");
                    }
                }

        }

        }
