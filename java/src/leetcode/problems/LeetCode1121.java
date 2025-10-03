package leetcode.problems;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 8/19/25 12:50
 */
public class LeetCode1121 {

    public boolean canPartition(int[] nums, int K) {
        // 使用最小堆来维护各个子序列的尾部元素
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 遍历每个数字
        for (int num : nums) {
            // 如果堆不为空，并且堆顶元素小于等于当前数字，说明可以加入现有的子序列
            if (!heap.isEmpty() && heap.peek() <= num) {
                heap.poll();  // 弹出堆顶元素，表示这个子序列被更新了
            }
            // 将当前数字加入到新的子序列
            heap.add(num);
        }

        // 检查每个子序列的长度是否大于等于 K
        return heap.size() >= K;
    }
}
