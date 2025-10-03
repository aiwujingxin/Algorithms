package leetcode.problems;

import knowledge.datastructure.heap.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/5/2 23:19
 */
public class LeetCode480_dualheap {

    public double[] medianSlidingWindow(int[] nums, int k) {
        MedianDualHeap<Integer> dh = new MedianDualHeap<>(k);
        for (int i = 0; i < k; ++i) {
            dh.add(nums[i]);
        }
        double[] ans = new double[nums.length - k + 1];
        ans[0] = dh.getMedian();
        for (int i = k; i < nums.length; ++i) {
            dh.add(nums[i]);
            dh.remove(nums[i - k]);
            ans[i - k + 1] = dh.getMedian();
        }
        return ans;
    }
}
