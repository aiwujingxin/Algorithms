package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/24 23:15
 */
public class LeetCode518 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;// 注意此处的1，表示构建0元只有1中方法：那就是不选
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
