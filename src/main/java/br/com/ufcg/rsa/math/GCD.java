package br.com.ufcg.rsa.math;

public final class GCD {

	private GCD() {
	}

	public static int gcd(int a, int b) {
		while (b != 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		return a;
	}
}
