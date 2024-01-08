package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 23:31
 */
public class LeetCode1838_sd {

    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int window = 0;
        Arrays.sort(nums);
        while (right < n) {
            int max = nums[right];
            window += nums[right];
            if (max * (right - left + 1) - window > k) {
                window -= nums[left];
                left++;
            }
            right++;
        }
        return right - left;
    }
}
