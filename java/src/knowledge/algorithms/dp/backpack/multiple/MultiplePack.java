package knowledge.algorithms.dp.backpack.multiple;

import knowledge.algorithms.dp.backpack.lintcode.BackpackVII;
import knowledge.algorithms.dp.backpack.lintcode.BackpackVIII;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 00:03
 * @description 多重背包 实际上是01背包问题的扩展。同时是分组背包的特殊形式
 * @link <a href="https://github.com/cherryljr/LintCode/blob/master/Backpack%20VII.java"></a>
 * @see BackpackVII
 * @see BackpackVIII
 * @see leetcode.problems.LeetCode2585
 */
public interface MultiplePack {

    /**
     * @param C 第i种物品的费用是 Ci
     * @param W 第i种物品的价值是 Wi
     * @param K 第i种物品的数量是 Ki
     * @param V 背包容量为 V
     */
    int backPack(int[] C, int[] W, int[] K, int V);
}
