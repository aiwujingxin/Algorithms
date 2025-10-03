package leetcode.problems;

import knowledge.algorithms.dp.backpack.lintcode.problems.BackpackI;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/2/23 23:15
 * @link <a href="https://leetcode.cn/problems/last-stone-weight-ii/solution/gong-shui-san-xie-xiang-jie-wei-he-neng-jgxik/">...</a>
 * @see BackpackI
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
