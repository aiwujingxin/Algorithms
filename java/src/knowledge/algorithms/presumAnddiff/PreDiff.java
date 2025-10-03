package knowledge.algorithms.presumAnddiff;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/23 15:52
 * @description 差分数组 差分数组的前缀和就是原数组
 * <一维>
 * @see LeetCode370   区间加法
 * @see LeetCode1094  拼车
 * @see LeetCode1109  航班预订统计
 * @see LeetCode798   得分最高的最小轮调
 * @see LeetCode995   K 连续位的最小翻转次数
 * @see LeetCode3355  零数组变换 I
 * <二维>
 * @see LeetCode2536
 * @see LeetCode2132
 */
public interface PreDiff {

    class PreDiff1D {
        int[] d;

        PreDiff1D(int[] a) {
            d = a.clone();
            for (int i = 1; i < a.length; i++) d[i] -= a[i - 1];
        }

        void update(int l, int r, int v) {
            d[l] += v;
            if (r + 1 < d.length) d[r + 1] -= v;
        }

        int[] result() {
            for (int i = 1; i < d.length; i++) d[i] += d[i - 1];
            return d;
        }
    }


    class PreDiff2D {
        int[][] d;
        int m, n;

        public PreDiff2D(int[][] a) {
            m = a.length;
            n = a[0].length;
            d = new int[m + 1][n + 1]; // 差分数组
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    update(i, j, i, j, a[i][j]); // 初始化差分
        }

        public void update(int x1, int y1, int x2, int y2, int v) {
            d[x1][y1] += v;
            d[x2 + 1][y1] -= v;
            d[x1][y2 + 1] -= v;
            d[x2 + 1][y2 + 1] += v;
        }

        public int[][] result() {
            int[][] res = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {
                    if (i > 0) d[i][j] += d[i - 1][j];
                    if (j > 0) d[i][j] += d[i][j - 1];
                    if (i > 0 && j > 0) d[i][j] -= d[i - 1][j - 1];
                    res[i][j] = d[i][j];
                }
            return res;
        }
    }
}
