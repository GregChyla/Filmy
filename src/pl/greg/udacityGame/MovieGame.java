package pl.greg.udacityGame;

public class MovieGame {
    public static void main(String[] args) {
        Movie movie = new Movie();
        Guess guess = new Guess();

        movie.readMoviesFromFile("movies.txt");
        movie.pickMovieFromList();

        System.out.println();
        System.out.println("\nStart guessing letters!");
        System.out.println();

        while (Movie.getNumberOfGuessesLeft() > 0){
            guess.guess();
            movie.replaceUnderscores(guess.guessedLetter);
            System.out.println();
            System.out.println("Tries left: "+ Movie.getNumberOfGuessesLeft());
            System.out.println();

            if (Movie.getNumberOfGuessesLeft() == 0){
                System.out.println("I'm sorry, you LOST!");
                break;
            }

            if (Movie.countUnderscores == Movie.countGoodGuesses) {
                System.out.println("YOU WON!");
                break;
            }
        }

    }
}
