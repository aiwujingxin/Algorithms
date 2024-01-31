package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/30 11:34
 */
public class LeetCode2789 {

    public long maxArrayValue(int[] nums) {
        long maxValue = 0;
        long currValue = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            currValue = nums[i] <= currValue ? nums[i] + currValue : nums[i];
            maxValue = Math.max(maxValue, currValue);
        }
        return maxValue;
    }
}
