package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 7/6/25 13:19
 */
public class LeetCode664 {

    public int strangePrinter(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                int minn = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    minn = Math.min(minn, f[i][k] + f[k + 1][j]);
                }
                if (s.charAt(i) == s.charAt(j)) {
                    minn = Math.min(Math.min(minn, f[i][j - 1]), f[i + 1][j]);
                }
                f[i][j] = minn;
            }
        }
        return f[0][n - 1];
    }
}
