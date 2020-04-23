package com.arch.junit5;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTestsDemo {

    @Test
    @Order(1)
    void nullValues() {
        // perform assertions against null values
        System.out.println("Test 1");
    }

    @Test
    @Order(2)
    void emptyValues() {
        // perform assertions against empty values
        System.out.println("Test 2");
    }

    @Test
    @Order(3)
    void validValues() {
        // perform assertions against valid values
        System.out.println("Test 3");
    }
}
