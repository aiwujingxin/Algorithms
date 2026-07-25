package knowledge.mathematics.algebra.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 矩阵模板 (乘法 / 快速幂 / 行列式 / 秩 / 逆)
 * <适用场景>
 * 1. 线性递推加速：把 O(n) 递推压成 O(k^3 log n) 的矩阵快速幂（斐波那契、路径计数）。
 * 2. 计数 DP：邻接矩阵的 k 次幂给出长度为 k 的路径条数。
 * 3. 线性代数：行列式判可逆、求秩判线性相关、求逆解方程。
 * <数值纪律>
 * - 取模版本（mulMod / powMod）用于整数计数，全程 long 取模。
 * - 浮点版本（determinant / rank / inverse）用高斯消元 + 部分主元，EPS 判零。
 */
public class Matrix {

    private static final double EPS = 1e-9;

    // ==================== 取模整数矩阵 ====================

    /**
     * 矩阵乘法 A(r×z) × B(z×c)，逐元素取模。
     */
    public static long[][] mulMod(long[][] a, long[][] b, long mod) {
        int r = a.length, z = b.length, c = b[0].length;
        long[][] result = new long[r][c];
        for (int i = 0; i < r; i++) {
            for (int k = 0; k < z; k++) {
                if (a[i][k] == 0) continue;
                long aik = a[i][k] % mod;
                for (int j = 0; j < c; j++) {
                    result[i][j] = (result[i][j] + aik * b[k][j]) % mod;
                }
            }
        }
        return result;
    }

    /**
     * 方阵快速幂 base^power (mod mod)，时间复杂度 O(n^3 log power)。
     */
    public static long[][] powMod(long[][] base, long power, long mod) {
        int n = base.length;
        long[][] result = identity(n, mod);
        long[][] cur = base;
        while (power > 0) {
            if ((power & 1) == 1) result = mulMod(result, cur, mod);
            cur = mulMod(cur, cur, mod);
            power >>= 1;
        }
        return result;
    }

    /**
     * n 阶单位矩阵（元素对 mod 取模，兼容 mod == 1）。
     */
    public static long[][] identity(int n, long mod) {
        long[][] id = new long[n][n];
        for (int i = 0; i < n; i++) id[i][i] = 1 % mod;
        return id;
    }

    // ==================== 浮点方阵：行列式 / 秩 / 逆 ====================

    /**
     * 高斯消元求行列式，主元交换奇偶决定符号。
     */
    public static double determinant(double[][] matrix) {
        int n = matrix.length;
        double[][] a = copy(matrix);
        double det = 1;
        for (int col = 0; col < n; col++) {
            int pivot = col;
            for (int row = col + 1; row < n; row++) {
                if (Math.abs(a[row][col]) > Math.abs(a[pivot][col])) pivot = row;
            }
            if (Math.abs(a[pivot][col]) < EPS) return 0;
            if (pivot != col) {
                double[] tmp = a[pivot];
                a[pivot] = a[col];
                a[col] = tmp;
                det = -det;
            }
            det *= a[col][col];
            for (int row = col + 1; row < n; row++) {
                double factor = a[row][col] / a[col][col];
                for (int k = col; k < n; k++) a[row][k] -= factor * a[col][k];
            }
        }
        return det;
    }

    /**
     * 矩阵的秩（行阶梯形非零行数），适用于任意 m×n 矩阵。
     */
    public static int rank(double[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        double[][] a = copy(matrix);
        int rank = 0;
        for (int col = 0; col < cols && rank < rows; col++) {
            int pivot = rank;
            for (int row = rank + 1; row < rows; row++) {
                if (Math.abs(a[row][col]) > Math.abs(a[pivot][col])) pivot = row;
            }
            if (Math.abs(a[pivot][col]) < EPS) continue;
            double[] tmp = a[pivot];
            a[pivot] = a[rank];
            a[rank] = tmp;
            for (int row = 0; row < rows; row++) {
                if (row == rank) continue;
                double factor = a[row][col] / a[rank][col];
                for (int k = col; k < cols; k++) a[row][k] -= factor * a[rank][k];
            }
            rank++;
        }
        return rank;
    }

    /**
     * 高斯-约当法求逆矩阵，不可逆返回 null。
     */
    public static double[][] inverse(double[][] matrix) {
        int n = matrix.length;
        double[][] a = new double[n][2 * n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, a[i], 0, n);
            a[i][n + i] = 1;
        }
        for (int col = 0; col < n; col++) {
            int pivot = col;
            for (int row = col + 1; row < n; row++) {
                if (Math.abs(a[row][col]) > Math.abs(a[pivot][col])) pivot = row;
            }
            if (Math.abs(a[pivot][col]) < EPS) return null;
            double[] tmp = a[pivot];
            a[pivot] = a[col];
            a[col] = tmp;
            double diag = a[col][col];
            for (int k = 0; k < 2 * n; k++) a[col][k] /= diag;
            for (int row = 0; row < n; row++) {
                if (row == col) continue;
                double factor = a[row][col];
                for (int k = 0; k < 2 * n; k++) a[row][k] -= factor * a[col][k];
            }
        }
        double[][] inverse = new double[n][n];
        for (int i = 0; i < n; i++) System.arraycopy(a[i], n, inverse[i], 0, n);
        return inverse;
    }

    private static double[][] copy(double[][] matrix) {
        double[][] clone = new double[matrix.length][];
        for (int i = 0; i < matrix.length; i++) clone[i] = matrix[i].clone();
        return clone;
    }
}
