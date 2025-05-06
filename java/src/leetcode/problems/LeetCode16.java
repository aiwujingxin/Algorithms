package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/23 14:24
 */
public class LeetCode16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) return sum;
                if (Math.abs(sum - target) < Math.abs(res - target)) res = sum;
                if (sum < target) l++;
                else r--;
            }
        }
        return res;
    }
}
