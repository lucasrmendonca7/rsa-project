package br.com.ufcg.rsa.model;

import java.math.BigInteger;

/**
 * Represents the public key used in the RSA cryptographic system.
 *
 * <p>The public key consists of the modulus {@code n} and the public exponent
 * {@code e}. The modulus is computed as the product of two large prime numbers
 * {@code p} and {@code q}.
 *
 * <p>The public exponent used here is the commonly adopted value 65537,
 * which is widely used in practical RSA implementations due to its balance
 * between security and computational efficiency.
 */
public class PublicKey {
    private final BigInteger n;
    private static final BigInteger LAMBDA = new BigInteger("65537");

    /**
     * Creates a new RSA public key.
     *
     * @param p the first prime number used to generate the modulus
     * @param q the second prime number used to generate the modulus
     */
    public PublicKey(BigInteger p, BigInteger q) {
        this.n = p.multiply(q);
    }

    /**
     * Returns the RSA modulus {@code n}.
     *
     * @return the modulus n = p * q
     */
    public BigInteger getN() {
        return n;
    }

    /**
     * Returns the public exponent used in RSA.
     *
     * @return the public exponent (commonly 65537)
     */
    public BigInteger getLambda() {
        return LAMBDA;
    }
}