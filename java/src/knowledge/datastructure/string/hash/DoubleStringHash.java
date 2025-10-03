package knowledge.datastructure.string.hash;

/**
 * @author wujingxinit@outlook.com
 * @date 8/30/25 22:35
 */
public class DoubleStringHash {
    private static final long BASE1 = 131, BASE2 = 13331;
    private static final long MOD1 = (long) 1e9 + 7, MOD2 = (long) 1e9 + 9;
    private final long[] hash1;
    private final long[] hash2;
    private final long[] power1;
    private final long[] power2;

    public DoubleStringHash(String s) {
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

    public long[] getHash(int l, int r) {
        long h1 = (hash1[r] - hash1[l] * power1[r - l] % MOD1 + MOD1) % MOD1;
        long h2 = (hash2[r] - hash2[l] * power2[r - l] % MOD2 + MOD2) % MOD2;
        return new long[]{h1, h2};
    }
}
