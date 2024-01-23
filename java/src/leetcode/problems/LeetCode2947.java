package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/23 14:53
 */
public class LeetCode2947 {

    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        int[] presum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            presum[i] = presum[i - 1] + ("aeiou".indexOf(s.charAt(i - 1)) >= 0 ? 1 : 0);
        }

        int ans = 0;
        for (int i = 2; i < presum.length; i++) {
            for (int j = i & 1; j < i; j += 2) {
                int d = presum[i] - presum[j];
                if (d == (i - j) / 2 && d * d % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
