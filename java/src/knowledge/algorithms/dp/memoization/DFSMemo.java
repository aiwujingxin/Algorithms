package knowledge.algorithms.dp.memoization;

import knowledge.algorithms.dp.memoization.problems.P1048;

/**
 * @author wujingxinit@outlook.com
 * @date 8/17/25 23:17
 * @description 用缓存保存递归过程中已经计算过的状态，避免重复计算，从而将指数级递归优化为多项式或线性复杂度
 * @see P1048
 * @see leetcode.problems.LeetCode3286
 * <方法一>
 * 1. 把这道题的 dp 状态和方程写出来
 * 2. 根据它们写出 dfs 函数
 * 3. 添加记忆化数组
 * <方法二>
 * 1. 写出这道题的暴搜程序（最好是 dfs）
 * 2. 将这个 dfs 改成「无需外部变量」的 dfs
 * 3. 添加记忆化数组
 */
public interface DFSMemo {
}
