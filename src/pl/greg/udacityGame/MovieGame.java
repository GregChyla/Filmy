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
            System.out.println("You have "+ Movie.getNumberOfGuessesLeft()+" tries left");
            System.out.println("CountUnderscores: "+ Movie.countUnderscores +". CountGoodGuesse: "+ Movie.countGoodGuesses +".");
            System.out.println();

            if (Movie.countUnderscores == Movie.countGoodGuesses) {
                System.out.println("YOU WON!");
                break;
            }
        }

    }
}
