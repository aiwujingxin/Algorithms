package knowledge.algorithms.binarylifting;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/7 02:32
 * @description 倍增
 * <解题识别>
 * 状态转移可拆成 2 的幂次跳跃、且区间/祖先可预处理时，用倍增把线性跳跃降到对数。
 * <核心模板>
 * @see QuickPow          快速幂 / 模幂 / 矩阵快速幂 (倍增最小原型)
 * @see SparseTable       ST 表 (区间最值 / GCD 的 O(1) 查询)
 * @see BinaryLiftingLCA  倍增求 LCA / 第 K 祖先 / 树上距离
 * <快速幂>
 * @see leetcode.problems.LeetCode50   Pow(x, n)
 * @see leetcode.problems.LeetCode29   两数相除
 * @see leetcode.problems.LeetCode2241 设计一个 ATM 机器
 * @see leetcode.problems.LeetCode1220 统计元音字母序列的数目 (矩阵快速幂)
 * @see leetcode.problems.LeetCode466  统计重复个数 (倍增预处理)
 * <LCA / 第 K 祖先>
 * @see leetcode.problems.LeetCode236  二叉树的最近公共祖先
 * @see leetcode.problems.LeetCode235  二叉搜索树的最近公共祖先
 */
public interface BinaryLifting {
}
