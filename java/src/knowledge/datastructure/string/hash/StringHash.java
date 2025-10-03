package knowledge.datastructure.string.hash;

/**
 * @author wujingxinit@outlook.com
 * @date 8/30/25 21:54
 * @see leetcode.problems.LeetCode1392
 */
public class StringHash {

    private static final long BASE = 131;    // 进制基数（通常取质数）
    private static final long MOD = (long) 1e9 + 7; // 模数

    private final long[] hash;     // 前缀哈希数组
    private final long[] power;    // 存储 base 的幂次

    public StringHash(String s) {
        int n = s.length();
        hash = new long[n + 1];
        power = new long[n + 1];

        // 初始化
        power[0] = 1;
        hash[0] = 0;

        // 计算前缀哈希和幂次
        for (int i = 1; i <= n; i++) {
            power[i] = (power[i - 1] * BASE) % MOD;
            hash[i] = (hash[i - 1] * BASE + s.charAt(i - 1)) % MOD;
        }
    }

    // 获取子串 s[l, r] 的哈希值（左闭右开区间）
    public long getHash(int l, int r) {
        return (hash[r] - hash[l] * power[r - l] % MOD + MOD) % MOD;
    }

    // 比较两个子串是否相等
    public boolean equals(int l1, int r1, int l2, int r2) {
        if (r1 - l1 != r2 - l2) return false;
        return getHash(l1, r1) == getHash(l2, r2);
    }

    public int strStr(String text, String pat) {
        if (pat.isEmpty()) return 0;
        int n = text.length(), m = pat.length();
        StringHash textHash = new StringHash(text);
        StringHash patternHash = new StringHash(pat);
        long targetHash = patternHash.getHash(0, pat.length());
        for (int i = 0; i <= n - m; i++) {
            if (textHash.getHash(i, i + m) == targetHash) {
                if (text.substring(i, i + m).equals(pat)) return i;
            }
        }
        return -1;
    }
}
