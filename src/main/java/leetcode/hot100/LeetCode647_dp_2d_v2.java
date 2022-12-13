package leetcode.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/5 22:27
 */
public class LeetCode647_dp_2d_v2 {

    //https://leetcode.com/problems/palindromic-substrings/discuss/2215680/Java-DP-short-solution-with-pattern-for-palindrome-problems
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
