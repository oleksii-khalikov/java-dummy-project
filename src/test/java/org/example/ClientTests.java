package org.example;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class ClientTests {

    private Service service;
    private Client client;

    @BeforeEach
    void setUp() {
        service = Mockito.mock(Service.class);
        client = new Client(service);
    }

    @Test
    void greeting_ValidName_ReturnsGreeting() {
        // GIVEN
        Mockito.when(service.isEven(5)).thenReturn(false);
        // WHEN
        String result = client.greeting("John"); 
        // THEN
        assertThat(result).isEqualTo("Hello, John!");
    }

    @Test
    void greeting_ValidName_ReturnsGreeting() {
        // GIVEN
        Mockito.when(service.isEven(5)).thenReturn(false);
        // WHEN
        String result = client.greeting("Jane"); 
        // THEN
        assertThat(result).isEqualTo("Hello, Jane!");
    }

    @Test
    void greeting_ValidName_ReturnsGreeting() {
        // GIVEN
        Mockito.when(service.isEven(5)).thenReturn(false);
        // WHEN
        String result = client.greeting("Peter"); 
        // THEN
        assertThat(result).isEqualTo("Hello, Peter!");
    }

    @Test
    void greeting_ValidName_ReturnsGreeting() {
        // GIVEN
        Mockito.when(service.isEven(5)).thenReturn(false);
        // WHEN
        String result = client.greeting("Mary"); 
        // THEN
        assertThat(result).isEqualTo("Hello, Mary!");
    }

}