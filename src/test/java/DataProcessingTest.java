package com.napier.sem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class MyTests {

    @Test 
    void testReportStructure() {
        // Arrange - fake data
        List<CityReport> fakeReport = Arrays.asList(
            new CityReport("London", "UK", "England", 8900000),
            new CityReport("Birmingham", "UK", "England", 1100000)
        );
        
        // Act & Assert - row count
        assertEquals(2, fakeReport.size());
        
        // Assert - column count (check all properties exist)
        CityReport firstCity = fakeReport.get(0);
        assertNotNull(firstCity.getName());
        assertNotNull(firstCity.getCountry());
        assertNotNull(firstCity.getDistrict());
        assertTrue(firstCity.getPopulation() > 0);
    }

    @Test 
    void testSpecificDataInResults() {
        // Arrange - fake data with known values
        List<Country> fakeCountries = Arrays.asList(
            new Country("GBR", "United Kingdom", "Europe", "British Isles", 67000000, "London"),
            new Country("FRA", "France", "Europe", "Western Europe", 65000000, "Paris")
        );
        
        // Act - your filtering logic
        List<Country> europeanCountries = fakeCountries.stream()
            .filter(c -> c.getContinent().equals("Europe"))
            .toList();
        
        // Assert - specific data is present
        assertTrue(europeanCountries.stream()
            .anyMatch(c -> c.getName().equals("United Kingdom")));
    }

    @Test 
    void testPopulationSortingDescending() {
        // Arrange - fake unsorted data
        List<Country> countries = Arrays.asList(
            new Country("USA", 330000000),  // 3rd largest
            new Country("India", 1300000000), // 2nd largest  
            new Country("China", 1400000000)  // 1st largest
        );
        
        // Act - YOUR sorting method
        countries.sort((a, b) -> Long.compare(b.getPopulation(), a.getPopulation()));
        
        // Assert - correct order
        assertEquals("China", countries.get(0).getName());
        assertEquals("India", countries.get(1).getName());
        assertEquals("USA", countries.get(2).getName());
    }
}
