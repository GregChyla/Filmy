package pl.greg.udacityGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Movie {

    static private String pickedTitle;
    static private String[] pickedTitleUnderscored = new String[100];
    static ArrayList<String> movieList = new ArrayList<String>();
    static int countUnderscores = 0; //count underscores excluding spaces
    static int countGoodGuesses = 0; //count underscores excluding spaces

    static private int numberOfGuessesLeft = 10;

    static int getNumberOfGuessesLeft() {
        return numberOfGuessesLeft;
    }

    public static void setNumberOfGuessesLeft(int numberOfGuessesLeft) {
        Movie.numberOfGuessesLeft = numberOfGuessesLeft;
    }

    void readMoviesFromFile(String filename) { //read all the movie titles from text file

        try {
            File file = new File(filename); //read external file
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                movieList.add(fileReader.nextLine()); //put titles into ArrayList
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Exception: " + e);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception: " + e);
        }
    }

    void pickMovieFromList(){  // random pick movie title from input list
        Random random = new Random();
        int randomInt = random.nextInt(movieList.size()); //pick random title from movie list
        pickedTitle = movieList.get(randomInt);
        System.out.println("Picked movie: "+pickedTitle);
        System.out.println("You need to guess the movie title: ");
        char x = ' ';
        for (int i = 0; i < pickedTitle.length(); i++){ // fill temp array with underscores
            if (pickedTitle.charAt(i) == ' '){
                x = ' ';
            } else {
                x = '_';
                countUnderscores++;
            }
            pickedTitleUnderscored[i] = String.valueOf(x);
            System.out.print(pickedTitleUnderscored[i]); // print underscores
        }
    }

    void replaceUnderscores(String guessedLetter){ //replace underscore with letter after guessing one
        boolean guessCheck = false; // if there is more than one guessed letter in title print letter just once
        for (int i = 0; i < pickedTitle.length(); i++){ //
            String tempTitleLetter = String.valueOf(pickedTitle.charAt(i));
            if (tempTitleLetter.equals(guessedLetter)){
                guessCheck = true;// if there is more than one guessed letter in title print letter just once
                pickedTitleUnderscored[i] = guessedLetter;

            }
        }
        if(guessCheck) {// if there is more than one guessed letter in title print letter just once
            System.out.println("You guessed right! Letter: "+guessedLetter);
            countGoodGuesses++; //????????????????????? TODO jak sprawdzić gdy się odgadło ale ta litera już była?
        } else {
            System.out.println("Wrong! (movie class)");
            setNumberOfGuessesLeft(numberOfGuessesLeft-1);
        }

        for (int i = 0; i < pickedTitle.length(); i++){ // fill temp array with underscores
            if (pickedTitle.charAt(i) != ' '){
                System.out.print(pickedTitleUnderscored[i]);

            } else System.out.print(' ');
        }
        System.out.println();
    }


}




