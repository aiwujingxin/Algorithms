package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/7/17 15:14
 */
public class LeetCode1745 {


    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; j++, i++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (dp[0][i - 1] && dp[i][j - 1] && dp[j][n - 1])  //if able to form 3 palindromes then true else false
                    return true;
            }
        }

        return false;
    }
}
