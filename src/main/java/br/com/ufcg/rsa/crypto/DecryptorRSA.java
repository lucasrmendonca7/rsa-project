package br.com.ufcg.rsa.crypto;

import br.com.ufcg.rsa.math.FastModularExponentiation;
import br.com.ufcg.rsa.model.KeyPairRSA;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/**
 * Provides functionality for decrypting RSA-encrypted data.
 * This class reverses the encryption process by processing cipher blocks
 * and reconstructing the original text.
 */
public class DecryptorRSA {

    /**
     * Decrypts a list of BigInteger blocks using the private key.
     * * @param cipherList The list of encrypted BigInteger blocks.
     * @param keyPair The RSA key pair containing the private key (d) and modulus (n).
     * @return The original plain text message.
     */
    public static String decrypt(List<BigInteger> cipherList, KeyPairRSA keyPair) {
        BigInteger d = keyPair.getPrivateKey().getD();
        BigInteger n = keyPair.getPublicKey().getN();
        BigInteger decoded = FastModularExponentiation.fastModExp(cipherText, d, n);
        return bigIntegerToString(decoded);
    }

    public static String bigIntegerToString(BigInteger number) {
        byte[] bytes = number.toByteArray();
    /**
     * Converts a concatenated decimal string back into its original UTF-8 string form.
     * * @param number A string representing the large BigInteger of the full message.
     * @return The decoded human-readable string.
     */
    public static String bigIntegerToDescriptedString(String number) {
        byte[] bytes = new BigInteger(number).toByteArray();

        return new String(bytes, StandardCharsets.UTF_8);
    }
}
