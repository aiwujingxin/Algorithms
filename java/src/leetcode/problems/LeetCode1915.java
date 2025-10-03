package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 8/18/25 23:23
 */
public class LeetCode1915 {

    public long wonderfulSubstrings(String word) {
        long ans = 0;
        int n = word.length();
        // 因为只有 'a'~'j'，最多 2^10 种状态
        long[] count = new long[1 << 10];
        int mask = 0;
        count[0] = 1; // 空前缀

        for (int i = 0; i < n; i++) {
            int bit = word.charAt(i) - 'a';
            mask ^= (1 << bit);

            // 情况 1：完全相同 mask
            ans += count[mask];

            // 情况 2：只差一位的 mask
            for (int k = 0; k < 10; k++) {
                ans += count[mask ^ (1 << k)];
            }

            count[mask]++;
        }
        return ans;
    }
}
