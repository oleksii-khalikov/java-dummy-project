package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

    @Test

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
    void testHighComplexityMethod_GivenAllPositive() {
        // GIVEN a, b, and c are positive
        int a = 1;
        int b = 2;
        int c = 3;
        // WHEN highComplexityMethod is called with the inputs
        service.highComplexityMethod(a, b, c);
        // THEN all messages should indicate positive values
        assertThat("a is positive").isEqualTo("b is positive").isEqualTo("c is positive");
    }

    @Test
    void testHighComplexityMethod_GivenAPositive() {
        // GIVEN a is positive, b and c are non-positive
        int a = 1;
        int b = -2;
        int c = -3;
        // WHEN highComplexityMethod is called with the inputs
        service.highComplexityMethod(a, b, c);
        // THEN all messages should indicate positive values
        assertThat("a is positive").isEqualTo("b is non-positive").isEqualTo("c is non-positive");
    }

    @Test
    void testHighComplexityMethod_GivenANonPositive() {
        // GIVEN a is non-positive, b and c are positive
        int a = -1;
        int b = 2;
        int c = 3;
        // WHEN highComplexityMethod is called with the inputs
        service.highComplexityMethod(a, b, c);
        // THEN all messages should indicate positive values
        assertThat("a is non-positive").isEqualTo("b is positive").isEqualTo("c is positive");
    }
