package com.example.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JUnitAdvancedTest {
    private Calculator calculator;
    private StringHelper stringHelper;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        stringHelper = new StringHelper();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
        stringHelper = null;
    }

    @ParameterizedTest
    @CsvSource({
            "2,3,5",
            "10,20,30",
            "-4,6,2"
    })
    void testAdditionWithDifferentValues(int firstNumber, int secondNumber, int expectedResult) {
        assertEquals(expectedResult, calculator.add(firstNumber, secondNumber));
    }

    @Test
    @DisplayName("Grouped assertions for string helper")
    void testStringHelper() {
        assertAll(
                () -> assertEquals("avaJ", stringHelper.reverse("Java")),
                () -> assertTrue(stringHelper.isPalindrome("madam")),
                () -> assertFalse(stringHelper.isPalindrome("testing"))
        );
    }

    @Test
    void testWithTimeoutAssertion() {
        assertTimeout(Duration.ofMillis(100), () -> calculator.multiply(12, 12));
    }

    @Test
    @Timeout(1)
    void testTimeoutAnnotation() {
        assertEquals(25, calculator.add(20, 5));
    }
}
