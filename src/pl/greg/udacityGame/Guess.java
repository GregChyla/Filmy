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

        System.out.println("You entered: "+guessedLetter);

        alreadyGuessedLetters.add(guessedLetter.charAt(0));
        System.out.println("Already guessed numbers: ");
        for (int i = 0; i < alreadyGuessedLetters.size(); i++){
            System.out.print(alreadyGuessedLetters.get(i));
        }

        return guessedLetter;

    }
}
