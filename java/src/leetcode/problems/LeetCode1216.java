package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/8 23:01
 * <a href="https://leetcode.cn/problems/valid-palindrome-iii/solution/javazi-di-xiang-shang-dong-tai-gui-hua-b-u3a4/">...</a>
 * <a href="https://www.youtube.com/watch?v=Xfk2lEByP9M">区间DP</a>
 */
public class LeetCode1216 {

    public boolean isValidPalindrome(String s, int k) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (c[i] == c[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1] <= k;
    }
}