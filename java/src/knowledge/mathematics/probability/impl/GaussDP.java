package knowledge.mathematics.probability.impl;

/**
 * @author wujingxinit@outlook.com
 * @description 高斯消元求概率 DP (Gaussian Elimination for Probability DP)
 * 用于解决包含环的概率 DP 或期望 DP 问题，转换为求解线性方程组
 * 时间复杂度 O(N^3)
 */
public class GaussDP {
    private static final double EPS = 1e-9;

    /**
     * 求解线性方程组 a * x = b
     * a 矩阵大小为 n * (n + 1)，其中第 n 列为常数项 b
     * 求解结果直接保存在 a 的最后一列，并返回结果数组
     *
     * @param a 增广矩阵 (n行，n+1列)
     * @param n 方程个数和未知数个数
     * @return 解数组 x，如果无唯一解返回 null
     */
    public static double[] gauss(double[][] a, int n) {
        for (int i = 0; i < n; i++) {
            // 选主元
            int maxRow = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(a[j][i]) > Math.abs(a[maxRow][i])) {
                    maxRow = j;
                }
            }

            // 无唯一解（主元极小，视为0）
            if (Math.abs(a[maxRow][i]) < EPS) {
                return null;
            }

            // 交换行
            if (maxRow != i) {
                double[] temp = a[i];
                a[i] = a[maxRow];
                a[maxRow] = temp;
            }

            // 消元
            for (int j = i + 1; j < n; j++) {
                double factor = a[j][i] / a[i][i];
                for (int k = i; k <= n; k++) {
                    a[j][k] -= factor * a[i][k];
                }
            }
        }

        // 回代求出每个未知数
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            x[i] = a[i][n];
            for (int j = i + 1; j < n; j++) {
                x[i] -= a[i][j] * x[j];
            }
            x[i] /= a[i][i];
        }

        return x;
    }
}
