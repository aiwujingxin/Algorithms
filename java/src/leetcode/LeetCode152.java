package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/17 19:20
 */
public class LeetCode152 {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long[] max = new long[nums.length];
        long[] min = new long[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        long res = Long.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            long mx = max[i - 1];
            long mn = min[i - 1];
            max[i] = Math.max(Math.max(nums[i], mn * nums[i]), mx * nums[i]);
            min[i] = Math.min(Math.min(nums[i], mn * nums[i]), mx * nums[i]);
            if (min[i] < Integer.MIN_VALUE) {
                min[i] = 0; // 添加这个判断
            }
            res = Math.max(Math.max(res, max[i]), min[i]);
        }
        return (int) res;
    }
}
