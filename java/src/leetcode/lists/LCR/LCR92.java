package leetcode.lists.LCR;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 23:00
 */
public class LCR92 {

    public int minFlipsMonoIncr(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        char[] arr = s.toCharArray();
        int[][] dp = new int[n][2];
        dp[0][0] = arr[0] == '0' ? 0 : 1;
        dp[0][1] = arr[0] == '1' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + (arr[i] == '1' ? 1 : 0);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (arr[i] == '1' ? 0 : 1);
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}
