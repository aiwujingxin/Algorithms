package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/26 17:22
 * @description 找规律 f(k)-f(k-1)
 */
public class LeetCode396 {

    public int maxRotateFunction(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int pre = 0;
        for (int i = 1; i < n; i++) {
            pre = pre + i * nums[i];
        }
        int max = pre;
        for (int i = 1; i < n; i++) {
            int cur = pre + (sum - n * nums[n - i]);
            max = Math.max(max, cur);
            pre = cur;
        }
        return max;
    }
}
