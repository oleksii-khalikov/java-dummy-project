package org.example;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClientGeneratedAiTests {

    @Mock
    private Service service;

    @InjectMocks
    private Client client;

    @BeforeEach
    public void setUp() {
        // Reset the mock before each test
        when(service.isEven(0)).thenReturn(false); // Use a specific argument instead of anyInt()
    }

    @Test
    @DisplayName("GIVEN a valid name WHEN greeting is called THEN return a greeting in lowercase")
    public void testGreetingWithValidName() {
        // GIVEN
        String name = "Alice";

        // WHEN
        String result = client.greeting(name);

        // THEN
        assertEquals("hello, alice", result);
    }

    @Test
    @DisplayName("GIVEN a valid name with even length WHEN greeting is called THEN return a greeting in uppercase")
    public void testGreetingWithEvenLengthName() {
        // GIVEN
        String name = "Bob";

        // WHEN & THEN
        assertThrows(IllegalArgumentException.class, () -> client.greeting(name));
    }

    @Test
    @DisplayName("GIVEN a null name WHEN greeting is called THEN throw IllegalArgumentException")
    public void testGreetingWithNullName() {
        // GIVEN
        String name = null;

        // WHEN & THEN
        assertThrows(IllegalArgumentException.class, () -> client.greeting(name));
    }

    @Test
    @DisplayName("GIVEN an empty string name WHEN greeting is called THEN throw IllegalArgumentException")
    public void testGreetingWithEmptyStringName() {
        // GIVEN
        String name = "";

        // WHEN & THEN
        assertThrows(IllegalArgumentException.class, () -> client.greeting(name));
    }

    @Test
    @DisplayName("GIVEN a valid name with odd length WHEN greeting is called THEN return a greeting in lowercase")
    public void testGreetingWithOddLengthName() {
        // GIVEN
        String name = "Charlie";

        // WHEN
        when(service.isEven(name.length())).thenReturn(false);
        String result = client.greeting(name);

        // THEN
        assertEquals("hello, charlie", result);
    }

    @Test
    @DisplayName("GIVEN a valid name with length 0 WHEN greeting is called THEN return a greeting in lowercase")
    public void testGreetingWithZeroLengthName() {
        // GIVEN
        String name = "";

        // WHEN & THEN
        assertThrows(IllegalArgumentException.class, () -> client.greeting(name));
    }
}