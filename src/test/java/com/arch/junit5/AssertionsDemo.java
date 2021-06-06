package com.arch.junit5;

import com.arch.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssertionsDemo {

    private final Calculator calculator = new Calculator();

    @Test
    void standardAssertions() {
        int result = calculator.add(1, 1);

        assertEquals(2, result);
    }

    @Test
    void standardAssertionsWithCustomMessage() {
        int result = calculator.multiply(2, 2);

        assertEquals(4, result, "The optional failure message is now the last parameter");
    }

    @Test
    void exceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
        assertEquals("/ by zero", exception.getMessage());
    }

}
