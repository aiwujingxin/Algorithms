package leetcode.problems;

public class LeetCode132_dp_1d {

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, s)) {
                    int cuts = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cuts);
                }
            }
            dp[i] = minCost;
        }
        return dp[0] - 1;
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
