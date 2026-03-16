package br.com.ufcg.rsa.model;

/**
 * Represents an RSA key pair composed of a public key and a private key.
 *
 * <p>This class is a simple data holder used to group both keys generated
 * during the RSA key generation process.
 *
 * <p>The public key is used for encryption, while the private key is used
 * for decryption.
 */
public class KeyPairRSA {
    private final PublicKey publicKey;
    private final PrivateKey privateKey;

    /**
     * Creates a new RSA key pair.
     *
     * @param publicKey the RSA public key
     * @param privateKey the RSA private key
     */
    public KeyPairRSA(PublicKey publicKey, PrivateKey privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    /**
     * Returns the public key of the pair.
     *
     * @return the RSA public key
     */
    public PublicKey getPublicKey() {
        return publicKey;
    }

    /**
     * Returns the private key of the pair.
     *
     * @return the RSA private key
     */
    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    /**
     * Returns a string representation of the key pair.
     * Only public key information is displayed.
     *
     * @return formatted string with public key information
     */
    @Override
    public String toString() {
        return "RSA KeyPair\n" +
                "Public Key (n): " + publicKey.getN() + "\n" +
                "Public Exp (e): " + publicKey.getLambda();
    }
}