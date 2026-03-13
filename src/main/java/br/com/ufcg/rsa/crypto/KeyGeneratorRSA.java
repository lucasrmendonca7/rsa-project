package br.com.ufcg.rsa.crypto;

import br.com.ufcg.rsa.math.ModInverse;
import br.com.ufcg.rsa.math.PrimeGenerator;
import br.com.ufcg.rsa.model.KeyPairRSA;
import br.com.ufcg.rsa.model.PublicKey;
import br.com.ufcg.rsa.model.PrivateKey;

import java.math.BigInteger;

public class KeyGeneratorRSA {

    public static KeyPairRSA generateRSAPair(int bitLength) {
        int primeLength = bitLength / 2;
        BigInteger p = PrimeGenerator.generatePrime(primeLength);
        BigInteger q;

        do {
            q = PrimeGenerator.generatePrime(primeLength);
        } while (p.equals(q));

        BigInteger n = p.multiply(q);

        BigInteger pMinus1 = p.subtract(BigInteger.ONE);
        BigInteger qMinus1 = q.subtract(BigInteger.ONE);
        BigInteger phi = pMinus1.multiply(qMinus1);

        PublicKey pub = new PublicKey(n);
        BigInteger lambda = pub.getLambda();

        BigInteger d = ModInverse.modInverse(lambda, phi);

        PrivateKey privateKey = new PrivateKey(n, d);
        return new KeyPairRSA(pub, privateKey);
    }
}