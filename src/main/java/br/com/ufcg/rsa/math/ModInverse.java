package br.com.ufcg.rsa.math;

/**
 * Utility class for modular arithmetic operations.
 */
public class ModInverse {

    /**
     * Private constructor to prevent instantiation.
     */
    private ModInverse() {}

    /**
     * Calculates the modular multiplicative inverse of a number such that (number * x) % mod == 1.
     * This implementation uses the Extended Euclidean Algorithm.
     *
     * @param number The value to invert.
     * @param mod    The modulus.
     * @return The modular inverse in the range [0, mod - 1].
     * @throws ArithmeticException If the number and mod are not coprime (GCD != 1).
     */
    public static int modInverse(int number, int mod) {
        if (GCD.gcd(number, mod) != 1) {
            throw new ArithmeticException("Inverse does not exist: numbers are not coprime.");
        }

        int xCurrent = 0;
        int xNext = 1;

        int currentDividend = number;
        int currentDivisor = mod;

        while (currentDividend > 1) {
            int quotient = currentDividend / currentDivisor;
            int remainder = currentDividend % currentDivisor;

            currentDividend = currentDivisor;
            currentDivisor = remainder;

            int tempX = xCurrent;

            xCurrent = xNext - (quotient * xCurrent);
            xNext = tempX;
        }

        if (xNext < 0) {
            xNext += mod;
        }

        return xNext;
    }
}