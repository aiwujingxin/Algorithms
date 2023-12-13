package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/13 13:17
 */
public class LeetCode91 {

    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            }
            if (s.charAt(i - 1) != '0') {
                int num = Integer.parseInt(s.substring(i - 1, i + 1));
                if (num >= 10 && num <= 26) {
                    dp[i] += (i - 2 < 0) ? 1 : dp[i - 2];
                }
            }
        }
        return dp[n - 1];
    }
}
