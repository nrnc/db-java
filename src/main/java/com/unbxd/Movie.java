package com.unbxd;

import java.io.Serializable;


public class Movie implements Serializable {



    private String title;

    
    private String description;


    public Movie() {
    }


    public String getTitle() {
        return title;
    }

    public Movie setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Movie setDescription(String description) {
        this.description = description;
        return this;
    }
   

    @Override
    public String toString() {
        return "Movie {" +
                "title='" + title + '\'' +
                ", description=" + description +
                '}';
    }

}
