package knowledge.datastructure.string.hash;

/**
 * @author wujingxinit@outlook.com
 * @date 8/30/25 22:35
 * @description 字符串双 hash 值
 * @see leetcode.problems.LeetCode2261
 */
public class DStringHash implements knowledge.datastructure.string.String.Match {
    public static final long BASE1 = 131, BASE2 = 13331;
    public static final long MOD1 = (long) 1e9 + 7, MOD2 = (long) 1e9 + 9;
    private final String originalString;
    public final long[] hash1;
    public final long[] hash2;
    public final long[] power1;
    public final long[] power2;

    public DStringHash(String s) {
        originalString = s;
        int n = s.length();
        hash1 = new long[n + 1];
        hash2 = new long[n + 1];
        power1 = new long[n + 1];
        power2 = new long[n + 1];
        power1[0] = power2[0] = 1;

        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            power1[i] = (power1[i - 1] * BASE1) % MOD1;
            power2[i] = (power2[i - 1] * BASE2) % MOD2;
            hash1[i] = (hash1[i - 1] * BASE1 + c) % MOD1;
            hash2[i] = (hash2[i - 1] * BASE2 + c) % MOD2;
        }
    }

    // 获取子串[l, r) 的哈希值 [l, r)
    public long[] getHash(int l, int r) {
        long h1 = (hash1[r] - hash1[l] * power1[r - l] % MOD1 + MOD1) % MOD1;
        long h2 = (hash2[r] - hash2[l] * power2[r - l] % MOD2 + MOD2) % MOD2;
        return new long[]{h1, h2};
    }

    // 计算 子串 s[l, r) 在其内部第 k 个位置被替换为 c 后的新哈希值。
    public long[] getUpdatedHash(int l, int r, int k, char c) {
        int len = r - l;
        long[] oldHashKey = getHash(l, r);
        long p_pow1 = power1[len - 1 - k];
        long p_pow2 = power2[len - 1 - k];
        char oldChar = this.originalString.charAt(l + k);
        final long MOD1 = (long) 1e9 + 7, MOD2 = (long) 1e9 + 9;
        // H_new = H_old + (new_char - old_char) * B^p. 加上 MOD 是为了防止结果为负。
        long diff1 = (c - oldChar + MOD1) % MOD1;
        long diff2 = (c - oldChar + MOD2) % MOD2;
        long new_h1 = (oldHashKey[0] + diff1 * p_pow1) % MOD1;
        long new_h2 = (oldHashKey[1] + diff2 * p_pow2) % MOD2;
        return new long[]{new_h1, new_h2};
    }

    public int strStr(String text, String pat) {
        if (pat.isEmpty()) return 0;
        int n = text.length();
        int m = pat.length();
        if (m > n) return -1;
        DStringHash textHash = new DStringHash(text);
        DStringHash patHash = new DStringHash(pat);
        long[] targetHash = patHash.getHash(0, m);
        for (int i = 0; i <= n - m; i++) {
            long[] currentHash = textHash.getHash(i, i + m);
            if (currentHash[0] == targetHash[0] && currentHash[1] == targetHash[1]) {
                return i;
            }
        }
        return -1;
    }
}
