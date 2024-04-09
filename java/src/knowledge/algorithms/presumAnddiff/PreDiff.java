package knowledge.algorithms.presumAnddiff;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/23 15:52
 * @description 差分数组 差分数组的前缀和就是原数组
 * <一维>
 * @see LeetCode370
 * @see LeetCode1094
 * @see LeetCode1109
 * <二维>
 * @see LeetCode2536
 * @see LeetCode2132
 */
public interface PreDiff {

    class PreDiff_1D {

        final int[] diff;

        public PreDiff_1D(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void update(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }


    class PreDiff_2D {
        final int[][] diff;
        int m;
        int n;

        public PreDiff_2D(int[][] nums) {
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
}
