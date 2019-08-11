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

    static int getNumberOfGuessesLeft() {return numberOfGuessesLeft;
    }
    public static void setNumberOfGuessesLeft(int numberOfGuessesLeft) {
        Movie.numberOfGuessesLeft = numberOfGuessesLeft;
    }
    /*
    metoda wczytująca plik tekstowy
    */
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

    /*
    metoda wybierająca losowo tytuł z listy filmów
    */

    void pickMovieFromList(){
        Random random = new Random();
        int randomInt = random.nextInt(movieList.size()); //losujemy losową liczbę z zakresu długości listy
        pickedTitle = movieList.get(randomInt); // przyporządkowujemy do zmiennej typu String tytuł odpowiadający wylosowanej liczbie
        //System.out.println("Picked movie: "+pickedTitle); //test - wypisanie całego wybranego tytułu
        System.out.println("You need to guess the movie title!");


    /*
    tworzymy tymczasową tablicę stringów, gdzie każda litera z wybranego tytułu ma odpowiednik w postaci _
    spacja odpowiada spacji
    */

        char x = ' ';
        for (int i = 0; i < pickedTitle.length(); i++){
            if (pickedTitle.charAt(i) == ' '){
                x = ' ';
            } else {
                x = '_';
            }
            pickedTitleUnderscored[i] = String.valueOf(x);  // przepisujemy wartość z X'a do tabeli - spacja dla spacji, _ dla liter
            System.out.print(pickedTitleUnderscored[i]); // wypisujemy tytuł z podkreślnikami
        }
    }

    /*
    metoda wstawiająca odgadniętą literę w miejsce podkreślnika przy poprawnym odgadnięciu
    zmienna guesseLetter pochodzi z metody guess(), typ String
    guessCheck - zmienna sprawdzająca, czy dana litera występuje więcej niż raz w tytule, jeśli tak, to odgadnięta litera ma zostać wypisana tylko raz
    */

    void replaceUnderscores(String guessedLetter){
        boolean guessCheck = false;
        for (int i = 0; i < pickedTitle.length(); i++){

            String tempTitleLetter = String.valueOf(pickedTitle.charAt(i)); // porównuje po literze tytuł Temp z tytułem wybranym

            if (tempTitleLetter.equals(guessedLetter)){ // jeśli występują takie same litery
                guessCheck = true;// if there is more than one guessed letter in title print letter just once
                pickedTitleUnderscored[i] = guessedLetter;
            }
        }

        if(guessCheck) {// if there is more than one guessed letter in title print letter just once

            System.out.println();
            System.out.println("Good!");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Wrong!");
            System.out.println();
            setNumberOfGuessesLeft(numberOfGuessesLeft-1);
        }
        /*
        zliczanie liter wpisanych zamiast podkreślników
        */

        countUnderscores = 0;
        for (int i = 0; i < pickedTitle.length(); i++){ // fill temp array with underscores
            if (pickedTitle.charAt(i) != ' '){
                System.out.print(pickedTitleUnderscored[i]);
            } else System.out.print(' ');
            if (pickedTitleUnderscored[i].equals("_")){
                countUnderscores++;
            }
        }
    }
}




