package com.napier.sem;

import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Database_Connection.query("SELECT * FROM city LIMIT 5"); // Use this boilerplate to run your queries.
//        checkDatabaseColumns();
    }

    public static void checkDatabaseColumns() throws SQLException, ClassNotFoundException {
        System.out.println("Table 1: city");
        Database_Connection.query("SELECT * FROM city LIMIT 2");

        System.out.println("\nTable 2: country");
        Database_Connection.query("SELECT * FROM country LIMIT 2");

        System.out.println("\nTable 3: countrylanguage");
        Database_Connection.query("SELECT * FROM countrylanguage LIMIT 2");
    }
}
