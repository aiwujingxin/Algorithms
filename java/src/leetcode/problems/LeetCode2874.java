package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 5/3/25 21:27
 */
public class LeetCode2874 {

    public long maximumTripletValue(int[] nums) {
        long res = Integer.MIN_VALUE;
        int n = nums.length;
        long[] kArr = new long[n];
        long[] jArr = new long[n];
        long rmax = nums[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            kArr[i] = rmax;
            rmax = Math.max(rmax, nums[i]);
        }
        long lmax = nums[0];
        for (int i = 0; i < n; i++) {
            jArr[i] = lmax;
            lmax = Math.max(lmax, nums[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            res = Math.max(res, (jArr[i] - nums[i]) * kArr[i]);
        }
        return Math.max(res, 0);
    }
}
