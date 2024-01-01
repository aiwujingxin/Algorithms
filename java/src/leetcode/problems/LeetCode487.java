package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/16 23:43
 * @see LeetCode1004
 */
public class LeetCode487 {

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        if (nums[0] == 1) {
            dp[0][0] = 1;
        } else {
            dp[0][1] = 1;
        }
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                dp[i][0] = 0;
                dp[i][1] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] + 1;
            }
            max = Math.max(Math.max(max, dp[i][0]), dp[i][1]);
        }
        return max;
    }

    public int findMaxConsecutiveOnes_sd(int[] nums) {
        int ans = 1;
        int cnt = 0;
        int right = 0;
        int left = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                cnt++;
            }
            //找出最大的窗口，使得窗口内的0的个数不超过1个。
            while (cnt > 1) {
                if (nums[left] == 0) {
                    cnt--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
