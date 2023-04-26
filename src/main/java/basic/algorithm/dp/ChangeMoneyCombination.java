package basic.algorithm.dp;

import basic.template.problems.ChangeMoney;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/24 23:49
 */
public class ChangeMoneyCombination implements ChangeMoney {
    @Override
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;  //tips:注意此处的1，表示构建0元只有1中方法：那就是不选
        for (int coin : coins) {
            //VIPTips：for循环的差异是：
            //一个求解结果是 排列数，一个求解结果是 组合数
            //具体见解析：https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-iihe-pa-lou-ti-wen-ti-dao-di-yo/
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
