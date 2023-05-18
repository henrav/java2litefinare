package com.example.testafinarejava2.Driver;

import com.example.testafinarejava2.Entities.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class SessionManager {
    private static final String SESSION_FILE = "src/main/resources/com/example/testafinarejava2/session.dat";
    private static final int SESSION_TIMEOUT = 3600000; // 10 minutes

    private static String sessionId = null;
    private static String currentUser = null;
    private static String currentPassword = null;
    private static Integer User_ID = null;

    public static boolean isAuthenticated() {
        return sessionId != null && isValidSession(sessionId);
    }


    public static boolean login(User user) throws SQLException {
        if (loggain(user) != null) {
            sessionId = UUID.randomUUID().toString();
            currentUser = user.getUsername();
            currentPassword = user.getPassword();
            User_ID = user.getUser_ID();
            Path sessionFile = Paths.get(SESSION_FILE);

            try {
                Files.write(sessionFile, String.format("%s,%s,%s,%s", sessionId, user.getUser_ID(), user.getUsername(), System.currentTimeMillis() + SESSION_TIMEOUT).getBytes());
                System.out.println("login user function" + " " + user.getUsername());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    public static User loggain(User user) throws SQLException {
        DBconnection.connect();
        String sql = "SELECT User_ID FROM User WHERE User_Name = ? AND Passworden = ?";
        //replace the ? in the sql statement with the username and password
        PreparedStatement statement = DBconnection.prepareStatement(sql);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            user.setUser_ID(rs.getInt(1));
            return user;
        }
        return null;

    }

    public static void logout() {
        // Remove session ID from the file
        Path sessionFile = Paths.get(SESSION_FILE);
        try {
            Files.deleteIfExists(sessionFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Clear session ID variable
        sessionId = null;
    }


    private static boolean isValidSession(String sessionId) {
        Path sessionFile = Paths.get(SESSION_FILE);
        System.out.println("testomvalidsession" + " " + sessionId);

        // Check if session file exists and read its contents
        if (Files.exists(sessionFile)) {
            try {
                String[] parts = Files.readString(sessionFile).split(",");
                String storedSessionId = parts[0];
                String User_ID = parts[1];
                String username = parts[2];
                long expirationTime = Long.parseLong(parts[3]);

                // Check if session ID matches and has not expired
                if (sessionId.equals(storedSessionId) && System.currentTimeMillis() < expirationTime) {
                    // Renew session expiration time
                    Files.write(sessionFile, String.format("%s,%s,%s,%d", sessionId, User_ID, username, System.currentTimeMillis() + SESSION_TIMEOUT).getBytes());
                    System.out.print("isValidSession");
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return false;

    }

    public static SessionManager getInstance() {
        return new SessionManager();
    }


    public static String getUserName() throws FileNotFoundException {
        String username = null;
        if (SessionManager.isAuthenticated()) {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/com/example/testafinarejava2/session.dat"));
            try {
                String line = br.readLine();
                List<String> lista = Arrays.asList(line.split(","));
                username = lista.get(2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return username;
    }

    public static String getUser_ID() throws FileNotFoundException {
        String User_ID = null;
        if (SessionManager.isAuthenticated()) {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/com/example/testafinarejava2/session.dat"));
            try {
                String line = br.readLine();
                List<String> lista = Arrays.asList(line.split(","));
                User_ID = lista.get(1);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return User_ID;
    }

    public Boolean isUserStaff() throws SQLException, FileNotFoundException {
        if (SessionManager.isAuthenticated()) {
            DBconnection.connect();
            String sql = "SELECT Staff_ID FROM Staff WHERE Staff_ID = " + SessionManager.getUser_ID();
            if (DBconnection.executeQuery(sql).next()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public Boolean isUserUser() throws SQLException, FileNotFoundException {
        if (SessionManager.isAuthenticated()) {
            DBconnection.connect();
            String sql = "SELECT Patron_Type_ID FROM Patron WHERE Patron_ID = " + SessionManager.getUser_ID();
            if (DBconnection.executeQuery(sql).next()) {
                return true;
            } else {
                return false;
            }


        }
        return false;
    }
}


