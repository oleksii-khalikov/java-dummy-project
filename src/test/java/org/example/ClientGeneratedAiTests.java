package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;

@Test
    void greeting_EvenLengthName_ReturnsUpperCaseGreeting() {
        // GIVEN
        String name = "Alice";
        // WHEN
        String greeting = client.greeting(name);
        // THEN
        assertThat(greeting).isEqualTo("HELLO, ALICE");
    }

    @Test
    void greeting_OddLengthName_ReturnsLowerCaseGreeting() {
        // GIVEN
        String name = "Bob";
        // WHEN
        String greeting = client.greeting(name);
        // THEN
        assertThat(greeting).isEqualTo("Hello, Bob");
    }
