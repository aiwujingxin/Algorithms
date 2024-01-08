package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-18 7:04 PM
 */
public class LeetCode1292 {

    public int maxSideLength(int[][] mat, int threshold) {
        //二分查找
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int left = 0, right = Math.min(m, n);
        while (left < right) {
            int mid = left + right + 1 >> 1;
            boolean flag = false;
            for (int i = 1; i + mid <= m + 1; ++i) {
                for (int j = 1; j + mid <= n + 1; ++j) {
                    int temp =
                            prefix[i + mid - 1][j + mid - 1] - prefix[i + mid - 1][j - 1] - prefix[i - 1][j + mid - 1]
                                    + prefix[i - 1][j - 1];
                    if (temp <= threshold) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
