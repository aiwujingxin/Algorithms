package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/22 21:32
 */
public class LeetCode396 {

    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int f = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }

        int res = f;

        for (int i = 1; i < n; i++) {
            f = f + sum - n * nums[n - i];
            res = Math.max(res, f);
        }

        return res;
    }
}
