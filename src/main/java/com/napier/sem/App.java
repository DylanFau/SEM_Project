package com.napier.sem;

import java.sql.*;
import java.util.Scanner;

/**
 * World Population Reporting System
 */
public class App {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        
        // Main menu system
        System.out.println("=== WORLD POPULATION REPORTING SYSTEM ===");
        System.out.println("COUNTRIES:");
        System.out.println("(1) All countries in the world by population");
        System.out.println("(2) All countries in a continent");
        System.out.println("(3) All countries in a region");
        System.out.println("(4) Top N countries in the world");
        System.out.println("(5) Top N countries in a continent");
        System.out.println("(6) Top N countries in a region");
        
        System.out.println("\nCITIES:");
        System.out.println("(7) All cities in the world by population");
        System.out.println("(8) All cities in a continent");
        System.out.println("(9) All cities in a country");
        System.out.println("(10) Top N cities in the world");
        System.out.println("(11) Top N cities in a continent");
        System.out.println("(12) Top N cities in a country");
        
        System.out.println("\nCAPITAL CITIES:");
        System.out.println("(13) Cities in a region by population");
        System.out.println("(14) Cities in a district by population");
        System.out.println("(15) Top N cities in a region");
        System.out.println("(16) Top N cities by country code");
        System.out.println("(17) Top N cities in a district");
        System.out.println("(18) All capital cities worldwide");
        System.out.println("(19) Capital cities in continent");
        System.out.println("(20) Capital cities in region");
        System.out.println("(21) Top N capital cities worldwide");
        System.out.println("(22) Top N capital cities in continent");
        System.out.println("(23) Top N capital cities in region");
        
        System.out.println("\nPOPULATION ANALYSIS:");
        System.out.println("(24) Population by continent (urban vs rural)");
        System.out.println("(25) Population by region (urban vs rural)");
        System.out.println("(26) Population by country (urban vs rural)");
        
        System.out.println("\nTOOLS:");
        System.out.println("(27) Check database structure");
        System.out.println("(0) Exit");

        System.out.print("\nPlease choose an option: ");
        int choice = input.nextInt();

        
        switch (choice) {
            // Country reports
            case 1: allCountriesInTheWorld(input.nextInt()); break;
            case 2: input.nextLine(); allCountriesInContinent(input.nextLine()); break;
            case 3: input.nextLine(); allCountriesInRegion(input.nextLine()); break;
            case 4: topNCountriesWorld(input.nextInt()); break;
            case 5: input.nextLine(); topNCountriesInContinent(input.nextLine(), input.nextInt()); break;
            case 6: input.nextLine(); topNCountriesInRegion(input.nextLine(), input.nextInt()); break;
                
            // City reports
            case 7: allCitiesInTheWorld(input.nextInt()); break;
            case 8: input.nextLine(); allCitiesInContinent(input.nextLine()); break;
            case 9: input.nextLine(); allCitiesInCountry(input.nextLine()); break;
            case 10: topNCitiesWorld(input.nextInt()); break;
            case 11: input.nextLine(); topNCitiesInContinent(input.nextLine(), input.nextInt()); break;
            case 12: input.nextLine(); topNCitiesInCountry(input.nextLine(), input.nextInt()); break;
                
            // Capital city reports
            case 13: input.nextLine(); citiesInRegion(input.nextLine()); break;
            case 14: input.nextLine(); citiesInDistrict(input.nextLine()); break;
            case 15: input.nextLine(); topNCitiesInRegion(input.nextLine(), input.nextInt()); break;
            case 16: input.nextLine(); topNCitiesInCountryCode(input.nextLine(), input.nextInt()); break;
            case 17: input.nextLine(); topNCitiesInDistrict(input.nextLine(), input.nextInt()); break;
            case 18: allCapitalCities(); break;
            case 19: input.nextLine(); capitalsInContinent(input.nextLine()); break;
            case 20: input.nextLine(); capitalsInRegion(input.nextLine()); break;
            case 21: topNCapitalsWorld(input.nextInt()); break;
            case 22: input.nextLine(); topNCapitalsInContinent(input.nextLine(), input.nextInt()); break;
            case 23: input.nextLine(); topNCapitalsInRegion(input.nextLine(), input.nextInt()); break;
                
            // Population analysis
            case 24: populationByContinent(); break;
            case 25: populationByRegion(); break;
            case 26: populationByCountry(); break;
                
            case 27: checkDatabaseColumns(); break;
            case 0: System.out.println("Thank you for using Population Reports!"); return;
            default: System.out.println("Invalid choice, try again..");
        }
        
        // Return to main menu
        System.out.println("\nPress Enter to continue...");
        input.nextLine(); input.nextLine();
        main(args);
    }

    // COUNTRY REPORTS 

    public static void allCountriesInTheWorld(int num) throws SQLException, ClassNotFoundException {
        String query = "SELECT Code, Name, Continent, Region, Population, Capital " +
                      "FROM country ORDER BY Population DESC";
        if (num > 0) query += " LIMIT " + num;
        System.out.println("All Countries in World (Top " + (num > 0 ? num : "All") + ")");
        Database_Connection.query(query);
    }


    public static void allCountriesInContinent(String continent) throws SQLException, ClassNotFoundException {
        String query = "SELECT Code, Name, Region, Population FROM country " +
                      "WHERE Continent = '" + continent + "' ORDER BY Population DESC";
        System.out.println("Countries in " + continent);
        Database_Connection.query(query);
    }


    public static void allCountriesInRegion(String region) throws SQLException, ClassNotFoundException {
        String query = "SELECT Code, Name, Population FROM country " +
                      "WHERE Region = '" + region + "' ORDER BY Population DESC";
        System.out.println("Countries in " + region + " region");
        Database_Connection.query(query);
    }


    public static void topNCountriesWorld(int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT Name, Continent, Population FROM country " +
                      "ORDER BY Population DESC LIMIT " + n;
        System.out.println("Top " + n + " Countries Worldwide");
        Database_Connection.query(query);
    }


    public static void topNCountriesInContinent(String continent, int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT Name, Region, Population FROM country " +
                      "WHERE Continent = '" + continent + "' ORDER BY Population DESC LIMIT " + n;
        System.out.println("Top " + n + " Countries in " + continent);
        Database_Connection.query(query);
    }

 
    public static void topNCountriesInRegion(String region, int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT Name, Population FROM country " +
                      "WHERE Region = '" + region + "' ORDER BY Population DESC LIMIT " + n;
        System.out.println("Top " + n + " Countries in " + region);
        Database_Connection.query(query);
    }

    // CITY REPORTS

    /** Get all cities worldwide sorted by population */
    public static void allCitiesInTheWorld(int num) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name as Country, city.District, city.Population " +
                      "FROM city JOIN country ON city.CountryCode = country.Code " +
                      "ORDER BY city.Population DESC";
        if (num > 0) query += " LIMIT " + num;
        System.out.println("All Cities in World (Top " + (num > 0 ? num : "All") + ")");
        Database_Connection.query(query);
    }

    /** Get cities in specific continent */
    public static void allCitiesInContinent(String continent) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name as Country, city.District, city.Population " +
                      "FROM city JOIN country ON city.CountryCode = country.Code " +
                      "WHERE country.Continent = '" + continent + "' ORDER BY city.Population DESC";
        System.out.println("Cities in " + continent);
        Database_Connection.query(query);
    }

    /** Get cities in specific country */
    public static void allCitiesInCountry(String country) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, city.District, city.Population " +
                      "FROM city JOIN country ON city.CountryCode = country.Code " +
                      "WHERE country.Name = '" + country + "' ORDER BY city.Population DESC";
        System.out.println("Cities in " + country);
        Database_Connection.query(query);
    }

    /** Get top N cities worldwide */
    public static void topNCitiesWorld(int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name as Country, city.Population " +
                      "FROM city JOIN country ON city.CountryCode = country.Code " +
                      "ORDER BY city.Population DESC LIMIT " + n;
        System.out.println("Top " + n + " Cities Worldwide");
        Database_Connection.query(query);
    }

    /** Get top N cities in continent */
    public static void topNCitiesInContinent(String continent, int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name as Country, city.Population " +
                      "FROM city JOIN country ON city.CountryCode = country.Code " +
                      "WHERE country.Continent = '" + continent + "' ORDER BY city.Population DESC LIMIT " + n;
        System.out.println("Top " + n + " Cities in " + continent);
        Database_Connection.query(query);
    }

    /** Get top N cities in country */
    public static void topNCitiesInCountry(String country, int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, city.District, city.Population " +
                      "FROM city JOIN country ON city.CountryCode = country.Code " +
                      "WHERE country.Name = '" + country + "' ORDER BY city.Population DESC LIMIT " + n;
        System.out.println("Top " + n + " Cities in " + country);
        Database_Connection.query(query);
    }

    //ADDITIONAL CITY REPORTS

    /** Get cities in specific region */
    public static void citiesInRegion(String region) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, city.CountryCode, city.District, city.Population " +
                       "FROM city JOIN country ON city.CountryCode = country.Code " +
                       "WHERE country.Region = '" + region + "' ORDER BY city.Population DESC";
        System.out.println("Cities in " + region + " region");
        Database_Connection.query(query);
    }

    /** Get cities in specific district */
    public static void citiesInDistrict(String district) throws SQLException, ClassNotFoundException {
        String query = "SELECT Name, CountryCode, District, Population FROM city " +
                       "WHERE District = '" + district + "' ORDER BY Population DESC";
        System.out.println("Cities in district " + district);
        Database_Connection.query(query);
    }

    /** Get top N cities in region */
    public static void topNCitiesInRegion(String region, int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, city.CountryCode, city.District, city.Population " +
                       "FROM city JOIN country ON city.CountryCode = country.Code " +
                       "WHERE country.Region = '" + region + "' ORDER BY city.Population DESC LIMIT " + n;
        System.out.println("Top " + n + " cities in " + region);
        Database_Connection.query(query);
    }

    /** Get top N cities by country code */
    public static void topNCitiesInCountryCode(String countryCode, int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT Name, CountryCode, District, Population FROM city " +
                       "WHERE CountryCode = '" + countryCode + "' ORDER BY Population DESC LIMIT " + n;
        System.out.println("Top " + n + " cities in country code " + countryCode);
        Database_Connection.query(query);
    }

    /** Get top N cities in district */
    public static void topNCitiesInDistrict(String district, int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT Name, CountryCode, District, Population FROM city " +
                       "WHERE District = '" + district + "' ORDER BY Population DESC LIMIT " + n;
        System.out.println("Top " + n + " cities in district " + district);
        Database_Connection.query(query);
    }

    // CAPITAL CITY REPORTS 

    /** Get all capital cities worldwide */
    public static void allCapitalCities() throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name AS Country, city.Population " +
                       "FROM city JOIN country ON city.ID = country.Capital " +
                       "ORDER BY city.Population DESC";
        System.out.println("All capital cities worldwide");
        Database_Connection.query(query);
    }

    /** Get capital cities in continent */
    public static void capitalsInContinent(String continent) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name AS Country, city.Population " +
                       "FROM city JOIN country ON city.ID = country.Capital " +
                       "WHERE country.Continent = '" + continent + "' ORDER BY city.Population DESC";
        System.out.println("Capital cities in " + continent);
        Database_Connection.query(query);
    }

    /** Get capital cities in region */
    public static void capitalsInRegion(String region) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name AS Country, city.Population " +
                       "FROM city JOIN country ON city.ID = country.Capital " +
                       "WHERE country.Region = '" + region + "' ORDER BY city.Population DESC";
        System.out.println("Capital cities in " + region);
        Database_Connection.query(query);
    }

    /** Get top N capital cities worldwide */
    public static void topNCapitalsWorld(int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name AS Country, city.Population " +
                       "FROM city JOIN country ON city.ID = country.Capital " +
                       "ORDER BY city.Population DESC LIMIT " + n;
        System.out.println("Top " + n + " capital cities worldwide");
        Database_Connection.query(query);
    }

    /** Get top N capital cities in continent */
    public static void topNCapitalsInContinent(String continent, int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name AS Country, city.Population " +
                       "FROM city JOIN country ON city.ID = country.Capital " +
                       "WHERE country.Continent = '" + continent + "' ORDER BY city.Population DESC LIMIT " + n;
        System.out.println("Top " + n + " capital cities in " + continent);
        Database_Connection.query(query);
    }

    /** Get top N capital cities in region */
    public static void topNCapitalsInRegion(String region, int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name AS Country, city.Population " +
                       "FROM city JOIN country ON city.ID = country.Capital " +
                       "WHERE country.Region = '" + region + "' ORDER BY city.Population DESC LIMIT " + n;
        System.out.println("Top " + n + " capital cities in " + region);
        Database_Connection.query(query);
    }

    //  POPULATION ANALYSIS REPORTS

    /** Get population breakdown by continent */
    public static void populationByContinent() throws SQLException, ClassNotFoundException {
        String query = "SELECT country.Continent AS Name, SUM(country.Population) AS TotalPopulation, " +
                       "SUM(city.Population) AS CityPopulation, " +
                       "(SUM(country.Population) - SUM(city.Population)) AS NonCityPopulation " +
                       "FROM country LEFT JOIN city ON country.Code = city.CountryCode GROUP BY country.Continent";
        System.out.println("Population by continent (urban vs rural)");
        Database_Connection.query(query);
    }

    /** Get population breakdown by region */
    public static void populationByRegion() throws SQLException, ClassNotFoundException {
        String query = "SELECT country.Region AS Name, SUM(country.Population) AS TotalPopulation, " +
                       "SUM(city.Population) AS CityPopulation, " +
                       "(SUM(country.Population) - SUM(city.Population)) AS NonCityPopulation " +
                       "FROM country LEFT JOIN city ON country.Code = city.CountryCode GROUP BY country.Region";
        System.out.println("Population by region (urban vs rural)");
        Database_Connection.query(query);
    }

    /** Get population breakdown by country */
    public static void populationByCountry() throws SQLException, ClassNotFoundException {
        String query = "SELECT country.Name AS Name, country.Population AS TotalPopulation, " +
                       "SUM(city.Population) AS CityPopulation, " +
                       "(country.Population - SUM(city.Population)) AS NonCityPopulation " +
                       "FROM country LEFT JOIN city ON country.Code = city.CountryCode GROUP BY country.Code";
        System.out.println("Population by country (urban vs rural)");
        Database_Connection.query(query);
    }

    //  TOOLS

    /** Display database structure for reference */
    public static void checkDatabaseColumns() throws SQLException, ClassNotFoundException {
        System.out.println("Database Structure Overview:");
        System.out.println("Table: city");
        Database_Connection.query("SELECT * FROM city LIMIT 2");
        System.out.println("\nTable: country");
        Database_Connection.query("SELECT * FROM country LIMIT 2");
        System.out.println("\nTable: countrylanguage");
        Database_Connection.query("SELECT * FROM countrylanguage LIMIT 2");
    }
}
