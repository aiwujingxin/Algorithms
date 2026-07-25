package knowledge.mathematics.algebra.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description BSGS
 */
public class BSGS {
    /**
     * 大步小步算法 (Baby-Step Giant-Step)
     * 求解 a^x ≡ b (mod p)，要求 a, p 互质
     *
     * @return 最小非负整数解 x，如果无解返回 -1
     */
    public static long bsgs(long a, long b, long p) {
        a %= p;
        b %= p;
        if (b == 1) return 0;
        if (a == 0) return b == 0 ? 1 : -1;

        long m = (long) Math.ceil(Math.sqrt(p));
        Map<Long, Long> map = new HashMap<>();
        long cur = 1;
        for (long i = 0; i < m; i++) {
            map.putIfAbsent((b * cur) % p, i);
            cur = (cur * a) % p;
        }

        long am = cur;
        cur = 1;
        for (long i = 1; i <= m; i++) {
            cur = (cur * am) % p;
            if (map.containsKey(cur)) {
                long ans = i * m - map.get(cur);
                return (ans % p + p) % p;
            }
        }
        return -1;
    }
}