## Project Overview

This project presents a Java implementation of the RSA cryptographic algorithm, including public and private key generation, message encryption, and message decryption. The implementation is intended for educational purposes, focusing on the understanding of asymmetric cryptography and fundamental concepts of information security.

---

## Algorithmic Components

### RSA Key Generation

The key generation process follows the standard RSA procedure, including the selection of large prime numbers, computation of the modulus, Euler’s totient, and the derivation of public and private exponents.

### Greatest Common Divisor (GCD)

The computation of the greatest common divisor (GCD) is implemented using the Euclidean algorithm. This method is employed during key generation to ensure that the public exponent is coprime with Euler’s totient, providing both correctness and computational efficiency.

### Primality Testing

Prime number generation relies on probabilistic primality testing. The Miller–Rabin primality test is used to efficiently determine whether large randomly generated numbers are prime, which is essential for practical RSA key generation.

---

## Educational Objectives

The main objectives of this project are:

- To understand the mathematical foundations of the RSA cryptosystem  
- To explore number-theoretic algorithms used in cryptography  
- To analyze the role of probabilistic algorithms in modern information security  

---

## References

- [Euclidean Algorithm — Stanford Cryptography Notes](https://crypto.stanford.edu/pbc/notes/numbertheory/euclid.html)

- [Miller–Rabin Primality Test — Stanford Cryptography Notes](https://crypto.stanford.edu/pbc/notes/numbertheory/millerrabin.html)

- [Miller–Rabin Primality Test — GeeksforGeeks](https://www.geeksforgeeks.org/dsa/primality-test-set-3-miller-rabin/)

- [Rabin–Miller Primality Test — Lecture Notes (University of San Diego)](https://home.sandiego.edu/~dhoffoss/teaching/cryptography/10-Rabin-Miller.pdf)