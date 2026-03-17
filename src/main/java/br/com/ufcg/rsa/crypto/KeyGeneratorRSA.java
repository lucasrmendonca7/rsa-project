package br.com.ufcg.rsa.crypto;

import br.com.ufcg.rsa.math.ModInverse;
import br.com.ufcg.rsa.math.PrimeGenerator;
import br.com.ufcg.rsa.model.KeyPairRSA;
import br.com.ufcg.rsa.model.PublicKey;
import br.com.ufcg.rsa.model.PrivateKey;

import java.math.BigInteger;

/**
 * Utility class responsible for generating RSA key pairs.
 *
 * <p>This class implements the basic RSA key generation process:
 * <ol>
 *   <li>Generate two large prime numbers p and q</li>
 *   <li>Compute n = p * q</li>
 *   <li>Compute Euler's totient φ(n) = (p - 1)(q - 1)</li>
 *   <li>Select the public exponent (lambda)</li>
 *   <li>Compute the private exponent d such that d ≡ λ⁻¹ (mod φ(n))</li>
 * </ol>
 *
 * The generated keys are returned as a {@link KeyPairRSA} object
 * containing both the {@link PublicKey} and {@link PrivateKey}.
 */
public class KeyGeneratorRSA {

    /**
     * Generates an RSA key pair with the specified bit length.
     *
     * <p>The method generates two prime numbers of approximately half
     * the desired key size. These primes are used to compute the modulus
     * and the totient required for RSA key generation.</p>
     *
     * @param bitLength the desired size (in bits) of the RSA modulus
     * @return a {@link KeyPairRSA} containing the generated public and private keys
     */
    public static KeyPairRSA generateRSAPair(int bitLength) {
        int primeLength = bitLength / 2;
        BigInteger p = PrimeGenerator.generatePrime(primeLength);
        BigInteger q;

        do {
            q = PrimeGenerator.generatePrime(primeLength);
        } while (p.equals(q));

        BigInteger pMinus1 = p.subtract(BigInteger.ONE);
        BigInteger qMinus1 = q.subtract(BigInteger.ONE);
        BigInteger phi = pMinus1.multiply(qMinus1);

        PublicKey publicKey = new PublicKey(p, q);
        BigInteger lambda = publicKey.getLambda();

        BigInteger d = ModInverse.modInverse(lambda, phi);

        PrivateKey privateKey = new PrivateKey(d);
        return new KeyPairRSA(publicKey, privateKey);
    }
}