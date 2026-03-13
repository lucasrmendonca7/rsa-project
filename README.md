# Project Overview

This project presents a Java implementation of the RSA cryptographic algorithm, including public and private key generation, message encryption, and message decryption. The implementation is intended for educational purposes, focusing on the understanding of asymmetric cryptography and fundamental concepts of information security.

---

## Algorithmic Components

### RSA Key Generation

The key generation process follows the standard RSA procedure, including the selection of large prime numbers, computation of the modulus, Euler’s totient, and the derivation of public and private exponents.

### Greatest Common Divisor (GCD)

The computation of the greatest common divisor (GCD) is implemented using the **Euclidean algorithm**. This method is employed during key generation to ensure that the public exponent $e$ is coprime with Euler’s totient $\phi(n)$, which is a requirement for the existence of the modular inverse.

### Modular Multiplicative Inverse

The project utilizes the **Extended Euclidean Algorithm** to calculate the modular multiplicative inverse. This is a critical step in deriving the private exponent $d$ from the public exponent $e$ and the totient $\phi(n)$, such that:

$$e \cdot d \equiv 1 \pmod{\phi(n)}$$

---

## Educational Objectives

The main objectives of this project are:

- To understand the mathematical foundations of the RSA cryptosystem
- To explore number-theoretic algorithms used in cryptography, specifically the Euclidean and Extended Euclidean algorithms
- To analyze the deterministic relationship between public and private keys in asymmetric systems

---

## References

- [Euclidean Algorithm — Stanford Cryptography Notes](https://crypto.stanford.edu/pbc/notes/numbertheory/euclid.html)
- [Extended Euclidean Algorithm — Wikipedia](https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm)