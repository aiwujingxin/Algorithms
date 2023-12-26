package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/26 17:22
 */
public class LeetCode396 {

    public int maxRotateFunction(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int n = nums.length;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            pre += i * nums[i];
        }
        int max = pre;
        for (int i = 1; i < n; i++) {
            pre = pre + (sum - (n) * nums[n - i]);
            max = Math.max(pre, max);
        }
        return max;
    }
}
