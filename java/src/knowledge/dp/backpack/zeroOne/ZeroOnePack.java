package knowledge.dp.backpack.zeroOne;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/20 22:29
 * @description 01背包
 * @link <a href="https://www.lintcode.com/problem/125/">BackpackII</a>
 * @see leetcode.problems.LeetCode416 分割等和子集
 * @see leetcode.problems.LeetCode494 目标和
 */
public interface ZeroOnePack {
    int backPack(int[] weights, int[] values, int capacity);
}
