# 1. Project Title

**RSA Cryptosystem – Educational Java Implementation**

---

## 2. Overview

This repository contains an educational implementation of the **RSA public-key cryptosystem** in Java.  
It implements the full RSA cycle: key generation, encryption, and decryption using modular arithmetic and fast modular exponentiation.

This project was developed for the course **Mathematics for Computer Science II** (Fundamentos de Matemática para Ciência da Computação II), taught by **Professor Tiago Massoni** at the **Federal University of Campina Grande (UFCG)**.

**Authors (Students):**
- Lucas Mendonça
- Lucas Souto
- Kaique José de Souza
- Luís Guilherme Brito
- Luís Henrique Rêgo

> **Disclaimer:** This project is intended for learning purposes. It does **not** implement modern padding schemes (e.g., OAEP) and should **not** be used in production or to protect real sensitive data.

---

## 3. Features

- **RSA Key Generation**
  - Random probable primes `p` and `q`
  - Modulus `n = p * q`
  - Euler’s totient `φ(n) = (p − 1)(q − 1)`
  - Public exponent `e = 65537`
  - Private exponent `d = e⁻¹ (mod φ(n))`

- **Encryption / Decryption**
  - Encrypts a UTF-8 message using the public key
  - Decrypts ciphertext blocks using the private key
  - Uses **Fast Modular Exponentiation** (Exponentiation by Squaring)

- **Math Utilities**
  - Greatest Common Divisor (Euclidean algorithm)
  - Modular inverse (Extended Euclidean algorithm)
  - Prime generation using `BigInteger.probablePrime` + `SecureRandom`

---

## 4. Mathematical Concepts Behind RSA

RSA is built on core number theory concepts:

- **Prime numbers:** two large primes `p` and `q`
- **Modular arithmetic:** computations are performed modulo `n = p*q`
- **Euler’s totient function:**  
  `φ(n) = (p − 1)(q − 1)` for `n = p*q` with primes `p` and `q`
- **Coprimality and GCD:** RSA requires `gcd(e, φ(n)) = 1`
- **Modular multiplicative inverse:** `d` is defined as the inverse of `e` modulo `φ(n)`:
  - `d ≡ e⁻¹ (mod φ(n))`
- **Modular exponentiation:** encryption and decryption rely on exponentiation modulo `n`:
  - Efficiently computed using exponentiation by squaring

---

## 5. Project Structure

Main packages:

- `br.com.ufcg.rsa.crypto`
  - `KeyGeneratorRSA`: generates RSA key pairs
  - `EncryptorRSA`: encrypts messages using a `PublicKey`
  - `DecryptorRSA`: decrypts ciphertext blocks using a `KeyPairRSA`

- `br.com.ufcg.rsa.math`
  - `FastModularExponentiation`: exponentiation by squaring
  - `GCD`: Euclidean algorithm
  - `ModInverse`: extended Euclidean algorithm
  - `PrimeGenerator`: probable prime generation with `SecureRandom`

- `br.com.ufcg.rsa.model`
  - `PublicKey`: stores `n` and uses fixed public exponent `e = 65537`
  - `PrivateKey`: stores private exponent `d`
  - `KeyPairRSA`: stores `PublicKey` + `PrivateKey`

---

## 6. How the RSA Algorithm Works (short explanation)

1. **Generate keys**
   - Choose primes `p` and `q`
   - Compute `n = p*q` and `φ(n) = (p − 1)(q − 1)`
   - Choose `e` (here, `65537`) such that `gcd(e, φ(n)) = 1`
   - Compute `d = e⁻¹ mod φ(n)`

2. **Encrypt**
   - Convert message to an integer `m` (UTF-8 → bytes → `BigInteger`)
   - Split into blocks smaller than `n`
   - For each block: `c = m^e mod n`

3. **Decrypt**
   - For each ciphertext block: `m = c^d mod n`
   - Rebuild original message from decrypted blocks and decode to UTF-8

---

## 7. Example Usage

```java
import br.com.ufcg.rsa.crypto.KeyGeneratorRSA;
import br.com.ufcg.rsa.crypto.EncryptorRSA;
import br.com.ufcg.rsa.crypto.DecryptorRSA;
import br.com.ufcg.rsa.model.KeyPairRSA;

import java.math.BigInteger;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        KeyPairRSA keyPair = KeyGeneratorRSA.generateRSAPair(1024);

        String message = "Hello RSA!";
        List<BigInteger> cipher = EncryptorRSA.encrypt(message, keyPair.getPublicKey());

        String decrypted = DecryptorRSA.decrypt(cipher, keyPair);
        System.out.println(decrypted);
    }
}
```

---

### 8. Performance Experiment (Time Analysis)

We performed simple execution benchmarks to measure the temporal cost of the RSA algorithm stages. Timing was collected using `System.nanoTime()` (converted to milliseconds) representing the average of 30 executions for each key size.

| Bits | KeyGen (ms) | Encrypt (ms) | Decrypt (ms) |
|-----:|------------:|-------------:|-------------:|
|  256 |        9.16 |         0.89 |         3.22 |
|  512 |        6.22 |         0.43 |         3.82 |
| 1024 |       10.71 |         0.31 |         5.58 |
| 2048 |       60.83 |         0.36 |        35.47 |

#### Key Observations

* **Key Generation Scaling:** Generating 2048-bit keys takes significantly longer (~60ms) than 1024-bit keys (~10ms). This is expected, as finding and validating much larger prime numbers requires more computational effort.
* **Encryption vs. Decryption:** Encryption is nearly instantaneous across all sizes (~0.3ms) because the public key exponent (`e`) is typically a small number. Decryption takes longer (up to ~35ms) because the private key (`d`) is massive, requiring heavier modular arithmetic.
* **JVM Warmup:** The slight delay at 256 bits compared to 512 bits is not a mathematical anomaly, but rather a standard Java behavior. It reflects the JVM's Just-In-Time (JIT) compiler "warmup" phase during the first few executions.

## 9. How to Run the Project

This project uses **Maven** for dependency and build management. You can run it easily through an IDE or via the command line.

### Option A: Run in an IDE (Recommended)
1. Open the project in **IntelliJ IDEA**, **Eclipse**, or **VS Code**.
2. Let the IDE load the `pom.xml` and resolve any configurations.
3. Locate your main class (e.g., `Example.java`) and run it directly.

### Option B: Run via Maven (Command Line)
From the project root directory (where the `pom.xml` is located), use the following commands:

```bash
# Clean and compile the project
mvn clean install

# Execute the main class (replace the path if your main class is named differently)
mvn exec:java -Dexec.mainClass="br.com.ufcg.rsa.Example"
```
---

## 10. Technologies Used

- **Java**
- `java.math.BigInteger` for large integer arithmetic
- `java.security.SecureRandom` for prime generation randomness
- UTF-8 encoding via `java.nio.charset.StandardCharsets`
