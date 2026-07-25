package knowledge.algorithms.divideconquer;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 最大子数组和 (分治解法)
 * <适用场景>
 * 展示分治"划分-求解-合并"范式：最大子段和除 Kadane 外的经典 O(n log n) 分治写法。
 * <核心>
 * 答案要么完全在左半、要么完全在右半、要么跨越中点。
 * 跨越情形从中点分别向左、向右扩展求最大前缀/后缀和再相加，取三者最大。
 * @see leetcode.problems.LeetCode53 最大子数组和
 */
public class MaxSubArrayDivide {

    public static int maxSubArray(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }

    private static int solve(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = (left + right) >>> 1;
        int leftBest = solve(nums, left, mid);
        int rightBest = solve(nums, mid + 1, right);
        int crossBest = crossSum(nums, left, mid, right);
        return Math.max(Math.max(leftBest, rightBest), crossBest);
    }

    // 必须跨越 mid 与 mid+1 的最大子段和
    private static int crossSum(int[] nums, int left, int mid, int right) {
        int sum = 0, leftMax = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftMax = Math.max(leftMax, sum);
        }
        sum = 0;
        int rightMax = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightMax = Math.max(rightMax, sum);
        }
        return leftMax + rightMax;
    }
}
