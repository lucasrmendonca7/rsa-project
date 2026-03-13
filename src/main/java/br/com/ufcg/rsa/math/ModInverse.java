package br.com.ufcg.rsa.math;

import java.math.BigInteger;

/**
 * Utility class for modular arithmetic operations.
 */
public class ModInverse {

    /**
     * Private constructor to prevent instantiation.
     */
    private ModInverse() {}

    /**
     * Calculates the modular multiplicative inverse using the Extended Euclidean Algorithm.
     *
     * @param number The value to invert.
     * @param module The modulus.
     * @return The modular inverse in the range [0, module - 1].
     * @throws ArithmeticException If the inverse does not exist (GCD != 1).
     */
    public static BigInteger modInverse(BigInteger number, BigInteger module) {
        if (!GCD.gcd(number, module).equals(BigInteger.ONE)) {
            throw new ArithmeticException("Inverse does not exist: numbers are not coprime.");
        }

        BigInteger x0 = BigInteger.ZERO;
        BigInteger x1 = BigInteger.ONE;

        BigInteger a = number;
        BigInteger m = module;

        while (a.compareTo(BigInteger.ONE) > 0) {
            BigInteger[] dr = a.divideAndRemainder(m);
            BigInteger q = dr[0];
            BigInteger r = dr[1];

            a = m;
            m = r;

            BigInteger tempX = x0;
            x0 = x1.subtract(q.multiply(x0));
            x1 = tempX;
        }

        if (x1.compareTo(BigInteger.ZERO) < 0) {
            x1 = x1.add(module);
        }

        return x1;
    }
}