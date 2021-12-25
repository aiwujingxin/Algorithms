package jove;

/**
 * @author jingxinwu
 * @date 2021-12-23 7:06 PM
 *
 *
 *         第一题：
 *         删除构造回文串
 *         给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？输出需要删除的字符个数。
 *         输入：“ab2cdcba”
 *         输出：1
 *         示例：ab2cdcba-》删除‘2’即可
 *         输入：“0abcd3cba”
 *         输出：2
 *         示例：ab2cdcba-》删除‘0’和‘3’即可
 */

public class Number01 {

    public static void main(String[] args) {
        System.out.println(new Number01().cut("a2sbcdcba"));
    }

    public int cut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return s.length() - dp[0][n - 1];
    }
}
