package knowledge.datastructure.queue.impl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wujingxinit@outlook.com
 * @date 12/4/25 18:06
 */
public class SlidingWindowND {

    /**
     * 三维滑动窗口最大值
     * @param mat 三维矩阵 (d1 x d2 x d3)
     * @param w1  窗口维度1
     * @param w2  窗口维度2
     * @param w3  窗口维度3
     * @return 结果矩阵
     */
    public static int[][][] maxSlidingWindowMatrix3D(int[][][] mat, int w1, int w2, int w3) {
        int d1 = mat.length;
        int d2 = mat[0].length;
        int d3 = mat[0][0].length;
        // 1. 沿着第3个维度 (d3) 滑动，窗口 w3
        int[][][] temp1 = new int[d1][d2][d3 - w3 + 1];
        for (int i = 0; i < d1; i++) {
            for (int j = 0; j < d2; j++) {
                // mat[i][j] 是一个一维数组
                temp1[i][j] = maxSlidingWindow1D(mat[i][j], w3);
            }
        }
        // 2. 沿着第2个维度 (d2) 滑动，窗口 w2
        int[][][] temp2 = new int[d1][d2 - w2 + 1][d3 - w3 + 1];
        for (int i = 0; i < d1; i++) {
            for (int k = 0; k < temp1[0][0].length; k++) {
                // 提取一列数据进行处理
                int[] colArray = new int[d2];
                for (int j = 0; j < d2; j++) {
                    colArray[j] = temp1[i][j][k];
                }
                int[] colResult = maxSlidingWindow1D(colArray, w2);
                // 将结果写回
                for (int j = 0; j < colResult.length; j++) {
                    temp2[i][j][k] = colResult[j];
                }
            }
        }
        // 3. 沿着第1个维度 (d1) 滑动，窗口 w1
        int[][][] result = new int[d1 - w1 + 1][d2 - w2 + 1][d3 - w3 + 1];
        for (int j = 0; j < temp2[0].length; j++) {
            for (int k = 0; k < temp2[0][0].length; k++) {
                // 提取一列数据进行处理
                int[] colArray = new int[d1];
                for (int i = 0; i < d1; i++) {
                    colArray[i] = temp2[i][j][k];
                }
                int[] colResult = maxSlidingWindow1D(colArray, w1);
                // 将结果写回
                for (int i = 0; i < colResult.length; i++) {
                    result[i][j][k] = colResult[i];
                }
            }
        }
        return result;
    }
    // 假设 maxSlidingWindow1D 已经实现 (可以使用 Deque 或分块法)
    public static int[] maxSlidingWindow1D(int[] nums, int k) {
        // 边界条件检查
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;
        // Deque 中存储的是数组的索引
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 1. 移除滑出窗口的队首索引
            // 窗口范围是 [i - k + 1, i]
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // 2. 从队尾移除所有小于当前元素的索引，以保持单调递减
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // 3. 将当前元素索引加入队尾
            deque.offerLast(i);
            // 4. 当窗口形成后 (i >= k - 1)，队首元素就是当前窗口的最大值
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
