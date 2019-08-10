package pl.greg.udacityGame;

import java.util.ArrayList;
import java.util.Scanner;

class Guess {

    static public ArrayList<Character> alreadyGuessedLetters = new ArrayList<>(); //array for storing inputs from keyboard

    String guessedLetter;

    String guess(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input letter!"); //input letter from keyboard
        guessedLetter = scanner.next();

        isGuessedAlready(guessedLetter); //check if this letter was previously given

        alreadyGuessedLetters.add(guessedLetter.charAt(0)); //adding just entered letter to all already given letters list
        System.out.print("Letters given so far: "); // print out what you already entered
        for (int i = 0; i < alreadyGuessedLetters.size(); i++){
            System.out.print(alreadyGuessedLetters.get(i));
        }
        System.out.println();
        return guessedLetter; //typ String
    }

    private boolean isGuessedAlready(String guessedLetter){
        boolean result = false;
        for (Character alreadyGuessedLetter : alreadyGuessedLetters) {
            if (alreadyGuessedLetter.equals(guessedLetter.charAt(0))) {
                System.out.println("You already guessed letter: " + guessedLetter);
                result = true;
                break;
            }
        }

        return result;
    }


}
