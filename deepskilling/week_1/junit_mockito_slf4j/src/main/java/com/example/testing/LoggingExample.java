package com.example.testing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public int divide(int firstNumber, int secondNumber) {
        logger.info("Dividing {} by {}", firstNumber, secondNumber);
        if (secondNumber == 0) {
            logger.error("Division failed because denominator is zero");
            throw new ArithmeticException("Cannot divide by zero");
        }
        int result = firstNumber / secondNumber;
        logger.debug("Division result is {}", result);
        return result;
    }

    public static void main(String[] args) {
        LoggingExample example = new LoggingExample();
        example.divide(10, 2);
    }
}
