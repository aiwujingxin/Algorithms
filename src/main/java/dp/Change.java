package dp;
/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/17 23:41
 */
public class Change {
    public static void main(String[] args) {
        System.out.println(new Change().methodPermutation(new int[]{1 ,2},3));
        System.out.println(new Change().methoCombination(new int[]{1 ,2},3));
    }
    public int methodPermutation(int[] coins, int target) {

        if (coins == null || coins.length == 0 || target <= 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;  //tips:注意此处的1，表示构建0元只有1中方法：那就是不选
        for (int i = 0; i <= target; i++) {
            for (int coin : coins) {
                //排列组合tips【动态】：两层for循环顺序的差异是：coins在外面是求解排列数，coins在里面是是求解组合数
                //具体见解析：https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-iihe-pa-lou-ti-wen-ti-dao-di-yo/
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[target];
    }
    public int methoCombination(int[] coins, int target) {

        if (coins == null || coins.length == 0 || target <= 0) {
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;  //tips:注意此处的1，表示构建0元只有1中方法：那就是不选
        for (int coin : coins) {
            //VIPTips：for循环的差异是：一个求解结果是 排列数，一个求解结果是 组合数
            //具体见解析：https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-iihe-pa-lou-ti-wen-ti-dao-di-yo/
            for (int i = coin; i <= target; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[target];
    }
}
