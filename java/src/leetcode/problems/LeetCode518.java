package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/24 23:15
 * coins 在外面:组合数 在里面:排列数
 * @link <a href="https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-iihe-pa-lou-ti-wen-ti-dao-di-yo/">...</a>
 */
public class LeetCode518 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;// 注意此处的1，表示构建0元只有1中方法：那就是不选
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public int permutation(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
