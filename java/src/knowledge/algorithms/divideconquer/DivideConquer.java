package knowledge.algorithms.divideconquer;

import leetcode.problems.lists.lcci.LCCI0806;
import leetcode.problems.LeetCode23;
import leetcode.problems.LeetCode241;
import leetcode.problems.LeetCode324;
import leetcode.problems.LeetCode932;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/30 22:45
 * @description 分治
 * <解题识别>
 * 问题可拆成若干同构子问题、子解能在合并阶段 O(n) 或 O(n log n) 汇总时，用分治。
 * 关键在 merge：跨越划分点的贡献往往是分治的核心难点（逆序对、最大子段、最近点对）。
 * <核心模板>
 * @see InversionCount                                          归并求逆序对 (跨中线统计)
 * @see MaxSubArrayDivide                                       最大子段和分治解 (划分+跨越合并)
 * @see CDQDivideConquer                                        CDQ 分治 (三维偏序 / 陌上花开)
 * @see knowledge.mathematics.geometry.impl.ClosestPair         最近点对分治
 * @see knowledge.mathematics.bigdecimal.impl.Karatsuba         大整数乘法分治
 * @see knowledge.algorithms.binarylifting.QuickPow             快速幂 (指数二分分治)
 * <经典题目>
 * @see LCCI0806 汉诺塔
 * @see MergeSort
 * @see QuickSort
 * @see LeetCode23 合并 K 个升序链表
 * @see LeetCode241 为运算表达式设计优先级
 * @see LeetCode324 摆动排序 II
 * @see LeetCode932 漂亮数组
 */
public interface DivideConquer {

    /*
     * divide(P) {
     * if(P <= n) solve(P);// 解决小规模的问题
     * divide P into smaller sub-instances P1 P2...Pk ; //分解问题
     * for(int i = 1; i<= k;i++ ) {
     * yi = divide(Pi); // 递归的解各个子问题
     * }
     * return merge(y1,y2..yk) //将各个子问题的解合并为原问题的解
     * }
     */
}
