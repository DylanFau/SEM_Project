package com.napier.sem;

import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to a database of the world\n");

        System.out.println("(1) List all countries in the world");
        System.out.println("(2) List all cities in the world");
        System.out.println("(4) Dev -> Check database columns");

        System.out.print("\nPlease choose an option: ");

        int choice = input.nextInt();

        /*
          Switch case to send user choice to where it needs to be
         */
        switch (choice) {
            case 1:
            {
                System.out.print("Max elements returned (0 for all): ");
                int maxRet = input.nextInt();

                if(maxRet == 0) {
                    allCountriesInTheWorld(0);
                } else {
                    allCountriesInTheWorld(maxRet);
                }
                break;
            }
            case 2:
            {
                System.out.print("Max elements returned (0 for all): ");
                int maxRet = input.nextInt();

                if(maxRet == 0) {
                    allCitiesInTheWorld(0);
                } else {
                    allCitiesInTheWorld(maxRet);
                }
                break;
            }
            case 4: {
                checkDatabaseColumns();
                break;
            }
            default:
            {
                System.out.println("Invalid choice, try again..");
                main(args);
            }
        }
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
     * @param num can be used to set a return amount
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void allCountriesInTheWorld(int... num) throws SQLException, ClassNotFoundException {
        if (num[0] == 0) {
            System.out.println("Entered num is " + num);
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
     * Report to show all cities in the world, in descending order
     * @param num can be used to set a return amount
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

//        Database_Connection.query("SELECT Name AS Country, Population
//                                  FROM country
//ORDER BY Population DESC;");
//
//        //Countries by continent
//        Database_Connection.query("SELECT Name AS Country, Continent, Population
//                                  FROM country
//WHERE Continent = 'Asia'
//                                          ORDER BY Population DESC;");
//
//        //Population report for a country
//        Database_Connection.query("SELECT Name AS Country, Population
//                                  FROM country
//WHERE Name = 'Pakistan';");
