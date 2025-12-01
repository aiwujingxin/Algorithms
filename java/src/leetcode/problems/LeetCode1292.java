package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-18 7:04 PM
 */
public class LeetCode1292 {

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        LeetCode304.NumMatrix arr = new LeetCode304.NumMatrix(mat);
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = 0;
                while (i + k < m && j + k < n) {
                    int sum = arr.sumRegion(i, j, i + k, j + k);
                    if (sum <= threshold) {
                        max = Math.max(max, k + 1);
                    } else {
                        break;
                    }
                    k++;
                }
            }
        }
        return max;
    }
}
