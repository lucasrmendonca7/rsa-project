package br.com.ufcg.rsa.crypto;

import br.com.ufcg.rsa.math.FastModularExponentiation;
import br.com.ufcg.rsa.math.ModInverse;
import br.com.ufcg.rsa.model.PrivateKey;
import br.com.ufcg.rsa.model.PublicKey;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/**
 * Provides functionality for encrypting messages using the RSA algorithm.
 * This class handles message conversion, blocking, and modular exponentiation.
 */
public class EncryptorRSA {

    /**
     * Encrypts a plain text message using the provided public key.
     * * @param message The text to be encrypted.
     * @param publicKey The RSA public key containing the modulus (n) and exponent (lambda/e).
     * @return A list of BigInteger blocks representing the encrypted message.
     */
    public static List<BigInteger> encrypt(String message, PublicKey publicKey) {
        BigInteger m = stringToBigInteger(message);
        BigInteger lambda = publicKey.getLambda();
        BigInteger n = publicKey.getN();

        BigInteger c = FastModularExponentiation.fastModExp(m, lambda, n);

        if (m.compareTo(publicKey.getN()) >= 0) {
            throw new IllegalArgumentException("Mensagem muito grande para o tamanho da chave. Divida em blocos.");
        }

        return c;
    }

    /**
     * Converts a String message into a BigInteger representation using UTF-8 encoding.
     * * @param message The text to convert.
     * @return A positive BigInteger representing the byte array of the message.
     */
    private static BigInteger stringToBigInteger(String message) {

        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);

        return new BigInteger(1, bytes);
    }

}
