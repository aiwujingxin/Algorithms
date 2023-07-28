package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/5 22:24
 */
public class LeetCode647_dp_2d {

    //https://leetcode.com/problems/palindromic-substrings/discuss/2321609/Java-Simple-DP-Solution-or-O(n2)-time-and-space
    public int countSubstrings(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int count = 0;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    if (c[i] == c[j]) {
                        if (dp[i + 1][j - 1] > 0 || (j - i == 1)) {
                            dp[i][j] = 2 + dp[i + 1][j - 1];
                        }
                    }
                }
                if (dp[i][j] > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
