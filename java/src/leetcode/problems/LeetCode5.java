package leetcode.problems;

import knowledge.datastructure.string.manacher.Manacher;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 10:35
 * @see Manacher
 */
public class LeetCode5 {

    public String longestPalindrome(String s) {
        int n = s.length(), l = 0, len = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > len) {
                    l = i;
                    len = j - i + 1;
                }
            }
        }
        return s.substring(l, l + len);
    }

    // 中心扩展法
    class Solution_Center {

        public String longestPalindrome(String s) {
            int start = 0;
            int end = 0;
            int maxLen = 0;
            for (int i = 0; i < s.length(); i++) {
                int l1 = cal(s, i, i);
                int l2 = cal(s, i, i + 1);
                int max = Math.max(l1, l2);
                if (max > maxLen) {
                    maxLen = max;
                    start = i - (max - 1) / 2;
                    end = i + max / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        public int cal(String s, int i, int j) {
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }
            return j - i - 1;
        }
    }
}
