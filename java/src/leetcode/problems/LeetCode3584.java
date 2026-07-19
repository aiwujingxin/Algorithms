package leetcode.problems;


/**
 * @author wujingxinit@outlook.com
 * @date 6/20/26 12:25
 */
public class LeetCode3584 {

    public long maximumProduct(int[] nums, int m) {
        int maxVal = nums[0];
        int minVal = nums[0];
        long ans = (long) nums[m - 1] * nums[0];
        for (int j = m; j < nums.length; j++) {
            int i = j - m + 1;
            if (nums[i] > maxVal) {
                maxVal = nums[i];
            } else if (nums[i] < minVal) {
                minVal = nums[i];
            }
            long p1 = (long) minVal * nums[j];
            long p2 = (long) maxVal * nums[j];
            ans = Math.max(ans, Math.max(p1, p2));
        }
        return ans;
    }
}
