package pl.greg.udacityGame;

public class MovieGame {
    public static void main(String[] args) {
        Movie movie = new Movie();
        Guess guess = new Guess();

        movie.readMoviesFromFile("movies.txt");
        movie.pickMovieFromList();



        System.out.println("\nStart guessing letters!");
        System.out.println();

        for (int i = 0; i < 10; i++) {
            guess.guess();
            System.out.println("Test guessletter "+guess.guessedLetter);
            movie.replaceUnderscores(guess.guessedLetter);
        }

    }
}
