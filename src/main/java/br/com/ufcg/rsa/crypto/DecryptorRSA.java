package br.com.ufcg.rsa.crypto;

import br.com.ufcg.rsa.math.FastModularExponentiation;
import br.com.ufcg.rsa.model.KeyPairRSA;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class DecryptorRSA {

    public static String decrypt(BigInteger cipherText, KeyPairRSA keyPair) {
        BigInteger d = keyPair.getPrivateKey().getD();
        BigInteger n = keyPair.getPublicKey().getN();
        BigInteger decoded = FastModularExponentiation.fastModExp(cipherText, d, n);
        return bigIntegerToString(decoded);
    }

    public static String bigIntegerToString(BigInteger number) {
        byte[] bytes = number.toByteArray();

        return new String(bytes, StandardCharsets.UTF_8);
    }
}
