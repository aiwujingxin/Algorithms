package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/1 16:11
 */
public class LeetCode1695 {

    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        while (right < nums.length) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            sum += nums[right];
            max = Math.max(max, sum);
            right++;
        }
        return max;
    }
}
