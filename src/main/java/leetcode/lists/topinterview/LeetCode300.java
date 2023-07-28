package leetcode.lists.topinterview;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 12:56
 */
public class LeetCode300 {


    public static void main(String[] args) {
        System.out.println(new LeetCode300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(new LeetCode300().lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }

    //https://leetcode.com/problems/longest-increasing-subsequence/discuss/2164830/Java-7-approaches-brute-to-binary-search-%2B-2-approaches-to-print-LIS-intiuition-explained.
    //https://leetcode.com/problems/longest-increasing-subsequence/discuss/2397960/Java-DP-solution
    public int lengthOfLIS(int[] nums) {
        int result = 1;
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
    }
}

