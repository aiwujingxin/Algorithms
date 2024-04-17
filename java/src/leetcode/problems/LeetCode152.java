package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/17 14:56
 */
public class LeetCode152 {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        int res = nums[0];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int mx = max[i - 1];
            int mn = min[i - 1];
            max[i] = Math.max(Math.max(nums[i], nums[i] * mx), nums[i] * mn);
            min[i] = Math.min(Math.min(nums[i], nums[i] * mx), nums[i] * mn);
            res = Math.max(res, Math.max(max[i], min[i]));
        }
        return res;
    }
}


