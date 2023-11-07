package basic.algorithm.dp.knapsack;

import leetcode.problems.LeetCode322;
import leetcode.problems.LeetCode518;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/13 13:33
 * @see LeetCode322 01背包
 * @see LeetCode518 完全背包 凑成总金额的硬币组合数
 */
public interface ChangeMoney {
    int change(int amount, int[] coins);
}
