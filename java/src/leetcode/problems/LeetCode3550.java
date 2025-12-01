package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 12/1/25 14:35
 */
public class LeetCode3550 {

    public int smallestIndex(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (cal(nums[i]) == i) {
                ans = Math.min(ans, i);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int cal(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
