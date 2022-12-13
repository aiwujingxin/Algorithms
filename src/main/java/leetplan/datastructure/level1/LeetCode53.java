package leetplan.datastructure.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/6 17:52
 */
public class LeetCode53 {

    //[-2,1,-3,4,-1,2,1,-5,4]

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = nums[0];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 1], 0);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
