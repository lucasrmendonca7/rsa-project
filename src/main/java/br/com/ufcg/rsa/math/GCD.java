package br.com.ufcg.rsa.math;

/**
 * Utility class for calculating the Greatest Common Divisor (GCD).
 */
public final class GCD {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private GCD() {}

	/**
	 * Calculates the greatest common divisor of two integers using the Euclidean Algorithm.
	 * The GCD is the largest positive integer that divides each of the integers
	 * without leaving a remainder.
	 *
	 * @param a The first integer.
	 * @param b The second integer.
	 * @return The greatest common divisor of a and b.
	 */
	public static int gcd(int a, int b) {
		while (b != 0) {
			int remainder = b;
			b = a % b;
			a = remainder;
		}
		return a;
	}
}