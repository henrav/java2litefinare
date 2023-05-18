package com.example.testafinarejava2.Driver;

import com.example.testafinarejava2.Entities.Bok;
import com.example.testafinarejava2.Entities.User;
import javafx.scene.control.Alert;

import java.sql.*;

import static java.lang.Integer.parseInt;

public class DBconnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sys";
    private static final String USER = "root";
    private static final String PASSWORD = "Drakis001116";
    private static Connection connection;

    public static void connect() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public static void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }

    public static int executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }

    public static void updateItemID(int itemID, int itemID2) throws SQLException {
        connect();
        String query = "UPDATE Item SET Item_ID = '" + itemID + "' WHERE Item_ID = " + itemID2;
        executeUpdate(query);
        close();
    }

    public static void updateItemTitle(String title, int itemID) throws SQLException {
        connect();
        String query = "UPDATE Item SET Title = '" + title + "' WHERE Item_ID = " + itemID;
        executeUpdate(query);
        close();

    }

    public static void updateItemISBN(String isbn, int itemID) throws SQLException {
        connect();
        String query = "UPDATE Item SET ISBN = '" + isbn + "' WHERE Item_ID = " + itemID;
        executeUpdate(query);
        close();
    }

    public static void updateBarcode(String barcode, int itemID) throws SQLException {
        connect();
        String query = "UPDATE Item SET Barcode = '" + barcode + "' WHERE Item_ID = " + itemID;
        executeUpdate(query);
        close();
    }

    public static void updateLocation(String location, int itemID) throws SQLException {
        connect();
        String query = "UPDATE Item SET Location = '" + location + "' WHERE Item_ID = " + itemID;
        executeUpdate(query);
        close();
    }

    public static void updateDescription(String description, int itemID) throws SQLException {
        connect();
        String query = "UPDATE Item SET Description = '" + description + "' WHERE Item_ID = " + itemID;
        executeUpdate(query);
        close();
    }

    public static void updateItemType(String itemType, int itemID) throws SQLException {
        connect();
        String query = "UPDATE Item SET Item_Type = '" + itemType + "' WHERE Item_ID = " + itemID;
        executeUpdate(query);
        close();
    }

    public static void updateRentTimeWeeks(String rentTimeWeeks, int itemID) throws SQLException {
        connect();
        String query = "UPDATE Item SET Rent_Time_Weeks = '" + rentTimeWeeks + "' WHERE Item_ID = " + itemID;
        executeUpdate(query);
        close();
    }

    public static void updateItemStatus(String itemStatus, int itemID) throws SQLException {
        connect();
        String query = "UPDATE Item SET Item_Status = '" + itemStatus + "' WHERE Item_ID = " + itemID;
        executeUpdate(query);
        close();
    }

    public static void addNewBok(Bok bok) throws SQLException {

            connect();
            String query = "INSERT INTO Item (Title, ISBN, Barcode, Location, Description, Item_Type, Rent_Time_Weeks, Item_Status) VALUES (?,?,?,?,?,?,?,?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, bok.getNamn());
            preparedStatement.setString(2, bok.getISBN());
            preparedStatement.setString(3, bok.getBarcode());
            preparedStatement.setString(4, bok.getLocation());
            preparedStatement.setString(5, bok.getDescription());
            preparedStatement.setString(6, bok.getItemtype());
            preparedStatement.setString(7, bok.getRenttime());
            preparedStatement.setString(8, bok.getItemstatus());
            preparedStatement.executeUpdate();

            String querytvå = "INSERT INTO Item_Author VALUES ((SELECT MAX(Item_ID) FROM Item), (SELECT Author_ID FROM Author WHERE First_Name = ? AND Last_Name = ?));";
            PreparedStatement preparedStatementtvå = connection.prepareStatement(querytvå);
            preparedStatementtvå.setString(1, bok.getAuthor().getFirstName());
            preparedStatementtvå.setString(2, bok.getAuthor().getLastName());
            preparedStatementtvå.executeUpdate();

            close();

    }
    public static void lånaBok(Bok bok, Integer User_ID) throws SQLException {
        connect();
        String sql = "INSERT INTO Checkout (Patron_ID, Staff_ID) VALUES (?, 4)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, User_ID);
        preparedStatement.executeUpdate();
        String sql2 = "INSERT INTO Item_Checkout (Checkout_ID, Item_ID) VALUES (LAST_INSERT_ID(), ?)";
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        preparedStatement2.setInt(1, parseInt(bok.getItemID()));
        preparedStatement2.executeUpdate();
        close();
    }


    public static void addUserToDatabase(){

    }

    public static PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }
}

