package org.example;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ClientTests {

    private Service serviceMock;
    private Client client;

    @BeforeEach
    void setUp() {
        serviceMock = Mockito.mock(Service.class);
        client = new Client(serviceMock);
    }

    @Test
    void greeting_ValidName_ReturnsGreeting() {
        // GIVEN
        Mockito.when(serviceMock.isEven(5)).thenReturn(false);
        // WHEN
        String result = client.greeting("John"); 
        // THEN
        assertThat(result).isEqualTo("Hello, John!");
    }

    @Test
    void greeting_ValidName_ReturnsGreeting() {
        // GIVEN
        Mockito.when(serviceMock.isEven(5)).thenReturn(false);
        // WHEN
        String result = client.greeting("Jane"); 
        // THEN
        assertThat(result).isEqualTo("Hello, Jane!");
    }

    @Test
    void greeting_ValidName_ReturnsGreeting() {
        // GIVEN
        Mockito.when(serviceMock.isEven(5)).thenReturn(false);
        // WHEN
        String result = client.greeting("Peter"); 
        // THEN
        assertThat(result).isEqualTo("Hello, Peter!");
    }

    @Test
    void greeting_ValidName_ReturnsGreeting() {
        // GIVEN
        Mockito.when(serviceMock.isEven(5)).thenReturn(false);
        // WHEN
        String result = client.greeting("Mary"); 
        // THEN
        assertThat(result).isEqualTo("Hello, Mary!");
    }

}