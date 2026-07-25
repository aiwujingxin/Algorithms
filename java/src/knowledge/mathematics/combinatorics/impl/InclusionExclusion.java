package knowledge.mathematics.combinatorics.impl;

import java.util.function.ToLongFunction;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 容斥原理通用模板 (Inclusion-Exclusion)
 * <本质>
 * |A_1 ∪ ... ∪ A_m| = Σ|A_i| - Σ|A_i∩A_j| + ... ，按交集阶数奇加偶减。
 * 枚举全部 2^m 个子集，用 popcount 的奇偶决定符号，把“至少一个成立”转成子集贡献之和。
 * <适用>
 * 求“不被任一集合覆盖”的补集计数、多重限制的方案数、GCD/互质相关计数。
 * measure 给出“同时属于该子集中所有集合”的元素数（或权值）。
 */
public class InclusionExclusion {

    /**
     * 通用容斥：subsetMeasure 接收一个子集位掩码，返回“同时满足该子集全部约束”的计数。
     * 返回并集大小 |A_1 ∪ ... ∪ A_m|。空集(mask=0)约定为全集，不参与并集求和。
     *
     * @param m             约束个数
     * @param subsetMeasure 位掩码 -> 满足掩码内全部约束的元素数
     */
    public static long unionSize(int m, ToLongFunction<Integer> subsetMeasure) {
        long result = 0;
        for (int mask = 1; mask < (1 << m); mask++) {
            long term = subsetMeasure.applyAsLong(mask);
            if ((Integer.bitCount(mask) & 1) == 1) {
                result += term;
            } else {
                result -= term;
            }
        }
        return result;
    }

    /**
     * 补集计数：全集大小 universe 减去并集，即“不满足任何一个约束”的元素数。
     */
    public static long complementSize(long universe, int m, ToLongFunction<Integer> subsetMeasure) {
        return universe - unionSize(m, subsetMeasure);
    }
}
