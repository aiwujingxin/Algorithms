package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/1 22:27
 */
public class LeetCode152 {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = nums[0];
        min[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            int mx = max[i - 1];
            int mn = min[i - 1];
            max[i] = Math.max(Math.max(mx * nums[i], mn * nums[i]), nums[i]);
            min[i] = Math.min(Math.min(mx * nums[i], mn * nums[i]), nums[i]);
            res = Math.max(res, Math.max(max[i], min[i]));
        }
        return res;
    }
}
