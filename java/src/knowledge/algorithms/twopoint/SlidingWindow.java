package knowledge.algorithms.twopoint;

import knowledge.algorithms.twopoint.impl.slidingwindow.*;
import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 滑动窗口 (Sliding Window) 专题索引与模板导航。详细见《滑动窗口.xmind》
 * 用一对指针在序列上动态维护一个连续区间，使每次只增减边界元素，从而高效地处理区间问题，避免重复遍历整个区间。
 * <核心模板>
 * @see FixedSlidingWindow            定长窗口模板 (窗口大小固定为 K)
 * @see VariableSlidingWindowLongest  求最长的不定长窗口模板 (求满足条件的最大窗口)
 * @see VariableSlidingWindowShortest 求最短的不定长窗口模板 (求满足条件的最小窗口)
 * @see ExactSlidingWindow            恰好窗口模板 (转化为 atMost(K) - atMost(K-1))
 * @see MonotonicQueueSlidingWindow   单调队列窗口模板 (O(1) 获取窗口内极值)
 * <定长窗口>
 * @see LeetCode438    找到字符串中所有字母异位词
 * @see LeetCode567    字符串的排列
 * @see LeetCode1297   子串的最大出现次数
 * @see LeetCode1100   长度为 K 的无重复字符子串
 * @see LeetCode1004   最大连续1的个数 III
 * @see LeetCode424    替换后的最长重复字符
 * <不定长窗口>
 * * <最长窗口>
 * @see LeetCode3      无重复字符的最长子串
 * @see LeetCode30     串联所有单词的子串
 * * <最短窗口>
 * @see LeetCode76     最小覆盖子串
 * @see LeetCode209    长度最小的子数组
 * @see LeetCode1234   替换子串得到平衡字符串
 * @see LeetCode2904   最短且字典序最小的美丽子字符串
 * @see LeetCode632    最小区间
 * <恰好窗口>
 * @see LeetCode793    阶乘函数后 K 个零
 * @see LeetCode930    和相同的二元子数组
 * @see LeetCode992    K个不同整数的子数组
 * @see LeetCode1358   包含所有三种字符的子字符串数目
 * @see LeetCode795    区间子数组个数
 * @see LeetCode1248   统计「优美子数组」
 * @see LeetCode3306   元音辅音字符串计数 II
 * <转换窗口>
 * @see LeetCode2779   数组的最大美丽值
 * @see LeetCode2962   统计最大元素出现至少 K 次的子数组
 * @see LeetCode1151   最少交换次数来组合所有的 1
 */
public interface SlidingWindow {
}
