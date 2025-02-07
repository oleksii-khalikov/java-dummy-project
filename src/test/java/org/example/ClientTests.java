package org.example;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

    @Test

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
    void greeting_ValidName_ReturnsGreeting() {
        // GIVEN - Test cases for even and odd numbers
        Mockito.when(serviceMock.isEven(5)).thenReturn(false); // Odd number case
        String result1 = client.greeting("John"); 
        assertThat(result1).isEqualTo("Hello John!");

        Mockito.when(serviceMock.isEven(5)).thenReturn(true); // Even number case
        String result2 = client.greeting("Jane");
        assertThat(result2).isEqualTo("Hello Jane!");
    }
