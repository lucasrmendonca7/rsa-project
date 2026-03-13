package br.com.ufcg.rsa.math;

import java.math.BigInteger;

/**
 * Utility class that provides methods for calculating the
 * Greatest Common Divisor (GCD) between two numbers.
 * <p>
 * The GCD is calculated using the Euclidean Algorithm.
 */
public final class GCD {

	/**
	 * Private constructor to prevent instantiation of this utility class.
	 */
	private GCD() {}

	/**
	 * Computes the greatest common divisor (GCD) of two non-negative {@link BigInteger} values
	 * using the Euclidean Algorithm.
	 *
	 * @param a the first value (must be non-null and non-negative)
	 * @param b the second value (must be non-null and non-negative)
	 * @return the greatest common divisor of {@code a} and {@code b}
	 * @throws NullPointerException if {@code a} or {@code b} is {@code null}
	 * @throws ArithmeticException if {@code a} or {@code b} is negative
	 */
	public static BigInteger gcd(BigInteger a, BigInteger b)
			throws NullPointerException, ArithmeticException {

		if (a == null || b == null)
			throw new NullPointerException("Values cannot be null");

		if (a.signum() < 0 || b.signum() < 0)
			throw new ArithmeticException("Values cannot be negative");

		while (!b.equals(BigInteger.ZERO)) {
			BigInteger temp = b;
			b = a.remainder(b);
			a = temp;
		}

		return a;
	}
}