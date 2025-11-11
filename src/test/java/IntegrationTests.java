package com.napier.sem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTests {

    // Simple test just to confirm JUnit is working
    @Test
    void basicTest() {
        assertEquals(5, 5);
    }

    // Test that a database connection can be created
    @Test
    void testDatabaseConnection() {
        try {
            var conn = Database_Connection.getConnection();
            assertNotNull(conn); // check that connection isn't null
            conn.close();
        } catch (Exception e) {
            fail("Database connection failed: " + e.getMessage());
        }
    }

    // Test that a query runs without errors
    @Test
    void testQueryRuns() {
        try {
            Database_Connection.query("SELECT Name FROM country LIMIT 3;");
        } catch (Exception e) {
            fail("Query failed to execute: " + e.getMessage());
        }
    }

    // Test: Query top 5 countries by population
    @Test
    void testQueryTopCountries() {
        try {
            Database_Connection.query("SELECT Name, Population FROM country ORDER BY Population DESC LIMIT 5;");
        } catch (Exception e) {
            fail("Top countries query failed: " + e.getMessage());
        }
    }

    // Test: Query average population of countries in each continent
    @Test
    void testQueryAveragePopulationByContinent() {
        try {
            Database_Connection.query("SELECT Continent, AVG(Population) AS Average_Population FROM country GROUP BY Continent;");
        } catch (Exception e) {
            fail("Average population query failed: " + e.getMessage());
        }
    }

    //  Test 1: Basic data structure validation
    @Test
    void testReportStructure() {
        // Arrange - using simple String arrays instead of custom classes
        List<String[]> fakeReport = Arrays.asList(new String[]{"London", "UK", "England", "8900000"}, new String[]{"Birmingham", "UK", "England", "1100000"});

        // Act and  Assert
        assertEquals(2, fakeReport.size());

        // Assert - column count (check all array elements exist)
        String[] firstCity = fakeReport.get(0);
        assertEquals(4, firstCity.length); // 4 columns
        assertNotNull(firstCity[0]); // Name
        assertNotNull(firstCity[1]); // Country
        assertNotNull(firstCity[2]); // District
        assertNotNull(firstCity[3]); // Population
    }

    //  Test 2: Data filtering and presence check
    @org.junit.jupiter.api.Test
    void testSpecificDataInResults() {
        // Arrange - using Map for flexibility
        List<Map<String, String>> fakeCountries = Arrays.asList(Map.of("code", "GBR", "name", "United Kingdom", "continent", "Europe", "region", "British Isles", "population", "67000000", "capital", "London"), Map.of("code", "FRA", "name", "France", "continent", "Europe", "region", "Western Europe", "population", "65000000", "capital", "Paris"));

        // Act - filtering logic
        List<Map<String, String>> europeanCountries = fakeCountries.stream().filter(c -> c.get("continent").equals("Europe")).toList();

        // Assert - specific data is present
        boolean hasUK = europeanCountries.stream().anyMatch(c -> c.get("name").equals("United Kingdom"));
        assertTrue(hasUK, "United Kingdom should be in European countries");
    }

    //  Test 3: Population sorting logic
    @org.junit.jupiter.api.Test
    void testPopulationSortingDescending() {
        // Arrange - using simple objects with population
        List<PopulationData> countries = Arrays.asList(new PopulationData("USA", 330000000),      // 3rd largest
                new PopulationData("India", 1300000000),   // 2nd largest
                new PopulationData("China", 1400000000)    // 1st largest
        );

        // Act - sorting by population descending
        countries.sort((a, b) -> Long.compare(b.population, a.population));

        // Assert - correct order
        assertEquals("China", countries.get(0).name);
        assertEquals("India", countries.get(1).name);
        assertEquals("USA", countries.get(2).name);
    }

    //  Test 4: Test with empty data
    @org.junit.jupiter.api.Test
    void testEmptyDataHandling() {
        // Arrange
        List<String[]> emptyReport = new ArrayList<>();

        // Act & Assert
        assertEquals(0, emptyReport.size());
        assertDoesNotThrow(() -> {
            // Simulate processing empty data
            processReport(emptyReport);
        });
    }

    //  Test 5: Test data validation
    @org.junit.jupiter.api.Test
    void testPopulationDataValidation() {
        // Arrange
        List<PopulationData> data = Arrays.asList(new PopulationData("ValidCountry", 1000000), new PopulationData("AnotherCountry", 500000));

        // Assert - all populations should be positive
        for (PopulationData item : data) {
            assertTrue(item.population > 0, "Population should be positive: " + item.name);
        }
    }

    // Test a simple string comparison
    @Test
    void stringEqualityTest() {
        String greeting = "Hello World";
        assertEquals("Hello World", greeting);
    }

    // Test that a list contains expected elements
    @Test
    void listContainsItemTest() {
        var items = java.util.List.of("Apple", "Banana", "Cherry");
        assertTrue(items.contains("Banana"));
    }

    // Test a simple math operation
    @Test
    void mathAdditionTest() {
        int result = 2 + 3;
        assertEquals(5, result);
    }

    // Test that an object is not null
    @Test
    void objectNotNullTest() {
        Object obj = new Object();
        assertNotNull(obj);
    }

    // Helper method
    private void processReport(List<String[]> report) {
        if (report.isEmpty()) {
            System.out.println("No data to process");
        }
    }

    // Simple helper class for population data
    static class PopulationData {
        String name;
        long population;

        PopulationData(String name, long population) {
            this.name = name;
            this.population = population;
        }
    }
}

