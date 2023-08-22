package basicKnowledge.algorithm.dynamicProgramming.knapsack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/13 12:23
 */
public interface Knapsack {
    //《算法导论》 P243页
    int backPack(int packageWeight, int[] goodsWeight, int[] goodsValue);
}
