package leetCode.problems;

public class LeetCode132 {
    public static void main(String[] args) {
        System.out.println(new LeetCode132().minCut("ab"));
    }

    public int minCut(String s) {
        Integer[] dp = new Integer[s.length()];
        return recur(s, s.length() - 1, dp);
    }

    private int recur(String s, int i, Integer[] dp) {
        if (i == -1) return -1;
        if (dp[i] != null) return dp[i];

        int min = (int) 1e9, ans;

        for (int ind = i; ind >= 0; ind--) {
            if (ispalin(s, ind, i)) {
                ans = 1 + recur(s, ind - 1, dp);
                min = Math.min(min, ans);
            }
        }
        return dp[i] = min;
    }

    private boolean ispalin(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

}
