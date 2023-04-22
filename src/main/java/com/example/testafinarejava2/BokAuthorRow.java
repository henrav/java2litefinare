package com.example.testafinarejava2;

public class BokAuthorRow {
    private String ItemID;
    private String Namn;
    private String ISBN;
    private String Barcode;
    private String Location;
    private String Description;
    private String Itemtype;
    private String Renttime;
    private String Itemstatus;
    private String authorID;
    private String AuthorFirstName;
    private String AuthorLastName;
    private String DOB;
    private String AuthorDescription;
    private Bok bok;
    private Author author;

    public BokAuthorRow(Bok bok, Author author) {
        this.ItemID = bok.getItemID();
        this.Namn = bok.getNamn();
        this.ISBN = bok.getISBN();
        this.Barcode = bok.getBarcode();
        this.Location = bok.getLocation();
        this.Description = bok.getDescription();
        this.Itemtype = bok.getItemtype();
        this.Renttime = bok.getRenttime();
        this.Itemstatus = bok.getItemstatus();
        this.authorID = author.getAuthorID();
        this.AuthorFirstName = author.getFirstName();
        this.AuthorLastName = author.getLastName();
        this.DOB = author.getDOB();
        this.AuthorDescription = author.getDescription();
        this.bok = bok;
        this.author = author;
    }
    public Bok getBok() {
        return bok;
    }
    public void setBok(Bok bok) {
        this.bok = bok;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }



    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    public String getNamn() {
        return Namn;
    }

    public void setNamn(String namn) {
        Namn = namn;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getItemtype() {
        return Itemtype;
    }

    public void setItemtype(String itemtype) {
        Itemtype = itemtype;
    }

    public String getRenttime() {
        return Renttime;
    }

    public void setRenttime(String renttime) {
        Renttime = renttime;
    }

    public String getItemstatus() {
        return Itemstatus;
    }

    public void setItemstatus(String itemstatus) {
        Itemstatus = itemstatus;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getAuthorFirstName() {
        return AuthorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        AuthorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return AuthorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        AuthorLastName = authorLastName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAuthorDescription() {
        return AuthorDescription;
    }

    public void setAuthorDescription(String authorDescription) {
        AuthorDescription = authorDescription;
    }
}
