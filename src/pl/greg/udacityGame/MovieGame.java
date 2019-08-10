package pl.greg.udacityGame;

public class MovieGame {
    public static void main(String[] args) {
        Movie movie = new Movie();
        Guess guess = new Guess();

        movie.readMoviesFromFile("movies.txt");
        movie.pickMovieFromList();

        System.out.println("\nStart guessing letters!");
        guess.guess();
        guess.guess();
//        guess.guess();
//        guess.guess();




    }
}
