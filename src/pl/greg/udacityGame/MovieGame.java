package pl.greg.udacityGame;

public class MovieGame {
    public static void main(String[] args) {
        Movie movie = new Movie();

        movie.readMoviesFromFile("movies.txt");
    }
}
