package pl.greg.udacityGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Guess {

    static private ArrayList<Character> alreadyGuessedLetters = new ArrayList<>();
    static private int numberOfGuessesLeft = 10;
    String guessedLetter;

    public String guess(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input letter!"); //input letter from keyboard
        guessedLetter = scanner.next();

        isGuessedAlready(guessedLetter); //TODO  jeśłi będzie true to nie wypisywać drugi raz tej samej liter

        alreadyGuessedLetters.add(guessedLetter.charAt(0)); //adding just entered letter to all already given letters list
        System.out.print("Letters given so far: "); // print out what you already entered
        for (int i = 0; i < alreadyGuessedLetters.size(); i++){
            System.out.print(alreadyGuessedLetters.get(i));
        }
        System.out.println();

        return guessedLetter; //typ String

        // TODO check if guessed letters exists in pickedTitle
        // TODO count guessed numbers, decrease left guesses count if wrong letter
    }

    public boolean isGuessedAlready(String guessedLetter){
        boolean result = false;
        for (Character alreadyGuessedLetter : alreadyGuessedLetters) {
            if (alreadyGuessedLetter.equals(guessedLetter.charAt(0))) {
                System.out.println("You already guessed letter: " + guessedLetter); //TODO end game if no underscores
                result = true;
                break;
            }
        }
        return result;
    }


}
