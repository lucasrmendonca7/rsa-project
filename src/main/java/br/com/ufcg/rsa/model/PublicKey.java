package br.com.ufcg.rsa.model;

import java.math.BigInteger;

public class PublicKey {
    private final BigInteger n;
    private static final BigInteger LAMBDA = new BigInteger("65537");

    public PublicKey(BigInteger n) {
        this.n = n;
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getLambda() {
        return LAMBDA;
    }

    public static BigInteger calculateN(BigInteger p, BigInteger q) {
        return p.multiply(q);
    }
}