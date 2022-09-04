package leetCode.problems;

public class LeetCode5_dp_1d {

    public String longestPalindrome(String s) {
        int l = 0, r = 0, n = s.length();
        boolean[] dp = new boolean[n];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i == j + 1 || dp[j + 1])) {
                    dp[j] = true;
                    if (i - j > r - l) {
                        r = i;
                        l = j;
                    }
                } else {
                    dp[j] = false;
                }
            }
            dp[i] = true;
        }
        return s.substring(l, r + 1);
    }
}
