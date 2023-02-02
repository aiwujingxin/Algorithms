package leetcode.plan.datastructure.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/8 22:28
 */
public class LeetCode566 {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            ans[x / c][x % c] = mat[x / n][x % n];
        }
        return ans;
    }
}
