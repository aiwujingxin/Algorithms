package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 5/3/25 21:45
 */
public class LeetCode1458 {

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] f = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int xij = nums1[i] * nums2[j];
                f[i][j] = xij;
                if (i > 0) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                }
                if (j > 0) {
                    f[i][j] = Math.max(f[i][j], f[i][j - 1]);
                }
                if (i > 0 && j > 0) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + xij);
                }
            }
        }

        return f[m - 1][n - 1];
    }
}
