package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-18 7:04 PM
 */
public class LeetCode1292 {

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] s = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int l = 0, r = Math.min(m, n);
        while (l < r) {
            int mid = l + r + 1 >> 1;
            boolean flag = false;
            for (int i = 1; i + mid <= m + 1; ++i) {
                for (int j = 1; j + mid <= n + 1; ++j) {
                    int temp = s[i + mid - 1][j + mid - 1] - s[i + mid - 1][j - 1] - s[i - 1][j + mid - 1] + s[i - 1][j - 1];
                    if (temp <= threshold) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
