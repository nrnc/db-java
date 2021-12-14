package com.unbxd.dao.movie;

public class Movie {
    private String title;

    
    private String description;


    public Movie(String title,String description) {
        this.title = title;
        this.description = description;
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
 
}
