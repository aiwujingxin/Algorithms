package leetcode;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 23:31
 */
public class LeetCode1838_fast {

    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0, window = 0;
        Arrays.sort(nums);
        while (right < n) {
            int max = nums[right];
            int count = right - left + 1;
            window += nums[right];
            right++;
            if (max * count - window > k) {
                window -= nums[left];
                left++;
            }
        }
        return right - left;
    }
}
