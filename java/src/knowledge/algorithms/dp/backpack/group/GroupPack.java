package knowledge.algorithms.dp.backpack.group;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/7 02:25
 * @description 分组背包
 * @see leetcode.problems.LeetCode1981
 * @link <a href="https://www.acwing.com/problem/content/1015/">机器分配</a>
 */
public interface GroupPack {

    /**
     * @param N N组背包
     * @param m 背包容量m
     * @param K 每组K个物品
     * @param C 每组各个物品费用 C[k][i]
     * @param W 每组物品个数价值 W[k][i]
     */
    int backPack(int N, int m, int[] K, int[][] C, int[][] W);
}
