package com.unbxd.controllers;

import com.unbxd.services.MovieServiceImpl;
import com.unbxd.services.MoviesService;
import com.unbxd.dao.movie.Movie;

import ro.pippo.controller.Controller;
import ro.pippo.controller.DELETE;
import ro.pippo.controller.GET;
import ro.pippo.controller.POST;
import ro.pippo.controller.PUT;
import ro.pippo.controller.Path;
import ro.pippo.controller.Produces;
import ro.pippo.controller.extractor.Body;
import ro.pippo.controller.extractor.Param;
import ro.pippo.core.Response;

@Path("/movies")
public class MoviesController extends Controller {
    private MoviesService moviesService;
    public MoviesController(){
        moviesService = new MovieServiceImpl();
    }

    @GET("/{id: [0-9]+}")
    @Produces(Produces.JSON)
    public Movie getMovie(@Param("id") int id){
        return moviesService.getMovieByID(id);
    }

    @POST
    @Produces(Produces.JSON)
    public Movie insertMovie(@Body Movie movie){
        return moviesService.insertMovie(movie);
    }

    @PUT("/{id: [0-9]+}")
    @Produces(Produces.JSON)
    public Movie updateMovie(@Param("id") int id,@Body Movie movie){
        return moviesService.updateMovieByID(id,movie);
    }

    @DELETE("/{id: [0-9]+}")
    @Produces(Produces.TEXT)
    public void deleteMovie(@Param("id") int id){
       moviesService.deleteMovieByID(id);
       Response.get().send("deleted movie with id " + id);;
    }

}
