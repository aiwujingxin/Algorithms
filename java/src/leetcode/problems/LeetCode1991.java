package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/12 14:25
 */
public class LeetCode1991 {

    public int findMiddleIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;

        int[] sum = new int[n + 1];
        sum[n - 1] = nums[n - 1];
        for (int i = sum.length - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + nums[i];
        }
        int t = 0;
        for (int i = 0; i < n; i++) {
            if (t == sum[i + 1]) {
                return i;
            }
            t += nums[i];
        }
        return -1;
    }
}
