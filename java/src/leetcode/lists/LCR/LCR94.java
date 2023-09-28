package leetcode.lists.LCR;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/28 16:28
 */
public class LCR94 {

    public int minCut(String s) {
        int n = s.length();
        int[] cuts = new int[n];
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j < 3 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    min = Math.min(min, j == 0 ? 0 : 1 + cuts[j - 1]);
                }
            }
            cuts[i] = min;
        }
        return cuts[n - 1];
    }
}
