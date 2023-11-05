package leetcode.problems;

import basic.algorithm.sort.RedixSort;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/13 21:45
 */
public class LeetCode164 {

    public int maximumGap(int[] nums) {
        new RedixSort().sortArray(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }
}
