package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/24 23:15
 * @description 组合数
 */
public class LeetCode518 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;// 注意此处的1，表示构建0元只有1中方法：那就是不选
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
