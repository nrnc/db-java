package com.unbxd.services;

import com.unbxd.dao.movie.Movie;


public interface MoviesService {
    
    public Movie getMovieByID(int id);
    public Movie updateMovieByID(int id,Movie movie);
    public Movie insertMovie(Movie movie);
    public void deleteMovieByID(int id);
}
