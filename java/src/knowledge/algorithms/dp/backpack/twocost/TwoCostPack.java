package knowledge.algorithms.dp.backpack.twocost;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/27 16:31
 * @description 二维费用的背包问题 和 01背包很像
 * @see 1020.cpp 潜水员 最低限度
 * LeetCode1995
 */
public interface TwoCostPack {

    /**
     * @param N       N个物品
     * @param V       最大容量 V
     * @param W       最大重量 W
     * @param volumes 第i种物品的体积 volumes[i]
     * @param weights 第i种物品的重量 weights[i]
     * @param values  第i种物品的价值 values[i]
     */
    int backPack(int N, int V, int W, int[] volumes, int[] weights, int[] values);

}