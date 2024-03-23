package knowledge.algorithms.presumAnddiff.impl;

import leetcode.problems.LeetCode2132;
import leetcode.problems.LeetCode2536;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/27 23:58
 * @see LeetCode2536
 * @see LeetCode2132
 */

public class PreDiff_2d {

    static int[][] diff;
    int m;
    int n;

    public PreDiff_2d(int[][] nums) {
        m = nums.length;
        n = nums[0].length;
        diff = new int[m][n];
        diff[0][0] = nums[0][0];
        for (int i = 1; i < m; i++) {
            diff[i][0] = nums[i][0] - nums[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            diff[0][i] = nums[0][i] - nums[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                diff[i][j] = nums[i][j] - nums[i - 1][j] - nums[i][j - 1] + nums[i - 1][j - 1];
            }
        }
    }

    public void update(int r1, int c1, int r2, int c2, int k) {
        diff[r1][c1] += k;
        if (c2 + 1 < n) {
            diff[r1][c2 + 1] -= k;
        }
        if (r2 + 1 < m) {
            diff[r2 + 1][c1] -= k;
        }
        if (r2 + 1 < m && c2 + 1 < n) {
            diff[r2 + 1][c2 + 1] += k;
        }
    }

    public int[][] result() {
        int[][] ans = new int[m][n];
        ans[0][0] = diff[0][0];
        for (int i = 1; i < m; i++) {
            ans[i][0] += ans[i - 1][0] + diff[i][0];
        }
        for (int i = 1; i < n; i++) {
            ans[0][i] += ans[0][i - 1] + diff[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ans[i][j] = ans[i][j] + ans[i][j - 1] + ans[i - 1][j] - ans[i - 1][j - 1] + diff[i][j];
            }
        }
        return ans;
    }
}
