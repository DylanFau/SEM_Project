package com.napier.sem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyTest {

    // Basic test to confirm JUnit is running
    @Test
    void basicTest() {
        assertEquals(5, 5);
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
}
