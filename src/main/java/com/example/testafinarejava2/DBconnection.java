package com.example.testafinarejava2;

import javafx.scene.control.Alert;

import java.sql.*;

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
        try {
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

            String querytvå = "INSERT INTO Item_Author (Item_ID, Author_ID) VALUES ((SELECT MAX(Item_ID) FROM Item WHERE Title = ?), (SELECT Author_ID FROM Author WHERE First_Name = ? + ' ' + Last_Name = ?))";
            PreparedStatement preparedStatementtvå = connection.prepareStatement(querytvå);
            preparedStatementtvå.setString(1, bok.getNamn());
            preparedStatementtvå.setString(2, bok.getAuthor().getFirstName());
            preparedStatementtvå.setString(3, bok.getAuthor().getLastName());
            preparedStatementtvå.executeUpdate();


            close();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error: " + e.getMessage());
            alert.showAndWait();
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }


    }

}
