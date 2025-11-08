package com.napier.sem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyTest {

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
}
