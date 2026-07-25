package knowledge.mathematics.algebra.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 扩展大步小步算法 (exBSGS)
 * <适用场景>
 * 求解 a^x ≡ b (mod p)，其中 a 与 p 不必互质——这是普通 BSGS 无法处理的情形。
 * <核心思想>
 * 反复提取 gcd(a, p)：令 d=gcd(a,p)，若 d 不整除 b 且 b≠1 则无解；
 * 否则把方程约减为 (a/d)·a^{x-1} ≡ b/d (mod p/d)，累计约减次数 k。
 * 当 a 与剩余模数互质后，转化为标准 BSGS 求 a^y ≡ b'·inv(A) (mod p')，答案为 y+k。
 */
public class ExBSGS {

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static long[] exgcd(long a, long b) {
        if (b == 0) return new long[]{a, 1, 0};
        long[] r = exgcd(b, a % b);
        return new long[]{r[0], r[2], r[1] - (a / b) * r[2]};
    }

    // 标准 BSGS：求 a^x ≡ b (mod p)，要求 gcd(a,p)=1
    private static long bsgs(long a, long b, long p) {
        a %= p;
        b %= p;
        long m = (long) Math.ceil(Math.sqrt(p));
        Map<Long, Long> map = new HashMap<>();
        long cur = b % p;
        for (long j = 0; j < m; j++) {
            map.put(cur, j);
            cur = cur * a % p;
        }
        long factor = 1;
        for (long i = 0; i < m; i++) factor = factor * a % p;
        cur = 1;
        for (long i = 1; i <= m; i++) {
            cur = cur * factor % p;
            Long j = map.get(cur);
            if (j != null) return i * m - j;
        }
        return -1;
    }

    /**
     * 求 a^x ≡ b (mod p) 的最小非负解，a 与 p 可不互质；无解返回 -1。
     */
    public static long exBsgs(long a, long b, long p) {
        a %= p;
        b %= p;
        if (b == 1 || p == 1) return 0;
        long k = 0, coefficient = 1;
        long d;
        while ((d = gcd(a, p)) > 1) {
            if (b % d != 0) return -1;
            b /= d;
            p /= d;
            coefficient = coefficient * (a / d) % p;
            k++;
            if (coefficient == b) return k;
        }
        // coefficient · a^y ≡ b (mod p)，两边乘 coefficient 的逆元
        long[] g = exgcd(coefficient, p);
        long inverse = ((g[1] % p) + p) % p;
        long result = bsgs(a, b * inverse % p, p);
        return result == -1 ? -1 : result + k;
    }
}
