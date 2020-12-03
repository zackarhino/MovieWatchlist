package DAO;

import Movie.Movie;

import java.util.ArrayList;

public interface MovieDAO {
    public ArrayList<Movie> getAllMovies();
    public Movie getMovie(int id);
}
