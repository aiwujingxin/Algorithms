package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/23 14:53
 */
public class LeetCode2947 {

    public int beautifulSubstrings(String str, int k) {
        int n = str.length();
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + ("aeiou".indexOf(str.charAt(i - 1)) >= 0 ? 1 : 0);
        }
        int ans = 0;
        for (int i = 1; i < s.length; i++) {
            for (int j = 0; j < i; j++) {
                int d = s[i] - s[j];
                if ((i - j) % 2 == 0 && d == (i - j) / 2 && d * d % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
