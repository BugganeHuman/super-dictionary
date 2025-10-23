package dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main extends Training  {
    public static void main (String[] args) {
        Dictionary myDictionary = new Dictionary();
        myDictionary.creatFileDictionary();
        Training myTraining = new Training();

        Scanner input = new Scanner(System.in);
        System.out.println ("Enter in this input |-readme| for reading to documentation");
        while (true) {
            System.out.print("Press: |0| - to exit, |1| - add word, |2| - show the dictionary, |3| - training mode, |4| - make back up:  ");

            String menuChoice = input.nextLine();

            if (menuChoice.equals("0") ) {
                break;
            }
                else if (menuChoice.equals("-readme")) {
                    System.out.println ("\nHi there, this if program dictionary with training mode\n" +
                            "You can use it as a full-fledged program for learning new words, or simply as a dictionary manager.\n" +
                            "If you're not satisfied with something, you can rewrite the code yourself, because it's open source\n" +
                            "lint to repository https://github.com/BugganeHuman/super-dictionary\n" +
                            "If you already have a dictionary file, you can use it, but make sure it's called words.txt,\n" +
                            "the words are written without spaces, separated by '-', and it's located in the root of the repository.\n" +
                            "You can make it simpler: just copy your words into the created file, separated by '-', without spaces.\n"
                    );
            }

            else if (menuChoice.equals("1") ) {
                while (true) {
                    System.out.print("Enter the learn word, or press: |0| - back: ");
                    String learnWord = input.nextLine();
                    if (learnWord.equals("0")) {break;} // мб ошибка здесь
                    System.out.print("Enter the basic word: ");
                    String basicWord = input.nextLine();
                    myDictionary.addWord(learnWord, basicWord);
                    System.out.printf ("words %s and %s was added in Dictionary\n", learnWord, basicWord);

                }
            }

            else if (menuChoice.equals("2") ) {
                while(true) {

                    System.out.println();
                myDictionary.showDictionary();
                    System.out.println();
                System.out.print("Press: |0| - back, |1| - find word, |2| - delete word, |3| - update word: "); // мб вставить |3| - update the word
                String showMenuChoice = input.nextLine();

                if (showMenuChoice.equals("0") ) {break;}

                else if (showMenuChoice.equals("1")) {
                    while (true) {
                        System.out.print("Enter any word, or press |0| - to back: ");
                        String findWord = input.nextLine();
                        if (findWord.equals("0")) {break;}
                        else {
                            myDictionary.findWord(findWord);
                        }
                    }
                }

            else if (showMenuChoice.equals("2")){
                while (true) {
                System.out.print ("Enter the index of deleted word, or press |-1| - to back: ");
                String choiceOfDelete = input.nextLine();
                if (choiceOfDelete.equals("-1") ) {break;}
                else {
                    int choiceOfDeleteNumber = Integer.parseInt(choiceOfDelete);
                    myDictionary.deleteWord(choiceOfDeleteNumber);
                    System.out.printf ("Word with index %d was deleted\n", choiceOfDeleteNumber);
                }
                }
                }

            else if (showMenuChoice.equals("3")) {
                while (true) {
                    System.out.print("Enter the index of word, or press |-1| - to back : ");
                    String indexString = input.nextLine();

                    if (indexString.equals("-1") ) {break;}
                    else {
                        try {
                        int indexNumber = Integer.parseInt(indexString);
                    myDictionary.updateWord(indexNumber);

                        } catch (Throwable _) {
                            System.out.println("Incorrect index");
                        }
                    }
                }
            }

            else  {
                System.out.println ("Incorrect number");
                }
                }
            }

            else if (menuChoice.equals("3")){
                while (true) {
                    System.out.println("press |0| - to back");
                    System.out.print("press: |1| - to train writing, |2| - to train speaking: ");
                    String choiceInTraining = input.nextLine();
                    if (choiceInTraining.equals("0")) {break;}

                    else if (choiceInTraining.equals("1")) {
                        while (true) {
                        System.out.print("press: |1| - training to order, |2| - training - to random:  ");
                        String choiceInWriting = input.nextLine();
                        if (choiceInWriting.equals("0")) {break;}
                            else if (choiceInWriting.equals("1")) {
                                myTraining.trainingToWriteOrder();
                        } else if (choiceInWriting.equals("2")) {
                                myTraining.trainingToWriteRandom();
                        }
                        else {System.out.println ("Incorrect number");}
                        }
                    }

                    else if (choiceInTraining.equals("2")) {
                        while (true) {
                            System.out.print("press: |1| - training to order, |2| - training - to random:  ");
                            String choiceInTrainingSpeak = input.nextLine();
                            if (choiceInTrainingSpeak.equals("0")) {break;}
                            else if (choiceInTrainingSpeak.equals("1")) {
                                myTraining.trainingToSpeakOrder();
                            }
                            else if (choiceInTrainingSpeak.equals("2")) {
                                myTraining.trainingToSpeakRandom();
                            }
                            else {System.out.println ("Incorrect number");}

                        }
                    }
                    else {System.out.println ("Incorrect number");}
                }
            }

                    else if (menuChoice.equals("4")) {

                    while (true) {
                        System.out.println("Enter the full path for back up, or write |-help| if you can't something : ");
                        String pathToBackUpInput = input.nextLine();
                        if (pathToBackUpInput.equals("-help")) {
                            System.out.println("\nEnter path without \"\" \n" +
                                    "file can't creates without directorie\n" +
                                    "You can enter the name of the directory even if it does not exist,\n" +
                                    "the program will create it automatically\n" +
                                    "Please enter everything in the correct capitalization.\n");
                            continue;
                        }

                        try {
                            Path pathToBackUp = Path.of(pathToBackUpInput);
                            Files.createDirectories(pathToBackUp.getParent());
                            if (!Files.exists(pathToBackUp)) {
                                Files.createFile(pathToBackUp);
                                try {
                                    Files.copy(Path.of("words.txt"), pathToBackUp, StandardCopyOption.REPLACE_EXISTING);
                                    System.out.println("Back up was make");
                                } catch (IOException e) {
                                    System.out.println("Error in copy files");
                                }
                            }
                        } catch (Throwable _) {
                            System.out.println("Error in making back up file");
                        }
                        break;
                    }
            }

            else {
                System.out.println ("Incorrect number");
            }
        }
    }
}
