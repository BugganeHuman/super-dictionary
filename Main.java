package dictionary;

import java.util.Scanner;

public class Main extends Training  {
    public static void main (String[] args) {
        Dictionary myDictionary = new Dictionary();
        myDictionary.creatFileDictionary();
        Training myTraining = new Training();

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Press: |0| - to exit, |1| - add word, |2| - show the dictionary, |3| - training mode:  ");



            String menuChoice = input.nextLine();


            // надо попробавать  сделать все выборы строками и проверять их как строки, а там где надо int
            // просто засунуть в try catch



            if (menuChoice.equals("0") ) {
                break;
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
                myDictionary.showDictionary(); // возможно надо убрать из while(true)
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
                        int indexNumber = Integer.parseInt(indexString);
                    myDictionary.updateWord(indexNumber);
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
                    myTraining.createTraining();
                }
            }

            else {
                System.out.println ("Incorrect number");
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
