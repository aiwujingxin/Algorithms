package leetcode;


/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/5 11:05
 */
public class LeetCode300_dp_1d {

    public static void main(String[] args) {
        System.out.println(new LeetCode300_dp_1d().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(new LeetCode300_dp_1d().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(new LeetCode300_dp_1d().lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        //fix case
        System.out.println(new LeetCode300_dp_1d().lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        //fix max
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = 0;
                if (nums[i] > nums[j]) {
                    temp = Math.max(temp, dp[j]);
                }
                dp[i] = Math.max(dp[i], temp + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}


