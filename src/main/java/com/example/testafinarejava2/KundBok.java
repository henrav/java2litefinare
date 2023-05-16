package com.example.testafinarejava2;

import javafx.beans.property.StringProperty;

public class KundBok {
    private String ItemID;
    private String Title;
    private String inlämningsdatum;
    private String datumuthyrd;
    private String kundid;
    private String kundensNamn;

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getInlämningsdatum() {
        return inlämningsdatum;
    }

    public void setInlämningsdatum(String inlämningsdatum) {
        this.inlämningsdatum = inlämningsdatum;
    }

    public String getDatumuthyrd() {
        return datumuthyrd;
    }

    public void setDatumuthyrd(String datumuthyrd) {
        this.datumuthyrd = datumuthyrd;
    }

    public String getKundid() {
        return kundid;
    }

    public void setKundid(String kundid) {
        this.kundid = kundid;
    }

    public String getKundensNamn() {
        return kundensNamn;
    }

    public void setKundensNamn(String kundensNamn) {
        this.kundensNamn = kundensNamn;
    }
}

