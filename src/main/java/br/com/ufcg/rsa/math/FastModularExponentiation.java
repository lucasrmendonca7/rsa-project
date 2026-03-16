package br.com.ufcg.rsa.math;

import java.math.BigInteger;

/**
 * Utility class that provides an implementation of the
 * Fast Modular Exponentiation algorithm (also known as
 * Exponentiation by Squaring).
 *
 * <p>This algorithm efficiently computes:
 * <pre>
 *     base^exp mod mod
 * </pre>
 *
 * instead of computing base^exp directly, which would be
 * computationally expensive for large numbers.
 *
 * <p>This method is widely used in cryptographic algorithms,
 * including RSA encryption and decryption.
 */
public class FastModularExponentiation {

    /**
     * Private constructor to prevent instantiation,
     * since this is a utility class.
     */
    private FastModularExponentiation() {
    }

    /**
     * Computes modular exponentiation using the fast exponentiation algorithm.
     *
     * <p>The algorithm repeatedly squares the base and reduces the exponent
     * by half, multiplying the result whenever the exponent is odd.
     *
     * <p>Time complexity: O(log exp)
     *
     * @param base the base of the exponentiation
     * @param exp the exponent
     * @param mod the modulus
     * @return the result of (base^exp) mod mod
     */
    public static BigInteger fastModExp(BigInteger base, BigInteger exp, BigInteger mod) {

        BigInteger result = BigInteger.ONE;
        BigInteger zero = BigInteger.ZERO;
        BigInteger one = BigInteger.ONE;
        BigInteger two = BigInteger.valueOf(2);

        base = base.mod(mod);

        while (exp.compareTo(zero) > 0) {

            if (exp.mod(two).equals(one)) {
                result = result.multiply(base).mod(mod);
            }

            base = base.multiply(base).mod(mod);
            exp = exp.divide(two);

            }

        return result;
    }
}