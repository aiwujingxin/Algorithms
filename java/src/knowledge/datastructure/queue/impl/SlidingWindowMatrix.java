package knowledge.datastructure.queue.impl;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author wujingxinit@outlook.com
 * @date 12/4/25 17:54
 */
public class SlidingWindowMatrix {

    // V1: 暴力解法 (基准)
    public static int[][] maxSlidingWindowMatrix_v1(int[][] mat, int a, int b) {
        if (mat == null || mat.length < a || mat[0].length < b || a <= 0 || b <= 0) return new int[0][0];
        int m = mat.length, n = mat[0].length;
        int resRows = m - a + 1, resCols = n - b + 1;
        int[][] result = new int[resRows][resCols];
        for (int i = 0; i < resRows; i++) {
            for (int j = 0; j < resCols; j++) {
                int maxVal = Integer.MIN_VALUE;
                for (int row = i; row < i + a; row++) {
                    for (int col = j; col < j + b; col++) {
                        maxVal = Math.max(maxVal, mat[row][col]);
                    }
                }
                result[i][j] = maxVal;
            }
        }
        return result;
    }

    // V2: 降维 + 双端队列
    public static int[][] maxSlidingWindowMatrix_v2(int[][] mat, int a, int b) {
        if (mat == null || mat.length < a || mat[0].length < b || a <= 0 || b <= 0) return new int[0][0];
        int m = mat.length, n = mat[0].length;
        int tempCols = n - b + 1;
        int[][] tempMatrix = new int[m][tempCols];
        for (int i = 0; i < m; i++) {
            tempMatrix[i] = maxSlidingWindow1D_Deque(mat[i], b);
        }
        int resRows = m - a + 1;
        int[][] result = new int[resRows][tempCols];
        for (int j = 0; j < tempCols; j++) {
            int[] colArray = new int[m];
            for (int i = 0; i < m; i++) colArray[i] = tempMatrix[i][j];
            int[] colResult = maxSlidingWindow1D_Deque(colArray, a);
            for (int i = 0; i < resRows; i++) result[i][j] = colResult[i];
        }
        return result;
    }

    // V3: 降维 + 分块预处理
    public static int[][] maxSlidingWindowMatrix_v3(int[][] mat, int a, int b) {
        if (mat == null || mat.length < a || mat[0].length < b || a <= 0 || b <= 0) return new int[0][0];
        int m = mat.length, n = mat[0].length;
        int tempCols = n - b + 1;
        int[][] tempMatrix = new int[m][tempCols];
        for (int i = 0; i < m; i++) {
            tempMatrix[i] = maxSlidingWindow1D_Blocking(mat[i], b);
        }
        int resRows = m - a + 1;
        int[][] result = new int[resRows][tempCols];
        for (int j = 0; j < tempCols; j++) {
            int[] colArray = new int[m];
            for (int i = 0; i < m; i++) colArray[i] = tempMatrix[i][j];
            int[] colResult = maxSlidingWindow1D_Blocking(colArray, a);
            for (int i = 0; i < resRows; i++) result[i][j] = colResult[i];
        }
        return result;
    }

    // --- 辅助方法 ---
    // V2 使用的1D解法
    private static int[] maxSlidingWindow1D_Deque(int[] nums, int k) {
        if (nums.length < k || k <= 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) deque.pollFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.offerLast(i);
            if (i >= k - 1) result[i - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }

    // V3 使用的1D解法
    private static int[] maxSlidingWindow1D_Blocking(int[] nums, int k) {
        if (nums.length < k || k <= 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % k == 0) prefixMax[i] = nums[i];
            else prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || (i + 1) % k == 0) suffixMax[i] = nums[i];
            else suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return result;
    }

    public static class Checker {
        // --- 复用之前的辅助函数 ---
        public static int[][] generateRandomMatrix(int maxRows, int maxCols, int maxValue) {
            int rows = (int) (Math.random() * maxRows) + 1;
            int cols = (int) (Math.random() * maxCols) + 1;
            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = (int) (Math.random() * (maxValue * 2 + 1)) - maxValue;
                }
            }
            return matrix;
        }

        public static boolean areMatricesEqual(int[][] m1, int[][] m2) {
            if (m1.length != m2.length) return false;
            for (int i = 0; i < m1.length; i++) {
                if (!Arrays.equals(m1[i], m2[i])) return false;
            }
            return true;
        }

        public static void printMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                System.out.println("[]");
                return;
            }
            for (int[] row : matrix) {
                System.out.println(Arrays.toString(row));
            }
        }

        // --- 对拍主逻辑 ---
        public static void main(String[] args) {
            int testTimes = 1000;  // 测试次数
            int maxRows = 200;       // 矩阵最大行数 (调小一点，避免V1过慢)
            int maxCols = 200;       // 矩阵最大列数
            int maxValue = 100;     // 矩阵中元素的最大值
            boolean success = true;
            System.out.println("对拍测试开始 (V1 vs V2 vs V3)...");
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < testTimes; i++) {
                int[][] mat = generateRandomMatrix(maxRows, maxCols, maxValue);
                int a = (int) (Math.random() * mat.length) + 1;
                int b = (int) (Math.random() * mat[0].length) + 1;
                // 运行三个版本的算法
                int[][] res1 = maxSlidingWindowMatrix_v1(mat, a, b);
                int[][] res2 = maxSlidingWindowMatrix_v2(mat, a, b);
                int[][] res3 = maxSlidingWindowMatrix_v3(mat, a, b);
                // 两两比较
                boolean v2_ok = areMatricesEqual(res1, res2);
                boolean v3_ok = areMatricesEqual(res1, res3);
                if (!v2_ok || !v3_ok) {
                    success = false;
                    System.out.println("噢！出错了！");
                    System.out.println("-----------------------------------------");
                    System.out.println("测试数据 (mat):");
                    printMatrix(mat);
                    System.out.println("窗口大小 a = " + a + ", b = " + b);
                    System.out.println("\n基准解法 (V1) 的结果:");
                    printMatrix(res1);
                    if (!v2_ok) {
                        System.out.println("\n[错误] V2 (Deque) 的结果不一致:");
                        printMatrix(res2);
                    }
                    if (!v3_ok) {
                        System.out.println("\n[错误] V3 (Blocking) 的结果不一致:");
                        printMatrix(res3);
                    }
                    System.out.println("-----------------------------------------");
                    break;
                }
                if ((i + 1) % 1000 == 0) {
                    System.out.println("已完成 " + (i + 1) + " / " + testTimes + " 次测试...");
                }
            }
            long endTime = System.currentTimeMillis();
            if (success) {
                System.out.println("\n太棒了！V2 和 V3 通过了所有 " + testTimes + " 次测试！");
                System.out.printf("总耗时: %.2f 秒\n", (endTime - startTime) / 1000.0);
            }
            System.out.println("对拍测试结束。");
        }
    }
}
