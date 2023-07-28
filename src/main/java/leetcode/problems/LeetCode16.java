package leetcode.problems;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2021-06-16 11:17 下午
 */
public class LeetCode16 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    if (Math.abs(sum - target) < diff) {
                        res = sum;
                        diff = Math.abs(sum - target);
                    }
                    l++;
                } else if (sum > target) {
                    if (Math.abs(sum - target) < diff) {
                        res = sum;
                        diff = Math.abs(sum - target);
                    }
                    r--;
                }
            }
        }
        return res;
    }
}
