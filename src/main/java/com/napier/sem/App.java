package com.napier.sem;

import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Database_Connection.query("SELECT * FROM city LIMIT 5");
    }
}