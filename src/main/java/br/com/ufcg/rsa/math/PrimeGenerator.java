package br.com.ufcg.rsa.math;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Utility class responsible for generating prime numbers for RSA operations.
 *
 * <p>This class uses {@link BigInteger#probablePrime(int, java.util.Random)} to
 * generate prime numbers with a high probability of being truly prime.
 * The randomness is provided by {@link SecureRandom}, which is suitable
 * for cryptographic purposes.</p>
 */
public class PrimeGenerator {

    /**
     * Generates a random prime number with the specified bit length.
     *
     * <p>The generated value is a probable prime, meaning it has a very
     * high probability of being prime according to probabilistic primality
     * tests used internally by {@link BigInteger}.</p>
     *
     * @param bitLength the desired bit length of the generated prime number
     * @return a probable prime number with the specified bit length
     */
    public static BigInteger generatePrime(int bitLength) {
        return BigInteger.probablePrime(bitLength, new SecureRandom());

    }
}