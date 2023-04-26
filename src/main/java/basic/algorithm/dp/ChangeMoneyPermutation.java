package basic.algorithm.dp;

import basic.template.problems.ChangeMoney;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/24 23:48
 */
public class ChangeMoneyPermutation implements ChangeMoney {
    @Override
    public int change(int amount, int[] coins) {

        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;  //tips:注意此处的1，表示构建0元只有1中方法：那就是不选
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                //排列组合tips【动态】：
                // 两层for循环顺序的差异是：
                // coins在外面是求解组合数，
                // coins在里面是是求解排列数
                //具体见解析：https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-iihe-pa-lou-ti-wen-ti-dao-di-yo/
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
