package br.com.ufcg.rsa.math;

import java.math.BigInteger;

public class FastModularExponentiation {

    private FastModularExponentiation() {}

    public static BigInteger fastModExp(BigInteger base, BigInteger exp, BigInteger module) {
        return base.modPow(exp, module);
    }
}
