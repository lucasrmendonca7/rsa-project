package br.com.ufcg.rsa.math;

import java.math.BigInteger;
import java.security.SecureRandom;

public class PrimeGenerator {

    public static BigInteger generatePrime(int bitLength) {
        return BigInteger.probablePrime(bitLength, new SecureRandom());
    }
}