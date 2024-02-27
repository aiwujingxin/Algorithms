package knowledge.dp.backpack.multiple;

import knowledge.dp.backpack.lintcode.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 00:03
 * @description 多重背包 实际上是01背包问题的扩展
 * @link <a href="https://github.com/cherryljr/LintCode/blob/master/Backpack%20VII.java"></a>
 * @see BackpackVII
 * @see BackpackVIII
 * @see leetcode.problems.LeetCode2585
 */
public interface MultiplePack {

    /**
     * @param C 第i种物品的费用是 Ci
     * @param W 第i种物品的价值是 Wi
     * @param S 第i种物品的数量是 Si
     * @param V 背包容量为 V
     */
    int backPack(int[] C, int[] W, int[] S, int V);
}
