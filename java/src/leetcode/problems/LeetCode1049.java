package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/2/23 23:15
 * <a href="https://leetcode.cn/problems/last-stone-weight-ii/solution/gong-shui-san-xie-xiang-jie-wei-he-neng-jgxik/">...</a>
 * 可以转化为: <a href="https://www.lintcode.com/problem/92/description">...</a>
 * <a href="https://www.lintcode.com/problem/92/solution/17247">题解</a>
 * @description 为原来 stones 数组中的数字添加 +/− 符号，形成的“计算表达式”, 使得形成的「计算表达式」结果绝对值最小
 * -> 从 stones 数组中选择，凑成总和不超过sum/2 的最大价值
 */
public class LeetCode1049 {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }
        return sum - 2 * dp[target];
    }
}
