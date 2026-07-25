package knowledge.mathematics.probability;

import knowledge.mathematics.probability.impl.ExpectationDP;
import leetcode.problems.LeetCode470;
import leetcode.problems.LeetCode837;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26 12:00
 * @description 概率、期望与随机算法精选模板及题型导航
 * <解题识别>
 * 1. 问“发生可能性” → 定义样本空间，使用条件概率、全概率或概率 DP。
 * 2. 问“平均需要多少步” → 定义状态期望，列 E=1+ΣpE' 方程。
 * 3. 当前状态可能原地不动 → 把自环项移到等式左边后再求解。
 * 4. 要把一种随机源变成另一种均匀随机源 → 等概率映射 + 拒绝采样。
 * <基础公式>
 * - 条件概率:P(A|B)=P(A∩B)/P(B)。
 * - 全概率:P(A)=ΣP(A|Bi)P(Bi)。
 * - 贝叶斯:P(Bi|A)=P(A|Bi)P(Bi)/P(A)。
 * - 期望线性:E[X+Y]=E[X]+E[Y]，不要求 X、Y 独立。
 * <I. 概率 DP>
 * dp[state] 表示到达状态的概率，按转移概率向后分配；窗口型转移可用前缀和优化。
 * @see LeetCode837 [M] 新 21 点
 * <II. 期望 DP>
 * dp[state] 表示从当前状态到终点的期望代价。若以概率 p 留在原地：
 * E=pE+(1-p)(cost+E')，必须先移项，不能把自环直接当普通转移。
 * @see ExpectationDP 收集不同点数的期望次数
 * @see knowledge.mathematics.probability.impl.GaussDP 高斯消元求带环期望DP
 * @see knowledge.mathematics.probability.impl.AliasMethod 别名采样法 (O(1)加权随机)
 * @see knowledge.mathematics.probability.impl.FisherYates Fisher-Yates洗牌算法
 * @see knowledge.mathematics.probability.impl.ReservoirSamplingK 水库抽样 (抽取K个)
 * @see knowledge.mathematics.probability.impl.WeightedReservoirSampling 带权水塘抽样 (A-Res)
 * @see knowledge.mathematics.probability.impl.QuickSelect 快速选择 (期望 O(n) 求第 k 小)
 * @see knowledge.mathematics.probability.impl.MarkovChain 马尔可夫链 (分布演化与稳态)
 * <III. 拒绝采样>
 * 先构造覆盖目标范围的等概率样本，多余区域全部丢弃重来，不能取模，否则会产生偏差。
 * @see LeetCode470 [M] 用 Rand7() 实现 Rand10()
 * <IV. 指示变量 / 贡献期望>
 * 把总量写成 ΣIi，则 E[ΣIi]=ΣP(Ii=1)。处理逆序对、命中数、覆盖数时常能避开联合分布。
 * @see knowledge.mathematics.probability.impl.IndicatorExpectation 指示变量法封闭式模板
 * <V. 随机选择 / 随机游走>
 * 快速选择用一次 partition 只递归 k 所在一侧，期望线性求第 k 小；
 * 马尔可夫链用行向量乘幂或幂迭代求 t 步分布与稳态 π（πP=π）。
 * @see knowledge.mathematics.probability.impl.QuickSelect
 * @see knowledge.mathematics.probability.impl.MarkovChain
 * <数值提醒>
 * 概率和应接近 1；double 比较使用 epsilon。状态数小且要求精确值时，可用分数或有理数。
 */
public interface Probability {
}
