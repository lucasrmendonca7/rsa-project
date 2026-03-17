package br.com.ufcg.rsa;

import br.com.ufcg.rsa.crypto.DecryptorRSA;
import br.com.ufcg.rsa.crypto.EncryptorRSA;
import br.com.ufcg.rsa.crypto.KeyGeneratorRSA;
import br.com.ufcg.rsa.model.KeyPairRSA;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final int BIT_LENGTH = 1024;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            banner();

            String message = readMessage(scanner);

            KeyPairRSA keyPair = generateKeys();

            List<BigInteger> encrypted = encryptMessage(message, keyPair);

            printEncryptedMessage(encrypted);

            String decrypted = decryptMessage(encrypted, keyPair);

            printDecryptedMessage(decrypted);
        }
    }

    private static void banner() {
        System.out.println(
                "\n" + " ██████╗ ███████╗ █████╗ \n" +
                        " ██╔══██╗██╔════╝██╔══██╗\n" +
                        " ██████╔╝███████╗███████║\n" +
                        " ██╔══██╗╚════██║██╔══██║\n" +
                        " ██║  ██║███████║██║  ██║\n" +
                        " ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝\n" +
                        "\n" +
                        "   RSA Encryption System\n" +
                        "--------------------------------\n" +
                        "Secure message encryption demo\n" +
                        "Developed at UFCG\n"
        );
    }

    private static String readMessage(Scanner scanner) {
        System.out.println("=== RSA Encryption ===");
        System.out.print("Enter your message: ");
        return scanner.nextLine();
    }

    private static KeyPairRSA generateKeys() {
        System.out.println("\nGenerating RSA keys...");
        return KeyGeneratorRSA.generateRSAPair(BIT_LENGTH);
    }

    private static List<BigInteger> encryptMessage(String message, KeyPairRSA keyPair) {
        System.out.println("\nEncrypting message...");
        return EncryptorRSA.encrypt(message, keyPair.getPublicKey());
    }

    private static void printEncryptedMessage(List<BigInteger> encrypted) {
        System.out.println("\nEncrypted message:");
        System.out.println(encrypted);
    }

    private static String decryptMessage(List<BigInteger> encrypted, KeyPairRSA keyPair) {
        System.out.println("\nDecrypting message...");
        return DecryptorRSA.decrypt(encrypted, keyPair);
    }

    private static void printDecryptedMessage(String decrypted) {
        System.out.println("\nRecovered original message:");
        System.out.println(decrypted);
    }
}