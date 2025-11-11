package com.napier.sem;

import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        checkDatabaseColumns();
//        allCountriesInTheWorld(5);
//        allCitiesInTheWorld();
    }


    /**
     * Helper function to give people an idea of how the database columns look
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void checkDatabaseColumns() throws SQLException, ClassNotFoundException {
        System.out.println("Table 1: city");
        Database_Connection.query("SELECT * FROM city LIMIT 2");

        System.out.println("\nTable 2: country");
        Database_Connection.query("SELECT * FROM country LIMIT 2");

        System.out.println("\nTable 3: countrylanguage");
        Database_Connection.query("SELECT * FROM countrylanguage LIMIT 2");
    }

    /**
     * Report to show all countries in the world in descending order
     * Can give param num to show a limited amount
     * @param num
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void allCountriesInTheWorld(int... num) throws SQLException, ClassNotFoundException {
        if (num.length == 0) {
            System.out.println("Retrieving all countries in the world");
            Database_Connection.query(
                    "SELECT Name, Continent, Region, Population, Capital FROM country GROUP BY Code ORDER BY Population DESC"
            );
        } else {
            System.out.println("Retrieving top " + num[0] + " countries in the world");
            Database_Connection.query(
                    "SELECT Name, Continent, Region, Population, Capital FROM country GROUP BY Code ORDER BY Population DESC LIMIT " + num[0]
            );
        }
    }

    /**
     * Report to show all cities in the world, in descending order -> NOT DONE
     * @param num
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void allCitiesInTheWorld(int... num) throws SQLException, ClassNotFoundException {
        if (num.length == 0) {
            Database_Connection.query("SELECT countryCode, District, Population FROM city ORDER BY Population DESC");
        } else {
            System.out.println("Retrieving top " + num[0] + " cities in the world");
            Database_Connection.query("SELECT countryCode, District, Population FROM city ORDER BY Population DESC LIMIT " + num[0]);
        }
    }
}


//    Country Report
//    A country report requires the following columns:
//    Code.
//            Name.
//            Continent.
//            Region.
//            Population.
//            Capital.

//    City Report
//
//    A city report requires the following columns:
//
//    Name.
//            Country.
//            District.
//            Population.
//
//    Capital City Report
//
//    A capital city report requires the following columns:
//
//    Name.
//            Country.
//            Population.