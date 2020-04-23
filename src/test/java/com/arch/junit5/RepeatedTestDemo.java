package com.arch.junit5;

import org.junit.jupiter.api.RepeatedTest;

public class RepeatedTestDemo {

    @RepeatedTest(10)
    void repeatedTest() {
        // ...
        System.out.println("Repeat...");
    }
}
