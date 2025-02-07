package org.example;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ServiceTests {

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
        // THEN the result should be true
        assertThat(result).isTrue();
    }

    @Test
    void testIsEven_GivenOddNumber_ReturnsFalse() {
        // GIVEN an odd number
        int input = 7;
        // WHEN isEven method is called with the input
        boolean result = service.isEven(input);
        // THEN the result should be false
        assertThat(result).isFalse();
    }

    @Test
    void testHighComplexityMethod_GivenAllPositive() {
        // GIVEN a, b, and c are positive
        int a = 1;
        int b = 2;
        int c = 3;
        // WHEN highComplexityMethod is called with the inputs
        service.highComplexityMethod(a, b, c);
        // THEN the output should be: "a is positive", "b is positive", "c is positive"
    }

    @Test
    void testHighComplexityMethod_GivenAPositive() {
        // GIVEN a is positive, b and c are non-positive
        int a = 1;
        int b = -2;
        int c = 0;
        // WHEN highComplexityMethod is called with the inputs
        service.highComplexityMethod(a, b, c);
        // THEN the output should be: "a is positive", "b is non-positive", "c is non-positive"
    }

    @Test
    void testHighComplexityMethod_GivenANonPositive() {
        // GIVEN a is non-positive, b and c are positive
        int a = -1;
        int b = 2;
        int c = 3;
        // WHEN highComplexityMethod is called with the inputs
        service.highComplexityMethod(a, b, c);
        // THEN the output should be: "a is non-positive", "b is positive", "c is positive"
    }

}
