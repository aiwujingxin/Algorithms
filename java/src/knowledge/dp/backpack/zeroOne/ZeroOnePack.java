package knowledge.dp.backpack.zeroOne;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/20 22:29
 * @description 01背包  F[i,v] = max{F[i − 1,v], F[i − 1, v − Ci] + Wi}
 * @link <a href="https://www.lintcode.com/problem/125/">BackpackII</a>
 * @see leetcode.problems.LeetCode416 分割等和子集
 * @see leetcode.problems.LeetCode494 目标和
 * @see leetcode.problems.LeetCode474 一和零
 */
public interface ZeroOnePack {
    /**
     * @param C 第i种物品的费用是Ci
     * @param W 第i种物品的价值是Wi
     * @param V 容量为V
     */
    int backPack(int[] C, int[] W, int V);
}
