package leetcode;

/**
 * @author jingxinwu
 * @date 2021-12-26 9:58 PM
 */
public class LeetCode518 {

    /**
     * 两层for循环顺序的差异是：
     * coins在外面:求解组合数
     * coins在里面:求解排列数
     * 具体见解析：<a href="https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-iihe-pa-lou-ti-wen-ti-dao-di-yo/">...</a>
     */

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }


    // 排列数
    public int method(int[] coins, int target) {
        if (coins == null || coins.length == 0 || target <= 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;  //tips:注意此处的1，表示构建0元只有1中方法：那就是不选
        for (int i = 0; i <= target; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[target];
    }
}