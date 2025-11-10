package com.napier.sem;

import java.sql.*;

public class Database_Connection {
//    private static String URL = "jdbc:mysql://dylanfau.me:3307/world";

    private static String URL = "jdbc:mysql://localhost:3306/";
    private static String User = "root";
    private static String Password = "root";

    /**
     * Creates a connection to the database using the above params
     *
     * @return Connection to the database
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
//        System.out.println("Connected to database");
        return DriverManager.getConnection(URL, User, Password);
    }

    /**
     * Function that takes a query, and prints the parsed result
     *
     * @param query
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void query(String query) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();

        if (conn != null && query != null) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Pulls metadata for the table (world)
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Handles printing column names to the terminal
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }

            System.out.println();

            // Loop that pulls data from the table
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }

            rs.close();
            stmt.close();
            conn.close();
        }
    }
}

