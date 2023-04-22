package com.example.testafinarejava2;

import java.util.ArrayList;

public class Actors extends People{
    private ArrayList<String> movies;

    public ArrayList<String> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<String> movies) {
        this.movies = movies;
    }
}
