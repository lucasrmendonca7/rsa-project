package br.com.ufcg.rsa;

import br.com.ufcg.rsa.crypto.DecryptorRSA;
import br.com.ufcg.rsa.crypto.EncryptorRSA;
import br.com.ufcg.rsa.crypto.KeyGeneratorRSA;
import br.com.ufcg.rsa.model.KeyPairRSA;
import br.com.ufcg.rsa.model.PublicKey;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        KeyPairRSA keys = KeyGeneratorRSA.generateRSAPair(1024);
        String msg = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.ised in";
        BigInteger cipherText = EncryptorRSA.encrypt(msg, keys.getPublicKey());

        System.out.println(cipherText);

        msg = DecryptorRSA.decrypt(cipherText, keys);

        System.out.println(msg);

    }
}
