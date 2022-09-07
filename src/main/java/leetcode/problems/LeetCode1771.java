package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-25 2:33 PM
 */
public class LeetCode1771 {

    public int longestPalindrome(String word1, String word2) {
        // 记录满足条件的最长的回文子序列的长度
        int max = 0;
        int length = word1.length();
        String s = word1 + word2;
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                    // 只有当i和j上的字符相同的时候，才会更新最长的长度。其中i要在word1中，j要在word2中
                    if (i < length && j >= length) {
                        max = Math.max(max, f[i][j]);
                    }
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return max;
    }
}
