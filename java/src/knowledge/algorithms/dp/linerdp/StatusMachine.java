package knowledge.algorithms.dp.linerdp;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/13 23:36
 * @description 状态机模型
 * <本质>
 * 将问题抽象成一个在多个状态之间按照特定规则（转移边）进行转换的过程（状态机）。
 * 在经过一系列操作（步骤）后，处于某个（或某些）状态的所有方案数（计数）或最优值（最值）。
 * <应用>
 * 有明确步骤或阶段的问题（如移动步数、天数、操作次数等）。每个步骤下，系统可能处于有限种不同的状态。
 * <步骤>
 * 1.定义状态含义
 * 2.状态转移依赖图
 * 3.确定初始状态（起点）
 * 4.计算最终结果 遍历所有转移的情况 按照题意进行转移方程(计数, 最值)
 * <买卖股票>
 * @see LeetCode121  买卖股票的最佳时机     一次交易次数
 * @see LeetCode122  买卖股票的最佳时机 II  不限交易次数
 * @see LeetCode123  买卖股票的最佳时机 III 最多交易2次
 * @see LeetCode188  买卖股票的最佳时机 IV  最多交易k次
 * @see LeetCode309  最佳买卖股票时机含冷冻期
 * @see LeetCode714  买卖股票的最佳时机含手续费
 * <打家劫舍>
 * @see LeetCode198  打家劫舍
 * @see LeetCode213  打家劫舍II
 * @see LeetCode337  打家劫舍III
 * <其他>
 * @see LeetCode91   解码方法
 * @see LeetCode376  摆动序列
 * @see LeetCode2222 选择建筑的方案数
 * @see LeetCode935  骑士拨号器
 */
public interface StatusMachine {
}
