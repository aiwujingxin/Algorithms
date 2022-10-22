package leetplan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/22 10:37
 */
public class LeetCode516 {

    public static void main(String[] args) {
        System.out.println(new LeetCode516().longestPalindromeSubseq("bbbab"));
    }

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] chars = s.toCharArray();
        //用dp[i][j] 表示字符串 s的下标范围 [i, j] 内的最长回文子序列的长度
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < chars.length; ++i) {
            dp[i][i] = 1;
        }

        for (int i = chars.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][dp.length - 1];
    }
}
