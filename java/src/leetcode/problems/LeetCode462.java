package leetcode.problems;

import knowledge.algorithms.sort.QuickSelect;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/4 18:30
 * @description 贪心
 */
public class LeetCode462 {

    public int minMoves2(int[] nums) {
        int n = nums.length;
        int x = new QuickSelect().findKthLargest(nums, n / 2 + 1);
        int ret = 0;
        for (int num : nums) {
            ret += Math.abs(num - x);
        }
        return ret;
    }
}
