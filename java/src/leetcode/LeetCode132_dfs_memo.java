package leetcode;

import java.util.Arrays;

public class LeetCode132_dfs_memo {

    //https://leetcode.com/problems/palindrome-partitioning-ii/discuss/2216520/DP-Solution-3-Solutions

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return f(0, s, n, dp) - 1;
    }

    private int f(int i, String s, int n, int[] dp) {
        // Base case
        if (i == n) return 0;

        if (dp[i] != -1) {
            return dp[i];
        }

        int minCost = Integer.MAX_VALUE;

        // Front partition
        for (int j = i; j < n; j++) {

            if (isPalindrome(i, j, s)) {
                int cuts = 1 + f(j + 1, s, n, dp);
                minCost = Math.min(minCost, cuts);
            }
        }

        return dp[i] = minCost;
    }

    private boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
