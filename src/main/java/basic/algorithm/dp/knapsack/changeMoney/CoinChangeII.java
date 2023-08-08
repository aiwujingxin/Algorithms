package basic.algorithm.dp.knapsack.changeMoney;

import basic.problems.dp.ChangeMoney;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/5 00:31
 * <a href="https://aaronice.gitbook.io/lintcode/knapsack_problems/coin-change-ii">...</a>
 * <a href="https://leetcode.cn/problems/coin-change-ii/">LeetCode518</a>
 * {@link leetcode.problems.LeetCode518_dp_1d}
 */
public class CoinChangeII implements ChangeMoney {

    @Override
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;  //tips:注意此处的1，表示构建0元只有1中方法：那就是不选
        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                if (i >= coin) {
                    // 两层for循环顺序的差异是：
                    // coins在外面是求解组合数，
                    // coins在里面是是求解排列数
                    //具体见解析：https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-iihe-pa-lou-ti-wen-ti-dao-di-yo/
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
