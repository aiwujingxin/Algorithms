package knowledge.dp.backpack.complete;


/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/20 22:31
 * @description 完全背包
 * @link <a href="https://www.lintcode.com/problem/440/">backPackIII</a>
 * @see leetcode.problems.LeetCode322 零钱兑换
 * @see leetcode.problems.LeetCode518 凑成总金额的硬币组合数
 */
public interface CompletePack {
    int backPack(int[] weights, int[] values, int capacity);
}
