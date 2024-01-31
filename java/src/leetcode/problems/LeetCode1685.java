package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/31 11:21
 */
public class LeetCode1685 {


    public int[] getSumAbsoluteDifferences(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int n = nums.length;
        int[] diff = new int[n + 1];
        diff[1] = nums[0];
        for (int i = 1; i < n; i++) {
            diff[i + 1] = nums[i] - nums[i - 1];
        }
        int[] res = new int[n];
        int[] presum = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            presum[i] = presum[i - 1] + diff[i] * (i - 1);
        }
        int[] suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + diff[i + 1] * (n - i);
        }
        for (int i = 1; i <= n; i++) {
            res[i - 1] = presum[i] + suffix[i];
        }
        return res;
    }
}
