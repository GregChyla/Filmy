package pl.greg.udacityGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Movie {

    static private String pickedTitle;
    static private int numberOfGuessesLeft;
    static ArrayList<String> movieList = new ArrayList<String>();


    public void readMoviesFromFile(String filename){

       try {

           File file = new File(filename); //read external file
           Scanner fileReader = new Scanner(file);

           while (fileReader.hasNextLine()) {
               movieList.add(fileReader.nextLine()); //put titles into ArrayList
           }
           fileReader.close();
       }
       catch (FileNotFoundException e){
           System.out.println("Exception: "+e);
       }
       catch (IndexOutOfBoundsException e){
           System.out.println("Exception: "+e);
       }

       for (String s : movieList) { //print out all movies
            System.out.println(s);
       }
        System.out.println();
        System.out.println("Total movies: "+movieList.size());

    }










}
