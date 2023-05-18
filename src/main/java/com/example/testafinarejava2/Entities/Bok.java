package com.example.testafinarejava2.Entities;



public class Bok extends Item {
    private Author author;
    private String publisher;
    private String description;
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }


    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }



    public Author getAuthor() {
        return this.author;
    }


}
