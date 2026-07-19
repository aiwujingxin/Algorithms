package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 7/17/26 20:26
 */
public class LeetCode1895 {

    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] rowSum = new int[m][n + 1];
        int[][] colSum = new int[m + 1][n];
        int[][] diagSum = new int[m + 1][n + 1];
        int[][] antiDiagSum = new int[m + 1][n + 2];

        // 优化1：合并前缀和的初始化，减少多次遍历带来的开销，提升缓存命中率
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j];
                colSum[i + 1][j] = colSum[i][j] + grid[i][j];
                diagSum[i + 1][j + 1] = diagSum[i][j] + grid[i][j];
            }
            for (int j = n - 1; j >= 0; j--) {
                antiDiagSum[i + 1][j + 1] = antiDiagSum[i][j + 2] + grid[i][j];
            }
        }

        int maxLen = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int maxK = Math.min(m - i, n - j);

                // 优化2：k 的下界直接设置为 maxLen，因为我们要找的是“更大”的幻方
                for (int k = maxK; k > maxLen; k--) {
                    int target = rowSum[i][j + k] - rowSum[i][j];

                    // 优化3：【核心优化】优先校验 O(1) 复杂度的对角线！
                    // 大部分不合法的矩阵在这一步就会被拦截，从而避免后续 O(k) 的行列遍历
                    if (diagSum[i + k][j + k] - diagSum[i][j] != target) continue;
                    if (antiDiagSum[i + k][j + 1] - antiDiagSum[i][j + k + 1] != target) continue;

                    boolean valid = true;

                    // 优化4：第一行已经作为 target，无需重复校验，直接从 i + 1 开始
                    for (int r = i + 1; r < i + k; r++) {
                        if (rowSum[r][j + k] - rowSum[r][j] != target) {
                            valid = false;
                            break;
                        }
                    }
                    if (!valid) continue;

                    for (int c = j; c < j + k; c++) {
                        if (colSum[i + k][c] - colSum[i][c] != target) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) {
                        maxLen = k;
                        break; // 找到当前 (i,j) 能构成的最大幻方，直接跳出 k 循环
                    }
                }
            }
        }
        return maxLen;
    }

}
