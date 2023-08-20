package leetcode;

public class LeetCode132_dfs {

    public int minCut(String s) {
        int n = s.length();

        return f(0, s, n) - 1;
    }

    private int f(int i, String s, int n) {
        // Base case
        if (i == n) return 0;


        int minCost = Integer.MAX_VALUE;

        // Front partition
        for (int j = i; j < n; j++) {

            if (isPalindrome(i, j, s)) {
                int cuts = 1 + f(j + 1, s, n);
                minCost = Math.min(minCost, cuts);
            }
        }

        return minCost;
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
