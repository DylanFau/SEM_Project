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
        
    System.out.println("(13) All the cities in a region organised by largest population to smallest");
    System.out.println("(14) All the cities in a district organised by largest population to smallest");
    System.out.println("(15) The top N populated cities in a region");
    System.out.println("(16) The top N populated cities in a country (by country code)");
    System.out.println("(17) The top N populated cities in a district");
    System.out.println("(18) All the capital cities in the world organised by largest population to smallest");
    System.out.println("(19) All the capital cities in a continent organised by largest population to smallest");
    System.out.println("(20) All the capital cities in a region organised by largest to smallest");
    System.out.println("(21) The top N populated capital cities in the world");
    System.out.println("(22) The top N populated capital cities in a continent");
    System.out.println("(23) The top N populated capital cities in a region");
    System.out.println("(24) Population by continent (cities vs non-cities)");
    System.out.println("(25) Population by region (cities vs non-cities)");
    System.out.println("(26) Population by country (cities vs non-cities)");

    System.out.println("\nTOOLS:");
    System.out.println("(27) Check database structure");
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
            // Continue reports (13-26)
            case 13:
                System.out.print("Enter region: ");
                input.nextLine();
                citiesInRegion(input.nextLine());
                break;
            case 14:
                System.out.print("Enter district: ");
                input.nextLine();
                citiesInDistrict(input.nextLine());
                break;
            case 15:
                System.out.print("Enter region: ");
                input.nextLine();
                String region15 = input.nextLine();
                System.out.print("How many top cities: ");
                topNCitiesInRegion(region15, input.nextInt());
                break;
            case 16:
                System.out.print("Enter country code: ");
                input.nextLine();
                String cc16 = input.nextLine();
                System.out.print("How many top cities: ");
                q4_topNCitiesInCountryCode(cc16, input.nextInt());
                break;
            case 17:
                System.out.print("Enter district: ");
                input.nextLine();
                String district17 = input.nextLine();
                System.out.print("How many top cities: ");
                q5_topNCitiesInDistrict(district17, input.nextInt());
                break;
            case 18:
                q6_allCapitalCities();
                break;
            case 19:
                System.out.print("Enter continent: ");
                input.nextLine();
                q7_capitalsInContinent(input.nextLine());
                break;
            case 20:
                System.out.print("Enter region: ");
                input.nextLine();
                q8_capitalsInRegion(input.nextLine());
                break;
            case 21:
                System.out.print("How many top capitals: ");
                q9_topNCapitalsWorld(input.nextInt());
                break;
            case 22:
                System.out.print("Enter continent: ");
                input.nextLine();
                String cont22 = input.nextLine();
                System.out.print("How many top capitals: ");
                q10_topNCapitalsInContinent(cont22, input.nextInt());
                break;
            case 23:
                System.out.print("Enter region: ");
                input.nextLine();
                String reg23 = input.nextLine();
                System.out.print("How many top capitals: ");
                q11_topNCapitalsInRegion(reg23, input.nextInt());
                break;
            case 24:
                populationByContinent();
                break;
            case 25:
                populationByRegion();
                break;
            case 26:
                populationByCountry();
                break;
                
            case 27:
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
        System.out.println("Top " + n + " Cities Worldwide");
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

    // ========== REPORTS (13) - (26) ==========

    /**
     * 13. All the cities in a region organised by largest population to smallest.
     */
    public static void citiesInRegion(String region) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, city.CountryCode, city.District, city.Population " +
                       "FROM city JOIN country ON city.CountryCode = country.Code " +
                       "WHERE country.Region = '" + region + "' " +
                       "ORDER BY city.Population DESC";
        System.out.println("All the cities in " + region + " organised by largest population to smallest.");
        Database_Connection.query(query);
    }

    /**
     * 14. All the cities in a district organised by largest population to smallest.
     */
    public static void citiesInDistrict(String district) throws SQLException, ClassNotFoundException {
        String query = "SELECT Name, CountryCode, District, Population FROM city " +
                       "WHERE District = '" + district + "' ORDER BY Population DESC";
        System.out.println("All the cities in district " + district + " organised by largest population to smallest.");
        Database_Connection.query(query);
    }

    /**
     * 15. The top N populated cities in a region where N is provided by the user.
     */
    public static void topNCitiesInRegion(String region, int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, city.CountryCode, city.District, city.Population " +
                       "FROM city JOIN country ON city.CountryCode = country.Code " +
                       "WHERE country.Region = '" + region + "' " +
                       "ORDER BY city.Population DESC LIMIT " + n;
        System.out.println("The top " + n + " populated cities in " + region);
        Database_Connection.query(query);
    }

    /**
     * 16. The top N populated cities in a country where N is provided by the user (by country code).
     */
    public static void topNCitiesInCountryCode(String countryCode, int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT Name, CountryCode, District, Population FROM city " +
                       "WHERE CountryCode = '" + countryCode + "' ORDER BY Population DESC LIMIT " + n;
        System.out.println("The top " + n + " populated cities in country code " + countryCode);
        Database_Connection.query(query);
    }

    /**
     * 17. The top N populated cities in a district where N is provided by the user.
     */
    public static void topNCitiesInDistrict(String district, int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT Name, CountryCode, District, Population FROM city " +
                       "WHERE District = '" + district + "' ORDER BY Population DESC LIMIT " + n;
        System.out.println("The top " + n + " populated cities in district " + district);
        Database_Connection.query(query);
    }

    /**
     * 18. All the capital cities in the world organised by largest population to smallest.
     */
    public static void allCapitalCities() throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name AS Country, city.Population " +
                       "FROM city JOIN country ON city.ID = country.Capital " +
                       "ORDER BY city.Population DESC";
        System.out.println("All the capital cities in the world organised by largest population to smallest.");
        Database_Connection.query(query);
    }

    /**
     * 19. All the capital cities in a continent organised by largest population to smallest.
     */
    public static void capitalsInContinent(String continent) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name AS Country, city.Population " +
                       "FROM city JOIN country ON city.ID = country.Capital " +
                       "WHERE country.Continent = '" + continent + "' " +
                       "ORDER BY city.Population DESC";
        System.out.println("All the capital cities in " + continent + " organised by largest population to smallest.");
        Database_Connection.query(query);
    }

    /**
     * 20. All the capital cities in a region organised by largest to smallest.
     */
    public static void capitalsInRegion(String region) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name AS Country, city.Population " +
                       "FROM city JOIN country ON city.ID = country.Capital " +
                       "WHERE country.Region = '" + region + "' ORDER BY city.Population DESC";
        System.out.println("All the capital cities in " + region + " organised by largest to smallest.");
        Database_Connection.query(query);
    }

    /**
     * 21. The top N populated capital cities in the world where N is provided by the user.
     */
    public static void topNCapitalsWorld(int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name AS Country, city.Population " +
                       "FROM city JOIN country ON city.ID = country.Capital " +
                       "ORDER BY city.Population DESC LIMIT " + n;
        System.out.println("The top " + n + " populated capital cities in the world.");
        Database_Connection.query(query);
    }

    /**
     * 22. The top N populated capital cities in a continent where N is provided by the user.
     */
    public static void topNCapitalsInContinent(String continent, int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name AS Country, city.Population " +
                       "FROM city JOIN country ON city.ID = country.Capital " +
                       "WHERE country.Continent = '" + continent + "' ORDER BY city.Population DESC LIMIT " + n;
        System.out.println("The top " + n + " populated capital cities in " + continent);
        Database_Connection.query(query);
    }

    /**
     * 23. The top N populated capital cities in a region where N is provided by the user.
     */
    public static void topNCapitalsInRegion(String region, int n) throws SQLException, ClassNotFoundException {
        String query = "SELECT city.Name, country.Name AS Country, city.Population " +
                       "FROM city JOIN country ON city.ID = country.Capital " +
                       "WHERE country.Region = '" + region + "' ORDER BY city.Population DESC LIMIT " + n;
        System.out.println("The top " + n + " populated capital cities in " + region);
        Database_Connection.query(query);
    }

    /**
     * 24. The population of people, people living in cities, and people not living in cities in each continent.
     */
    public static void populationByContinent() throws SQLException, ClassNotFoundException {
        String query = "SELECT country.Continent AS Name, SUM(country.Population) AS TotalPopulation, " +
                       "SUM(city.Population) AS CityPopulation, (SUM(city.Population) / SUM(country.Population)) * 100 AS CityPercentage, " +
                       "(SUM(country.Population) - SUM(city.Population)) AS NonCityPopulation, " +
                       "((SUM(country.Population) - SUM(city.Population)) / SUM(country.Population)) * 100 AS NonCityPercentage " +
                       "FROM country LEFT JOIN city ON country.Code = city.CountryCode GROUP BY country.Continent";
        System.out.println("Population summary by continent");
        Database_Connection.query(query);
    }

    /**
     * 25. The population of people, people living in cities, and people not living in cities in each region.
     */
    public static void populationByRegion() throws SQLException, ClassNotFoundException {
        String query = "SELECT country.Region AS Name, SUM(country.Population) AS TotalPopulation, " +
                       "SUM(city.Population) AS CityPopulation, (SUM(city.Population) / SUM(country.Population)) * 100 AS CityPercentage, " +
                       "(SUM(country.Population) - SUM(city.Population)) AS NonCityPopulation, " +
                       "((SUM(country.Population) - SUM(city.Population)) / SUM(country.Population)) * 100 AS NonCityPercentage " +
                       "FROM country LEFT JOIN city ON country.Code = city.CountryCode GROUP BY country.Region";
        System.out.println("Population summary by region");
        Database_Connection.query(query);
    }

    /**
     * 26. The population of people, people living in cities, and people not living in cities in each country.
     */
    public static void populationByCountry() throws SQLException, ClassNotFoundException {
        String query = "SELECT country.Name AS Name, country.Population AS TotalPopulation, " +
                       "SUM(city.Population) AS CityPopulation, (SUM(city.Population) / country.Population) * 100 AS CityPercentage, " +
                       "(country.Population - SUM(city.Population)) AS NonCityPopulation, " +
                       "((country.Population - SUM(city.Population)) / country.Population) * 100 AS NonCityPercentage " +
                       "FROM country LEFT JOIN city ON country.Code = city.CountryCode GROUP BY country.Code";
        System.out.println("Population summary by country");
        Database_Connection.query(query);
    }


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
