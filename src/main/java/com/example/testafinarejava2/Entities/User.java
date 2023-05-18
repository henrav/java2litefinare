package com.example.testafinarejava2.Entities;

import com.example.testafinarejava2.Driver.SessionManager;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private Integer User_ID;
    private String Username;
    private String Password;
    private String Firstname;
    private String Lastname;
    private String Telnummer;
    private String Email;
    private String Gatunr;
    private String Gatunamn;
    private String Stad;
    private String Zipcode;
    private ArrayList<String> lista;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getTelnummer() {
        return Telnummer;
    }

    public void setTelnummer(String telnummer) {
        Telnummer = telnummer;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGatunr() {
        return Gatunr;
    }

    public void setGatunr(String gatunr) {
        Gatunr = gatunr;
    }

    public String getGatunamn() {
        return Gatunamn;
    }

    public void setGatunamn(String gatunamn) {
        Gatunamn = gatunamn;
    }

    public String getStad() {
        return Stad;
    }

    public void setStad(String stad) {
        Stad = stad;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String zipcode) {
        Zipcode = zipcode;
    }

    public void addtoList(String uppgifter) {
        lista.add(uppgifter);
    }

    public ArrayList<String> getList() {
        return lista;
    }

    public void setUser_ID(Integer user_ID) {
        User_ID = user_ID;
    }

    public Integer getUser_ID() {
        return User_ID;
    }





    /*public boolean loggaIn(User användare) {
        boolean rättinlogg = false;
        try {
            String url = "jdbc:mysql://localhost:3306/sys";
            String user = "root";
            String password = "Drakis001116";

            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "SELECT User_Name, Passworden, User_ID FROM User WHERE User_Name = ? AND Passworden = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, användare.getUsername());
            statement.setString(2, användare.getPassword());
            ResultSet resultset = statement.executeQuery();

            if (resultset.next()) {
                användare.setUser_ID(resultset.getInt(3));
                conn.close();
                System.out.print("rätt inlogg");
                rättinlogg = true;
            } else {
                conn.close();
                System.out.print("fel inloggning");
            }


        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());

        }
        return rättinlogg;

    }

     */




}


