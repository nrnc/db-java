package com.unbxd.services;

import com.unbxd.dao.movie.Movie;
import com.unbxd.dao.movie.MovieDao;
import com.unbxd.dao.movie.MovieDaoImpl;

public class MovieServiceImpl implements MoviesService {
    private MovieDao movieDao;

    public MovieServiceImpl(){
        movieDao = new MovieDaoImpl();
    }
    public Movie getMovieByID(int id){
        return movieDao.getMovie(id);
    }
    public Movie updateMovieByID(int id, Movie movie){
        return movieDao.updateMovie(id, movie);
    }
    public Movie insertMovie(Movie movie){
        return movieDao.insertMovie(movie);
    }
    public void deleteMovieByID(int id){
        movieDao.deleteMovie(id);
    }
}
