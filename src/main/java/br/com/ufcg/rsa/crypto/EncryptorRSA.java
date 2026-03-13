package br.com.ufcg.rsa.crypto;

import br.com.ufcg.rsa.math.FastModularExponentiation;
import br.com.ufcg.rsa.math.ModInverse;
import br.com.ufcg.rsa.model.PrivateKey;
import br.com.ufcg.rsa.model.PublicKey;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class EncryptorRSA {

    public static BigInteger encrypt(String message, PublicKey publicKey) {
        BigInteger m = stringToBigInteger(message);
        BigInteger lambda = publicKey.getLambda();
        BigInteger n = publicKey.getN();

        BigInteger c = FastModularExponentiation.fastModExp(m, lambda, n);

        if (m.compareTo(publicKey.getN()) >= 0) {
            throw new IllegalArgumentException("Mensagem muito grande para o tamanho da chave. Divida em blocos.");
        }

        return c;
    }

    private static BigInteger stringToBigInteger(String message) {

        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);

        return new BigInteger(1, bytes);
    }
}
