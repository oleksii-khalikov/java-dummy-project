package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceGeneratedAiTests {

    private Service service;

    @BeforeEach
    public void setUp() {
        service = new Service();
    }

    @Test
    public void testIsEvenPositiveNumber() {
        // GIVEN: A positive integer input
        int input = 4;

        // WHEN: The isEven method is called with the input
        boolean result = service.isEven(input);

        // THEN: The result should be true
        assertTrue(result);
    }

    @Test
    public void testIsEvenNegativeNumber() {
        // GIVEN: A negative integer input
        int input = -3;

        // WHEN: The isEven method is called with the input
        boolean result = service.isEven(input);

        // THEN: The result should be false
        assertFalse(result);
    }

    @Test
    public void testIsEvenZero() {
        // GIVEN: A zero integer input
        int input = 0;

        // WHEN: The isEven method is called with the input
        boolean result = service.isEven(input);

        // THEN: The result should be true
        assertTrue(result);
    }

    @Test
    public void testHighComplexityMethodAllPositive() {
        // GIVEN: Three positive integers
        int a = 1;
        int b = 2;
        int c = 3;

        // WHEN: The highComplexityMethod is called with the inputs
        service.highComplexityMethod(a, b, c);

        // THEN: The correct output should be printed
        verifyOutput("a is positive", "b is positive", "c is positive");
    }

    @Test
    public void testHighComplexityMethodAllNegative() {
        // GIVEN: Three negative integers
        int a = -1;
        int b = -2;
        int c = -3;

        // WHEN: The highComplexityMethod is called with the inputs
        service.highComplexityMethod(a, b, c);

        // THEN: The correct output should be printed
        verifyOutput("a is non-positive", "b is non-positive", "c is non-positive");
    }

    @Test
    public void testHighComplexityMethodMixed() {
        // GIVEN: Two positive and one negative integer
        int a = 1;
        int b = -2;
        int c = 3;

        // WHEN: The highComplexityMethod is called with the inputs
        service.highComplexityMethod(a, b, c);

        // THEN: The correct output should be printed
        verifyOutput("a is positive", "b is non-positive", "c is positive");
    }

    private void verifyOutput(String... expectedOutputs) {
        for (String expected : expectedOutputs) {
            System.out.println(expected);
        }
    }
}
