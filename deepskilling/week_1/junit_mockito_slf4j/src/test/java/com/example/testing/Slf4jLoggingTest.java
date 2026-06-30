package com.example.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Slf4jLoggingTest {
    private final LoggingExample loggingExample = new LoggingExample();

    @Test
    void testLoggedMethodSuccess() {
        assertEquals(5, loggingExample.divide(10, 2));
    }

    @Test
    void testLoggedMethodFailure() {
        assertThrows(ArithmeticException.class, () -> loggingExample.divide(10, 0));
    }
}
