package br.com.ufcg.rsa.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * Unit tests for the GCD utility class.
 */
public class GcdTest {

    /**
     * Tests if the GCD of two coprime numbers returns 1.
     */
    @Test
    void shouldReturnOneWhenNumbersAreCoprime() {
        BigInteger a = new BigInteger("120");
        BigInteger b = new BigInteger("7");

        BigInteger result = GCD.gcd(a, b);

        assertEquals(BigInteger.ONE, result);
    }

    /**
     * Tests if the algorithm correctly finds the GCD of two numbers with a common divisor.
     */
    @Test
    void shouldReturnCorrectGcdForCommonDivisors() {
        BigInteger a = new BigInteger("48");
        BigInteger b = new BigInteger("18");

        BigInteger result = GCD.gcd(a, b);

        assertEquals(new BigInteger("6"), result);
    }

    /**
     * Tests the case where one of the numbers is zero.
     */
    @Test
    void shouldReturnOtherNumberWhenOneIsZero() {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = new BigInteger("15");

        BigInteger result = GCD.gcd(a, b);

        assertEquals(new BigInteger("15"), result);
    }

    /**
     * Tests if the method throws an exception when the first argument is null.
     */
    @Test
    void shouldThrowExceptionWhenFirstValueIsNull() {
        BigInteger b = new BigInteger("10");

        assertThrows(NullPointerException.class, () -> GCD.gcd(null, b));
    }

    /**
     * Tests if the method throws an exception when the second argument is null.
     */
    @Test
    void shouldThrowExceptionWhenSecondValueIsNull() {
        BigInteger a = new BigInteger("10");

        assertThrows(NullPointerException.class, () -> GCD.gcd(a, null));
    }

    /**
     * Tests if the method throws an exception when a negative value is passed.
     */
    @Test
    void shouldThrowExceptionWhenValuesAreNegative() {
        BigInteger a = new BigInteger("-10");
        BigInteger b = new BigInteger("5");

        assertThrows(ArithmeticException.class, () -> GCD.gcd(a, b));
    }

    /**
     * Tests the algorithm with large numbers, which is common in cryptographic algorithms like RSA.
     */
    @Test
    void shouldHandleLargeNumbersCorrectly() {
        BigInteger a = new BigInteger("123456789123456789123456789");
        BigInteger b = new BigInteger("987654321");

        BigInteger result = GCD.gcd(a, b);

        assertEquals(BigInteger.valueOf(9), result);
    }
}