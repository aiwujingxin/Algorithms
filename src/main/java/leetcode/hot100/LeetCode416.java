package leetcode.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/5 12:07
 */
public class LeetCode416 {

    //https://www.youtube.com/watch?v=z_VLFGzQQtk

    //和零钱兑换类似 322

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        for (int num : nums) {
            // 为什么从后往前遍历
            // 硬币只能用一次，从左往右遍历，会重复拿硬币，后面的结果会受到前面的影响
            // 从右向左遍历，越减越小，左边的不会受右边的影响
            // https://xth8013.com/website/blogArticle/detail/111
            for (int currSum = target; currSum > 0; currSum--) {
                if (currSum - num >= 0) {
                    dp[currSum] = dp[currSum] || dp[currSum - num];
                }
            }
        }
        return dp[target];
    }
}