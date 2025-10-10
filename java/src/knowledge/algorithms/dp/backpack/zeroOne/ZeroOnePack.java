package knowledge.algorithms.dp.backpack.zeroOne;

import knowledge.algorithms.dp.memoization.problems.P1048;
import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/20 22:29
 * @description 01背包  F[i,v] = max{F[i − 1,v] 不选, F[i − 1, v − Ci] + Wi 选}
 * @link <a href="https://www.lintcode.com/problem/125/">BackpackII</a>
 * @see P1048           采药
 * @see LeetCode416     分割等和子集
 * @see LeetCode494     目标和  01背包组合数
 * @see LeetCode474     一和零
 * @see LeetCode1049    最后一块石头的重量II 转化
 * @see LeetCode2915    和为目标值的最长子序列的长度
 */
public interface ZeroOnePack {
    /**
     * @param C 第i种物品的费用是Ci
     * @param W 第i种物品的价值是Wi
     * @param V 容量为V
     */
    int backPack(int[] C, int[] W, int V);
}
