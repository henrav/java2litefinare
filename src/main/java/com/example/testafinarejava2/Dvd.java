package com.example.testafinarejava2;

import java.util.ArrayList;

public class Dvd extends Item{
    private String runtime;
    private String director;
    private ArrayList<Actors> skådespelare;


    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<Actors> getActors() {
        return skådespelare;
    }
}
