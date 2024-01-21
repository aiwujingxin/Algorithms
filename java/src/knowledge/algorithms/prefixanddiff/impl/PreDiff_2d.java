package knowledge.algorithms.prefixanddiff.impl;

import leetcode.problems.LeetCode2132;
import leetcode.problems.LeetCode2536;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/27 23:58
 * @see LeetCode2536
 * @see LeetCode2132
 */
public class PreDiff_2d {

    int[][] diff;
    int n;
    int m;

    public PreDiff_2d(int[][] nums) {
        n = nums.length;
        m = nums[0].length;
        diff = new int[n + 2][m + 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                update(i, j, i, j, nums[i][j]);
            }
        }
    }

    public void update(int r1, int c1, int r2, int c2, int k) {
        diff[r1 + 1][c1 + 1] += k;
        diff[r1 + 1][c2 + 2] -= k;
        diff[r2 + 2][c1 + 1] -= k;
        diff[r2 + 2][c2 + 2] += k;
    }

    public int[][] result() {
        int[][] ans = new int[n][m];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                ans[i - 1][j - 1] = (diff[i][j] += diff[i][j - 1] + diff[i - 1][j] - diff[i - 1][j - 1]);
            }
        }
        return ans;
    }
}
