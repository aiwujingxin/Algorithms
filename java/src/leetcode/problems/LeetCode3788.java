package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 6/15/26 23:31
 */
public class LeetCode3788 {

    public long maximumScore(int[] nums) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] += pre[i - 1] + nums[i - 1];
        }
        int min = nums[n - 1];
        int[] suf = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = min;
            min = Math.min(min, nums[i]);
        }
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, pre[i + 1] - suf[i]);
        }
        return ans;
    }
}
