package br.com.ufcg.rsa.math;

import java.math.BigInteger;

/**
 * Utility class for calculating the Greatest Common Divisor (GCD).
 */
public final class GCD {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private GCD() {}

	/**
	 * Calculates the greatest common divisor of two BigInteger values using the Euclidean Algorithm.
	 *
	 * @param a The first BigInteger value.
	 * @param b The second BigInteger value.
	 * @return The greatest common divisor of a and b.
	 */
	public static BigInteger gcd(BigInteger a, BigInteger b) {
		while (!b.equals(BigInteger.ZERO)) {
			BigInteger temp = b;
			b = a.remainder(b);
			a = temp;
		}
		return a;
	}
}