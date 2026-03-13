package br.com.ufcg.rsa.model;

public class KeyPairRSA {
    private final PublicKey publicKey;
    private final PrivateKey privateKey;

    public KeyPairRSA(PublicKey publicKey, PrivateKey privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    @Override
    public String toString() {
        return "RSA KeyPair\n" +
                "Public Key (n): " + publicKey.getN() + "\n" +
                "Public Exp (e): " + publicKey.getLambda();
    }
}