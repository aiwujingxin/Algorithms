package knowledge.algorithms.dp.backpack.complete;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/20 22:31
 * @description 完全背包 F[i,v] = max(F[i − 1, v] 不选 , F[i, v − Ci] + Wi 选)
 * @link <a href="https://www.lintcode.com/problem/440/">backPackIII</a>
 * @see LeetCode279     完全平方数
 * @see LeetCode322     零钱兑换
 * @see LeetCode518     零钱兑换II  物品循环在外面:组合数
 * @see LeetCode377     组合总和IV  物品循环在里面:排列数
 * @see LeetCode638     大礼包
 * @see LeetCode3592    硬币面值还原
 */
public interface CompletePack {

    /**
     * @param C 第i种物品的费用是Ci
     * @param W 第i种物品的价值是Wi
     * @param V 容量为V
     */
    int backPack(int[] C, int[] W, int V);
}
