package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/15 23:14
 */
public class LeetCode5 {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        int left = 0;
        int right = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > res) {
                    res = j - i + 1;
                    left = i;
                    right = j + 1;
                }
            }
        }
        return s.substring(left, right);
    }

    public String longestPalindrome_v2(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return s;
        }
        String res = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String a = check(s, i, i);
            String b = check(s, i, i + 1);
            if (a.length() > res.length()) {
                res = a;
            }
            if (b.length() > res.length()) {
                res = b;
            }
        }
        return res;
    }

    private String check(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}
