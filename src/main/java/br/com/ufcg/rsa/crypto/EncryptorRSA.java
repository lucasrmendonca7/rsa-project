package br.com.ufcg.rsa.crypto;

import br.com.ufcg.rsa.math.FastModularExponentiation;
import br.com.ufcg.rsa.math.ModInverse;
import br.com.ufcg.rsa.model.PrivateKey;
import br.com.ufcg.rsa.model.PublicKey;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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

        List<BigInteger> modList = new ArrayList<>();

        for (BigInteger bi : blockingMessage(m, publicKey)) {
            modList.add(FastModularExponentiation.fastModExp(bi, lambda, n));
        }
        return modList;
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

    /**
     * Divides a large BigInteger into smaller blocks to ensure each block
     * is numerically smaller than the public modulus (n).
     * * @param m The BigInteger representation of the full message.
     * @param publicKey The public key used to determine the maximum block size.
     * @return A list of BigInteger blocks safe for RSA encryption.
     */
    private static List<BigInteger> blockingMessage(BigInteger m, PublicKey publicKey){
        List<BigInteger> blockList = new ArrayList<>();
        String message = m.toString();

        int i = 0;
        int j = 0;
        String block = "";
        while (j < message.length()){

            block = message.substring(i, j+1);
            if (new BigInteger(block).compareTo(publicKey.getN()) >= 1) {
                blockList.add(new BigInteger(message.substring(i, j)));
                i = j;
            }
            j++;
        }
        if (i == 0) {
            blockList.add(m);
            return blockList;
        }
        blockList.add(new BigInteger(message.substring(i)));
        return blockList;
    }
}
