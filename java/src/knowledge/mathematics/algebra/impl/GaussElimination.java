package knowledge.mathematics.algebra.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description GaussElimination
 */
public class GaussElimination {
    private static final double EPS = 1e-9;

    /**
     * 高斯消元解线性方程组
     *
     * @param a 增广矩阵，大小为 n * (n + 1)
     * @return 解数组。如果无唯一解（无解或无穷多解），返回 null
     */
    public static double[] gauss(double[][] a) {
        if (a == null || a.length == 0 || a[0].length != a.length + 1) {
            return null;
        }

        int n = a.length;
        for (int i = 0; i < n; i++) {
            // 选主元
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(a[k][i]) > Math.abs(a[maxRow][i])) {
                    maxRow = k;
                }
            }

            // 如果主元为 0，说明矩阵非满秩
            if (Math.abs(a[maxRow][i]) < EPS) {
                return null;
            }

            // 交换当前行和主元行
            double[] temp = a[i];
            a[i] = a[maxRow];
            a[maxRow] = temp;

            // 消元
            for (int k = i + 1; k < n; k++) {
                double factor = a[k][i] / a[i][i];
                for (int j = i; j <= n; j++) {
                    a[k][j] -= factor * a[i][j];
                }
            }
        }

        // 回代求出解
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