package dictionary;

import java.util.Scanner;

public class Main extends Dictionary  {
    public static void main (String[] args) {
        Dictionary myDictionary = new Dictionary();
        myDictionary.creatFileDictionary();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Press: |0| - to exit, |1| - add word, |2| - show the dictionary, |3| - train mode:  ");
            int menuChoice = input.nextInt();
            input.nextLine();
            if (menuChoice == 0) {
                break;
            }


            else if (menuChoice == 1) {
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

            else if (menuChoice == 2) {
                while(true) {

                    System.out.println();
                myDictionary.showDictionary(); // возможно надо убрать из while(true)
                    System.out.println();
                System.out.print("Press: |0| - back, |1| - find word, |2| - delete word, |3| - update word: "); // мб вставить |3| - update the word
                int showMenuChoice = input.nextInt();
                input.nextLine();
                if (showMenuChoice == 0) {break;}

                else if (showMenuChoice == 1) {
                    while (true) {
                        System.out.print("Enter any word, or press |0| - to back: ");
                        String findWord = input.nextLine();
                        if (findWord.equals("0")) {break;}
                        else {
                            myDictionary.findWord(findWord);
                        }
                    }
                }
            else if (showMenuChoice == 2){
                while (true) {
                System.out.print ("Enter the index of deleted word, or press |-1| - to back: ");
                int choiceOfDelete = input.nextInt();
                input.nextLine();
                if (choiceOfDelete == -1) {break;}
                else {
                    myDictionary.deleteWord(choiceOfDelete);
                    System.out.printf ("Word with index %d was deleted", choiceOfDelete);
                }
                }


                }
            else if (showMenuChoice == 3) {
                while (true) {
                myDictionary.updateWord();

                }

                }
                }


            }


        }


    }
}
// как должен выглядеть интерфейс: главное меню: press 1 - add word, 2 - show dictionary, 3 - train mode, 0 - back
// при нажатие на 2 : press 1 - find word, 2 - delete word, mb 3 - update the word, 0 - back
// при нажатие на 1 : basic word: ..., следущая строка: learn word: ..., следущая строка: word was added
// при нажатие на 3: press 1 - train to order, 2 - train to random
//   после этого в зависимости от выбора запускается либо рандомная версия, либо по порядку:
//      press 1 - train writing, 2 - train speaking