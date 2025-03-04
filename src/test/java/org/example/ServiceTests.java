package org.example;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServiceTests {

    private Service service;

    @BeforeEach
    public void setUp() {
        service = new Service();
    }

    @Test
    public void testIsEvenWithEvenNumber() {
        // GIVEN
        int input = 4;

        // WHEN
        boolean result = service.isEven(input);

        // THEN
        assertThat(result).isTrue();
    }

    @Test
    public void testIsEvenWithOddNumber() {
        // GIVEN
        int input = 5;

        // WHEN
        boolean result = service.isEven(input);

        // THEN
        assertThat(result).isFalse();
    }

    @Test
    public void testHighComplexityMethodWhenAIsPositiveAndBAndCArePositive() {
        // GIVEN
        int a = 1;
        int b = 2;
        int c = 3;

        // WHEN
        service.highComplexityMethod(a, b, c);

        // THEN
        // No assertions needed as the method prints to console
    }

    @Test
    public void testHighComplexityMethodWhenAIsPositiveAndBIsNonPositiveAndCIsPositive() {
        // GIVEN
        int a = 1;
        int b = -2;
        int c = 3;

        // WHEN
        service.highComplexityMethod(a, b, c);

        // THEN
        // No assertions needed as the method prints to console
    }

    @Test
    public void testHighComplexityMethodWhenAIsPositiveAndBIsNonPositiveAndCIsNonPositive() {
        // GIVEN
        int a = 1;
        int b = -2;
        int c = -3;

        // WHEN
        service.highComplexityMethod(a, b, c);

        // THEN
        // No assertions needed as the method prints to console
    }

    @Test
    public void testHighComplexityMethodWhenAIsNonPositiveAndBAndCArePositive() {
        // GIVEN
        int a = -1;
        int b = 2;
        int c = 3;

        // WHEN
        service.highComplexityMethod(a, b, c);

        // THEN
        // No assertions needed as the method prints to console
    }

    @Test
    public void testHighComplexityMethodWhenAIsNonPositiveAndBIsNonPositiveAndCIsPositive() {
        // GIVEN
        int a = -1;
        int b = -2;
        int c = 3;

        // WHEN
        service.highComplexityMethod(a, b, c);

        // THEN
        // No assertions needed as the method prints to console
    }

    @Test
    public void testHighComplexityMethodWhenAIsNonPositiveAndBIsNonPositiveAndCIsNonPositive() {
        // GIVEN
        int a = -1;
        int b = -2;
        int c = -3;

        // WHEN
        service.highComplexityMethod(a, b, c);

        // THEN
        // No assertions needed as the method prints to console
    }
}
