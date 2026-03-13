package br.com.ufcg.rsa.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * Unit tests for the ModInverse utility class.
 */
public class ModInverseTest {

    /**
     * Tests if the modular inverse is calculated correctly
     * for small coprime numbers.
     * Example:
     * 3 * 4 mod 11 = 1
     */
    @Test
    void shouldReturnCorrectInverseForSmallNumbers() {
        BigInteger number = new BigInteger("3");
        BigInteger modulus = new BigInteger("11");

        BigInteger result = ModInverse.modInverse(number, modulus);

        assertEquals(new BigInteger("4"), result);
    }

    /**
     * Tests another known modular inverse example.
     * Example:
     * 10 * 12 mod 17 = 1
     */
    @Test
    void shouldReturnCorrectInverseForAnotherValidPair() {
        BigInteger number = new BigInteger("10");
        BigInteger modulus = new BigInteger("17");

        BigInteger result = ModInverse.modInverse(number, modulus);

        assertEquals(new BigInteger("12"), result);
    }

    /**
     * Tests if the algorithm works with larger numbers,
     */
    @Test
    void shouldHandleLargeNumbersCorrectly() {
        BigInteger number = new BigInteger("65537");
        BigInteger modulus = new BigInteger("3120");

        BigInteger result = ModInverse.modInverse(number, modulus);

        assertEquals(new BigInteger("2753"), result);
    }

    /**
     * Tests if the method throws an exception when
     * the modular inverse does not exist.
     * Example:
     * gcd(6, 12) != 1
     */
    @Test
    void shouldThrowExceptionWhenNumbersAreNotCoprime() {
        BigInteger number = new BigInteger("6");
        BigInteger modulus = new BigInteger("12");

        assertThrows(ArithmeticException.class,
                () -> ModInverse.modInverse(number, modulus));
    }

    /**
     * Tests if the returned value actually satisfies the modular inverse property:
     * (number * inverse) mod modulus = 1
     */
    @Test
    void shouldSatisfyModularInverseProperty() {
        BigInteger number = new BigInteger("7");
        BigInteger modulus = new BigInteger("40");

        BigInteger inverse = ModInverse.modInverse(number, modulus);

        BigInteger result = number.multiply(inverse).mod(modulus);

        assertEquals(BigInteger.ONE, result);
    }
}