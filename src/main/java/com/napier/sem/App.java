package com.napier.sem;

import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        
        System.out.println("WORLD POPULATION REPORTING SYSTEM");
        System.out.println("COUNTRIES (6 reports):");
        System.out.println("(1) All countries in the world by population");
        System.out.println("(2) All countries in a continent");
        System.out.println("(3) All countries in a region");
        System.out.println("(4) Top N countries in the world");
        System.out.println("(5) Top N countries in a continent");
        System.out.println("(6) Top N countries in a region");
        
        System.out.println("\nCITIES (6 reports):");
        System.out.println("(7) All cities in the world by population");
        System.out.println("(8) All cities in a continent");
        System.out.println("(9) All cities in a country");
        System.out.println("(10) Top N cities in the world");
        System.out.println("(11) Top N cities in a continent");
        System.out.println("(12) Top N cities in a country");
        
        System.out.println("\nTOOLS:");
        System.out.println("(13) Check database structure");
        System.out.println("(0) Exit");

        System.out.print("\nPlease choose an option: ");
        int choice = input.nextInt();

        switch (choice) {
            // COUNTRY REPORTS
            case 1:
                System.out.print("Max elements (0 for all): ");
                allCountriesInTheWorld(input.nextInt());
                break;
            case 2:
                System.out.print("Enter continent: ");
                input.nextLine();
                allCountriesInContinent(input.nextLine());
                break;
            case 3:
                System.out.print("Enter region: ");
                input.nextLine();
                allCountriesInRegion(input.nextLine());
                break;
            case 4:
                System.out.print("How many top countries: ");
                topNCountriesWorld(input.nextInt());
                break;
            case 5:
                System.out.print("Enter continent: ");
                input.nextLine();
                String continent5 = input.nextLine();
                System.out.print("How many top countries: ");
                topNCountriesInContinent(continent5, input.nextInt());
                break;
            case 6:
                System.out.print("Enter region: ");
                input.nextLine();
                String region6 = input.nextLine();
                System.out.print("How many top countries: ");
                topNCountriesInRegion(region6, input.nextInt());
                break;
                
            // CITY REPORTS
            case 7:
                System.out.print("Max elements (0 for all): ");
                allCitiesInTheWorld(input.nextInt());
                break;
            case 8:
                System.out.print("Enter continent: ");
                input.nextLine();
                allCitiesInContinent(input.nextLine());
                break;
            case 9:
                System.out.print("Enter country: ");
                input.nextLine();
                allCitiesInCountry(input.nextLine());
                break;
            case 10:
                System.out.print("How many top cities: ");
                topNCitiesWorld(input.nextInt());
                break;
            case 11:
                System.out.print("Enter continent: ");
                input.nextLine();
                String continent11 = input.nextLine();
                System.out.print("How many top cities: ");
                topNCitiesInContinent(continent11, input.nextInt());
                break;
            case 12:
                System.out.print("Enter country: ");
                input.nextLine();
                String country12 = input.nextLine();
                System.out.print("How many top cities: ");
                topNCitiesInCountry(country12, input.nextInt());
                break;
                
            case 13:
                checkDatabaseColumns();
                break;
            case 0:
                System.out.println("Thank you for using Population Reports!");
                return;
            default:
                System.out.println("Invalid choice, try again..");
        }
        
        // Return to menu
        System.out.println("\nPress Enter to continue...");
        input.nextLine();
        input.nextLine();
        main(args);
    }

    // ========== COUNTRY REPORTS (6) ==========

    /**
     * 1. All countries in the world by population
     */
    public static void allCountriesInTheWorld(int num) throws SQLException, ClassNotFoundException {
        String query = "SELECT Code, Name, Continent, Region, Population, Capital " +
                      "FROM country ORDER BY Population DESC";
        
        if (num > 0) query += " LIMIT " + num;
        System.out.println(" All Countries in World (Top " + (num > 0 ? num : "All") + ")");
        Database_Connection.query(query);
    }

    /**
     * 2. All countries in a continent
     */
    public static void allCountriesInContinent(String continent) throws SQLException, ClassNotFoundException {
        String query = "SELECT Code, Name, Region, Population " +
                      "FROM country WHERE Continent = '" + continent + "' " +
                      "ORDER BY Population DESC";
        System.out.println(" Countries in " + continent);
        Database_Connection.query(query);
    }

    /**
     * 3. All countries in a region
     */
    public static void allCountriesInRegion(String region) throws SQLException, ClassNotFoundException {
        String query = "SELECT Code, Name, Population " +
                      "FROM country WHERE Region = '" + region + "' " +
                      "ORDER BY Population DESC";
        System.out.println(" Countries in " + region + " region");
        Database_Connection.query(query);
    }

    /**
     * 4. Top N countries in the world
     */
    public static void topNCountriesWorld(int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT Name, Continent, Population " +
                      "FROM country ORDER BY Population DESC LIMIT " + n;
        System.out.println(" Top " + n + " Countries Worldwide");
        Database_Connection.query(query);
    }

    /**
     * 5. Top N countries in a continent
     */
    public static void topNCountriesInContinent(String continent, int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT Name, Region, Population " +
                      "FROM country WHERE Continent = '" + continent + "' " +
                      "ORDER BY Population DESC LIMIT " + n;
        System.out.println(" Top " + n + " Countries in " + continent);
        Database_Connection.query(query);
    }

    /**
     * 6. Top N countries in a region
     */
    public static void topNCountriesInRegion(String region, int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT Name, Population " +
                      "FROM country WHERE Region = '" + region + "' " +
                      "ORDER BY Population DESC LIMIT " + n;
        System.out.println(" Top " + n + " Countries in " + region);
        Database_Connection.query(query);
    }

    //  CITY REPORTS (6) 
    /**
     * 7. All cities in the world by population
     */
    public static void allCitiesInTheWorld(int num) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name as Country, city.District, city.Population " +
                      "FROM city JOIN country ON city.CountryCode = country.Code " +
                      "ORDER BY city.Population DESC";
        
        if (num > 0) query += " LIMIT " + num;
        System.out.println(" All Cities in World (Top " + (num > 0 ? num : "All") + ")");
        Database_Connection.query(query);
    }

    /**
     * 8. All cities in a continent
     */
    public static void allCitiesInContinent(String continent) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name as Country, city.District, city.Population " +
                      "FROM city JOIN country ON city.CountryCode = country.Code " +
                      "WHERE country.Continent = '" + continent + "' " +
                      "ORDER BY city.Population DESC";
        System.out.println(" Cities in " + continent);
        Database_Connection.query(query);
    }

    /**
     * 9. All cities in a country
     */
    public static void allCitiesInCountry(String country) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, city.District, city.Population " +
                      "FROM city JOIN country ON city.CountryCode = country.Code " +
                      "WHERE country.Name = '" + country + "' " +
                      "ORDER BY city.Population DESC";
        System.out.println(" Cities in " + country);
        Database_Connection.query(query);
    }

    /**
     * 10. Top N cities in the world
     */
    public static void topNCitiesWorld(int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name as Country, city.Population " +
                      "FROM city JOIN country ON city.CountryCode = country.Code " +
                      "ORDER BY city.Population DESC LIMIT " + n;
        System.out.println("🚀Top " + n + " Cities Worldwide");
        Database_Connection.query(query);
    }

    /**
     * 11. Top N cities in a continent
     */
    public static void topNCitiesInContinent(String continent, int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name as Country, city.Population " +
                      "FROM city JOIN country ON city.CountryCode = country.Code " +
                      "WHERE country.Continent = '" + continent + "' " +
                      "ORDER BY city.Population DESC LIMIT " + n;
        System.out.println("Top " + n + " Cities in " + continent);
        Database_Connection.query(query);
    }

    /**
     * 12. Top N cities in a country
     */
    public static void topNCitiesInCountry(String country, int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, city.District, city.Population " +
                      "FROM city JOIN country ON city.CountryCode = country.Code " +
                      "WHERE country.Name = '" + country + "' " +
                      "ORDER BY city.Population DESC LIMIT " + n;
        System.out.println("Top " + n + " Cities in " + country);
        Database_Connection.query(query);
    }

    //  TOOLS

    /**
     * Database structure helper
     */
    public static void checkDatabaseColumns() throws SQLException, ClassNotFoundException {
        System.out.println("📋 Database Structure:");
        System.out.println("Table: city");
        Database_Connection.query("SELECT * FROM city LIMIT 2");
        System.out.println("\nTable: country");
        Database_Connection.query("SELECT * FROM country LIMIT 2");
        System.out.println("\nTable: countrylanguage");
        Database_Connection.query("SELECT * FROM countrylanguage LIMIT 2");
    }
}
