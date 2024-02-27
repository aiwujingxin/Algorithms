package knowledge.dp.backpack.group;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/7 02:25
 * @description 分组背包
 * @see leetcode.problems.LeetCode1981
 */
public interface GroupPack {

    /**
     * @param N N组背包
     * @param m 背包容量m
     * @param C 每组M个物品
     * @param V 每组各个物品费用 V[k][i]
     * @param W 每组物品个数价值 W[k][i]
     */
    int backPack(int N, int m, int[] C, int[][] V, int[][] W);
}
