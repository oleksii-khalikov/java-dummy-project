package org.example;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClientTests {
    private Service service;
    private Client client;

    @BeforeEach
    public void setUp() {
        service = new Service();
        client = new Client(service);
    }

    @Test
    public void testGreetingWithValidNameEvenLength() {
        // GIVEN
        String name = "Alice";

        // WHEN
        String result = client.greeting(name);

        // THEN
        assertThat(result).isEqualTo("HELLO, ALICE");
    }

    @Test
    public void testGreetingWithValidNameOddLength() {
        // GIVEN
        String name = "Bob";

        // WHEN
        String result = client.greeting(name);

        // THEN
        assertThat(result).isEqualTo("Hello, Bob");
    }

    @Test
    public void testGreetingWithNullNameThrowsException() {
        // GIVEN
        String name = null;

        // WHEN & THEN
        assertThrows(IllegalArgumentException.class, () -> client.greeting(name));
    }

    @Test
    public void testGreetingWithBlankNameThrowsException() {
        // GIVEN
        String name = "   ";

        // WHEN & THEN
        assertThrows(IllegalArgumentException.class, () -> client.greeting(name));
    }
}
