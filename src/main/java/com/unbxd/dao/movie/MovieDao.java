package com.unbxd.dao.movie;

public interface MovieDao {
    public Movie insertMovie(Movie movie);
    public Movie getMovie(int id);
    public Movie updateMovie(int id, Movie movie);
    public void deleteMovie(int id);
}
