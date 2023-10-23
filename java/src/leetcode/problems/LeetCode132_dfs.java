package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/28 16:28
 * @see LeetCode5
 * @see LeetCode131
 * @see LeetCode139_dfs
 * @see LeetCode140_dfs
 * @see LeetCode647
 * @see LeetCode516
 */
public class LeetCode132_dfs {
    //https://leetcode.com/problems/palindrome-partitioning-ii/discuss/2216520/DP-Solution-3-Solutions
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(0, s, n, dp) - 1;
    }

    private int dfs(int i, String s, int n, int[] dp) {
        if (i == n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int minCost = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, s)) {
                int cuts = 1 + dfs(j + 1, s, n, dp);
                minCost = Math.min(minCost, cuts);
            }
        }
        return dp[i] = minCost;
    }

    private boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
