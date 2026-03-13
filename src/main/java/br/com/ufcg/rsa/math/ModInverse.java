package br.com.ufcg.rsa.math;

import java.math.BigInteger;

/**
 * Utility class that provides operations related to modular arithmetic.
 * <p>
 * This class implements the computation of the modular multiplicative inverse
 * using the Extended Euclidean Algorithm.
 * <p>
 * The modular inverse of a number {@code a} modulo {@code m} is a number {@code x}
 * such that:
 *
 * <pre>
 * (a * x) mod m = 1
 * </pre>
 *
 * The modular inverse exists only when {@code gcd(a, m) = 1}, meaning that
 * the numbers are coprime.
 *
 * <p>This operation is fundamental in cryptographic algorithms such as RSA,
 * where the private key is computed as the modular inverse of the public
 * exponent modulo φ(n).
 */
public final class ModInverse {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private ModInverse() {}

    /**
     * Computes the modular multiplicative inverse of a number with respect
     * to a given modulus using the Extended Euclidean Algorithm.
     *
     * <p>The result {@code x} satisfies the following property:
     *
     * <pre>
     * (number * x) mod module = 1
     * </pre>
     *
     * The inverse exists only if {@code number} and {@code module} are coprime,
     * i.e., {@code gcd(number, module) = 1}.
     *
     * @param number the value whose modular inverse will be calculated
     * @param module the modulus that defines the modular arithmetic system
     * @return the modular inverse of {@code number} in the range {@code [0, module - 1]}
     * @throws ArithmeticException if the inverse does not exist because
     *         {@code number} and {@code module} are not coprime
     * @see GCD#gcd(BigInteger, BigInteger)
     */
    public static BigInteger modInverse(BigInteger number, BigInteger module) throws ArithmeticException {
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