package org.example;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServiceGeneratedAiTests {

    private Service service;

    @BeforeEach
    void setUp() {
        service = new Service();
    }

    @Test
    void testIsEven_GivenEvenNumber_ReturnsTrue() {
        // GIVEN an even number
        int input = 4;
        // WHEN isEven method is called with the input
        boolean result = service.isEven(input);
        // THEN it should return true
        assertTrue(result);
    }

    @Test
    void testIsEven_GivenOddNumber_ReturnsFalse() {
        // GIVEN an odd number
        int input = 7;
        // WHEN isEven method is called with the input
        boolean result = service.isEven(input);
        // THEN it should return false
        assertFalse(result);
    }

    @Test
    void testHighComplexityMethod_GivenAllPositive() {
        // GIVEN a, b, and c are all positive
        int a = 1;
        int b = 2;
        int c = 3;
        // WHEN highComplexityMethod is called with the inputs
        service.highComplexityMethod(a, b, c);
        // THEN it should print "a is positive", "b is positive", and "c is positive"
    }

    @Test
    void testHighComplexityMethod_GivenAPositiveAndNonPositiveBC() {
        // GIVEN a is positive, b and c are non-positive
        int a = 1;
        int b = -2;
        int c = 0;
        // WHEN highComplexityMethod is called with the inputs
        service.highComplexityMethod(a, b, c);
        // THEN it should print "a is positive", "b is non-positive", and "c is non-positive"
    }

    @Test
    void testHighComplexityMethod_GivenANonPositiveAndPositiveBC() {
        // GIVEN a is non-positive, b and c are positive
        int a = -1;
        int b = 2;
        int c = 3;
        // WHEN highComplexityMethod is called with the inputs
        service.highComplexityMethod(a, b, c);
        // THEN it should print "a is non-positive", "b is positive", and "c is positive"
    }

    @Test
    void testHighComplexityMethod_GivenAllNonPositive() {
        // GIVEN a, b, and c are all non-positive
        int a = -1;
        int b = -2;
        int c = -3;
        // WHEN highComplexityMethod is called with the inputs
        service.highComplexityMethod(a, b, c);
        // THEN it should print "a is non-positive", "b is non-positive", and "c is non-positive"
    }

}
