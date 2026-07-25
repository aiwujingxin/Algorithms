package knowledge.algorithms.dp.gamedp;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 博弈论 (Game Theory)
 * <两类模型>
 * 1) 博弈类 DP (minimax)：让对方赢不了，自己就能赢。区间 DP 在"博弈目标最大化"下的延伸，
 *    转移中交替 min/max 体现对手最优策略，适用于石子游戏等非公平/带数值的博弈。
 * 2) 公平组合游戏 (Impartial Game)：双人轮流、信息完全、无随机、无法操作者判负，
 *    用 SG 函数刻画局面胜负，多个独立子游戏的整体 SG 值为各子游戏 SG 的异或和。
 * <SG 核心结论>
 * 1) 必败态(P态) 当且仅当 SG=0；必胜态(N态) 当且仅当 SG≠0。
 * 2) SG(局面) = mex{ SG(所有后继局面) }，mex 为不在集合中的最小非负整数。
 * 3) 游戏和定理(SG 定理)：SG(G1+G2+...) = SG(G1) ^ SG(G2) ^ ...
 * @see NimGame       Nim / Bash / Wythoff 博弈
 * @see SpragueGrundy SG 函数 (mex 打表 + 游戏和)
 * @see LeetCode292  Nim 游戏
 * @see LeetCode1025 除数博弈
 * @see LeetCode464  我能赢吗
 * @see LeetCode486  预测赢家
 * @see LeetCode877  石子游戏
 * @see LeetCode1140 石子游戏 II
 * @see LeetCode1406 石子游戏 III
 * @see LeetCode1510 石子游戏 IV
 */
public interface GameDP {
}
