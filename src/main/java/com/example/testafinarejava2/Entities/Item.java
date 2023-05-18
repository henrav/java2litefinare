package com.example.testafinarejava2.Entities;

import javafx.beans.property.StringProperty;

abstract class Item {
    private String namn;
    private String ISBN;
    private String Barcode;
    private String Location;

    private String Itemtype;
    private String Renttime;
    private String Itemstatus;
    private String ItemID;
    private StringProperty action;
    public void setAction(StringProperty action) {
        this.action = action;
    }
    public String getAction() {
        return action.get();
    }


    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }




    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
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
}
