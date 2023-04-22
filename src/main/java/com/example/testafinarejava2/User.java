package com.example.testafinarejava2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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


    public void addUserToDatabase(User användare) {
        try {
            String url = "jdbc:mysql://localhost:3306/sys";
            String user = "root";
            String password = "Drakis001116";

            Connection conn = DriverManager.getConnection(url, user, password);
            String hej = "en ny person kom in";
            String hejsan = "nånting gick fel";


            String sql = "CALL Add_User(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, användare.getUsername());
            statement.setString(2, användare.getPassword());
            statement.setString(3, användare.getFirstname());
            statement.setString(4, användare.getLastname());
            statement.setString(5, användare.getTelnummer());
            statement.setString(6, användare.getEmail());
            statement.setString(7, användare.getGatunr());
            statement.setString(8, användare.getGatunamn());
            statement.setString(9, användare.getStad());
            statement.setString(10, användare.getZipcode());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("en ny person kom in, hens uppgifter är:");
            }


            conn.close();
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }

    }

    public void removeUser(User användare) {
        try {
            String url = "jdbc:mysql://localhost:3306/sys";
            String user = "root";
            String password = "Drakis001116";
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "DELETE FROM User WHERE User_name = ? AND Password = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, användare.getUsername());
            statement.setString(2, användare.getPassword());
            statement.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }

    }

    public void nyUser(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("skriv ditt användarnamn");
        user.setUsername(scanner.nextLine());
        System.out.print("skriv ditt lösenord");
        user.setPassword(scanner.nextLine());
        System.out.print("skriv förnamn");
        user.setFirstname(scanner.nextLine());
        System.out.print("skriv ditt efternamn");
        user.setLastname(scanner.nextLine());
        System.out.print("skriv ditt telefonnummer");
        user.setTelnummer(scanner.nextLine());
        System.out.print("skriv din email");
        user.setEmail(scanner.nextLine());
        System.out.print("skriv ditt gatunummer");
        user.setGatunr(scanner.nextLine());
        System.out.print("skriv din gatu namn");
        user.setGatunamn(scanner.nextLine());
        System.out.print("skriv din stad");
        user.setStad(scanner.nextLine());
        System.out.print("skriv din zipcode");
        user.setZipcode(scanner.nextLine());
        user.addUserToDatabase(user);
    }

    public ArrayList användarensUppgifter(User user) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add(user.getUsername());
        lista.add(user.getPassword());
        lista.add(user.getFirstname());
        lista.add(user.getLastname());
        lista.add(user.getTelnummer());
        lista.add(user.getEmail());
        lista.add(user.getGatunr());
        lista.add(user.getGatunamn());
        lista.add(user.getStad());
        lista.add(user.getZipcode());
        return lista;


    }

    public boolean loggaIn(User användare) {
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

    public void sökNågot() {
        try {
            String url = "jdbc:mysql://localhost:3306/sys";
            String user = "root";
            String password = "Drakis001116";
            Connection conn = DriverManager.getConnection(url, user, password);


            conn.close();
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }

    public void userGetAntalLån() {
        try {
            SessionManager sessionManager = new SessionManager();
            String url = "jdbc:mysql://localhost:3306/sys";
            String user = "root";
            String password = "Drakis001116";
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT Item_Rented FROM sys.Patron WHERE User_ID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, sessionManager.getUser_ID().transform(Integer::parseInt));
            ResultSet resultset = statement.executeQuery();
            if (resultset.next()) {
                System.out.println(resultset.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}


