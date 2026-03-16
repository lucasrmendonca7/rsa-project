package br.com.ufcg.rsa.model;

import java.math.BigInteger;

/**
 * Represents the private key used in the RSA cryptographic system.
 *
 * <p>The private key contains the private exponent {@code d}, which is used
 * together with the modulus {@code n} to decrypt messages or generate
 * digital signatures.
 *
 * <p>This key must be kept secret to ensure the security of the RSA algorithm.
 */
public class PrivateKey {
    private final BigInteger d;

    /**
     * Creates a new RSA private key.
     *
     * @param d the private exponent used for decryption
     */
    public PrivateKey(BigInteger d) {
        this.d = d;
    }

    /**
     * Returns the private exponent {@code d}.
     *
     * @return the private exponent
     */
    public BigInteger getD() {
        return d;
    }
}