package br.com.ufcg.rsa;

import br.com.ufcg.rsa.crypto.DecryptorRSA;
import br.com.ufcg.rsa.crypto.EncryptorRSA;
import br.com.ufcg.rsa.crypto.KeyGeneratorRSA;
import br.com.ufcg.rsa.model.KeyPairRSA;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        KeyPairRSA keys = KeyGeneratorRSA.generateRSAPair(1024);
        String msg = "Enquanto a escada desliza no muro e o tempo não para seu fluxo seguro, " +
                "cada variação se amarra em segredo pela regra da cadeia que vence o medo, " +
                "revelando que a vida em sua pressa medida é uma taxa ligada em outra contida.";
        List<BigInteger> cipherText = EncryptorRSA.encrypt(msg, keys.getPublicKey());

        System.out.println(cipherText.toString());

        msg = DecryptorRSA.decrypt(cipherText, keys);

        System.out.println(msg);

    }
}
