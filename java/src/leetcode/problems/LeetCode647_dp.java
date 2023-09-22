package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/20 17:30
 */
public class LeetCode647_dp {
    public static void main(String[] args) {
        System.out.println(new LeetCode647_dp().countSubstrings("aaa"));
        System.out.println(new LeetCode647_dp().countSubstrings("aaabbaaababbabaa"));

    }

    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int count = s.length();
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1] || j - i + 1 < 3);
                if (dp[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
