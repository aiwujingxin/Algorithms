package knowledge.datastructure.string.hash;

/**
 * @author wujingxinit@outlook.com
 * @date 8/30/25 21:54
 * @description 核心思想：将字符串映射为一个唯一的数值，以便快速比较。是很多高级算法的基础。
 * 应用：
 * - 快速比较任意两个子串是否相等。
 * - 查找重复子串、最长重复子串等
 * @see leetcode.problems.LeetCode1392
 */
public class StringHash {

    private static final long BASE = 131;    // 进制基数（通常取质数）
    private static final long MOD = (long) 1e9 + 7; // 模数

    private final long[] hash;     // 前缀哈希数组
    private final long[] power;    // 存储 base 的幂次

    private final String s;

    public StringHash(String s) {
        this.s = s;
        int n = s.length();
        hash = new long[n + 1];
        power = new long[n + 1];
        power[0] = 1;
        hash[0] = 0;
        for (int i = 1; i <= n; i++) {
            power[i] = (power[i - 1] * BASE) % MOD;
            hash[i] = (hash[i - 1] * BASE + s.charAt(i - 1)) % MOD;
        }
    }

    // 获取子串 s[l, r] 的哈希值（左闭右开区间）
    public long getHash(int l, int r) {
        return (hash[r] - hash[l] * power[r - l] % MOD + MOD) % MOD;
    }

    public long getUpdatedHash(int l, int r, int k, char c) {
        int len = r - l;
        long oldH = getHash(l, r);
        char oldC = s.charAt(l + k);
        long diff = (c - oldC + MOD) % MOD;
        long p_pow = power[len - 1 - k];
        return (oldH + diff * p_pow) % MOD;
    }

    public int strStr(String text, String pat) {
        if (pat.isEmpty()) return 0;
        int n = text.length(), m = pat.length();
        StringHash th = new StringHash(text);
        StringHash ph = new StringHash(pat);
        long target = ph.getHash(0, pat.length());
        for (int i = 0; i <= n - m; i++) {
            if (th.getHash(i, i + m) == target) {
                if (text.substring(i, i + m).equals(pat)) return i;
            }
        }
        return -1;
    }
}
