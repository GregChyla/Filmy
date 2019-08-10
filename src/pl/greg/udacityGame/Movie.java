package pl.greg.udacityGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Movie {

    static private String pickedTitle;
    static private String[] pickedTitleUnderscored = new String[100];
    static ArrayList<String> movieList = new ArrayList<String>();


    public void readMoviesFromFile(String filename) { //read all the movie titles from text file

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
/*
       for (String s : movieList) { //print out all movies
            System.out.println(s);
       }
        System.out.println();
        System.out.println("Total movies: "+movieList.size());

*/
    }

    public String pickMovieFromList(){  // random pick movie title from input list
        Random random = new Random();
        int randomInt = random.nextInt(movieList.size()); //pick random title from movie list
//            System.out.println("Random int: "+randomInt);
        pickedTitle = movieList.get(randomInt);
        System.out.println("Picked movie: "+pickedTitle);
        System.out.println("Movie title to guess: ");
        char x = ' ';
        for (int i = 0; i < pickedTitle.length(); i++){ // fill temp array with underscores
            if (pickedTitle.charAt(i) == ' '){
                x = ' ';
            } else x = '_';
            pickedTitleUnderscored[i] = String.valueOf(x);
            System.out.print(pickedTitleUnderscored[i]); // print underscores
        }
        return pickedTitle;


    }

    public String replaceUnderscores(String guessedLetter){ //replace underscore with letter after guessing one

        for (int i = 0; i < pickedTitle.length(); i++){ //
            String tempTitleLetter = String.valueOf(pickedTitle.charAt(i));
            if (tempTitleLetter.equals(guessedLetter)){
                System.out.println("You guessed right! Letter: "+guessedLetter);
                pickedTitleUnderscored[i] = guessedLetter;
            }

        }
        for (int i = 0; i < pickedTitle.length(); i++){ // fill temp array with underscores
            if (pickedTitle.charAt(i) != ' '){
                System.out.print(pickedTitleUnderscored[i]);

            } else System.out.print(' ');

        }
        System.out.println();
        return pickedTitle;


    }


}




