package knowledge.mathematics.bigdecimal.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 大数取模与大指数快速幂 (模数为 long)
 * <适用场景>
 * 超长十进制整数对某个模数取余（判整除、哈希）、以及大指数模幂（费马小定理、组合数取模）。
 * <核心思想>
 * 取模按位 Horner：r = (r*10 + digit) % mod，全程只用 long。
 * 大指数模幂利用 a^(10q+d) = (a^q)^10 * a^d，从高位到低位逐位处理指数十进制串，
 * 无需把指数转成二进制，天然支持任意长度指数。
 */
public class BigNumberMod {

    /**
     * 大整数（十进制字符串，非负）对 mod 取余。
     */
    public static long mod(String number, long mod) {
        long remainder = 0;
        for (int i = 0; i < number.length(); i++) {
            remainder = (remainder * 10 + (number.charAt(i) - '0')) % mod;
        }
        return remainder;
    }

    /**
     * 计算 base^exponent mod modulus，exponent 为任意长度十进制字符串。
     */
    public static long modPow(long base, String exponent, long modulus) {
        base %= modulus;
        long result = 1 % modulus;
        for (int i = 0; i < exponent.length(); i++) {
            int digit = exponent.charAt(i) - '0';
            result = power(result, 10, modulus) * power(base, digit, modulus) % modulus;
        }
        return result;
    }

    // 快速幂，指数为 int
    private static long power(long base, int exponent, long modulus) {
        long result = 1 % modulus;
        base %= modulus;
        while (exponent > 0) {
            if ((exponent & 1) == 1) result = result * base % modulus;
            base = base * base % modulus;
            exponent >>= 1;
        }
        return result;
    }
}
