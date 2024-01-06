package basic.algorithm.dp.knapsack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/13 12:23
 * @description 背包问题
 */
public interface Knapsack {
    //《算法导论》 P243页
    int backPack(int[] weights, int[] values, int capacity);
}
