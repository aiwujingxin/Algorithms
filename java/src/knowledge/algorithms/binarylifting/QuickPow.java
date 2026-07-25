package knowledge.algorithms.binarylifting;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 快速幂 (Binary Exponentiation)
 * <适用场景>
 * 倍增思想的最小原型：把指数按二进制拆分，O(log n) 求幂、模幂、矩阵幂。
 * <核心>
 * a^n = 累乘 a^(2^i)（仅当指数第 i 位为 1）；每轮把底数自乘平方，指数右移一位。
 * @see leetcode.problems.LeetCode50 Pow(x, n)
 */
public class QuickPow {

    /**
     * 整数快速幂 a^n（不取模，可能溢出，供理解用）。
     */
    public static long pow(long a, long n) {
        long result = 1;
        while (n > 0) {
            if ((n & 1) == 1) result *= a;
            a *= a;
            n >>= 1;
        }
        return result;
    }

    /**
     * 模快速幂 a^n mod p。
     */
    public static long powMod(long a, long n, long p) {
        long result = 1 % p;
        a %= p;
        while (n > 0) {
            if ((n & 1) == 1) result = result * a % p;
            a = a * a % p;
            n >>= 1;
        }
        return result;
    }

    /**
     * 矩阵快速幂 base^n mod p，用于线性递推（斐波那契等）加速。
     */
    public static long[][] matrixPow(long[][] base, long n, long p) {
        int size = base.length;
        long[][] result = new long[size][size];
        for (int i = 0; i < size; i++) result[i][i] = 1;
        while (n > 0) {
            if ((n & 1) == 1) result = multiply(result, base, p);
            base = multiply(base, base, p);
            n >>= 1;
        }
        return result;
    }

    private static long[][] multiply(long[][] a, long[][] b, long p) {
        int size = a.length;
        long[][] c = new long[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (a[i][k] == 0) continue;
                for (int j = 0; j < size; j++) {
                    c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % p;
                }
            }
        }
        return c;
    }
}
