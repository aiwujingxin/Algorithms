package knowledge.algorithms.twopoint;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/1 16:51
 * @description 滑动窗口 一个比较常用的双指针，所以单独拿出来整理 详细见《滑动窗口.xmind》
 * 用一对指针在序列上动态维护一个连续区间，使每次只增减边界元素，从而高效地处理区间问题，避免重复遍历整个区间
 * <定长窗口>
 * @see LeetCode1100   长度为 K 的无重复字符子串
 * @see LeetCode1151   最少交换次数来组合所有的 1
 * <不定长窗口>
 * @see LeetCode3      无重复字符的最长子串
 * * <最长窗口>
 * @see LeetCode3
 * @see LeetCode30
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
 * @see LeetCode2779
 */
public interface SlidingWindow {

    /*
    public int sd() {
        int l = 0;
        int r = 0;
        int res = 0;
        Window window = new Window();
        while (r < n) {
            window.add(a[r]);
            while (check(window)) { // 窗口不满足题意，则需要缩小 left:
                res = min(res, right - left + 1); // 最小窗口
                window.delete(a[l]);
                l++;
            }
            // 退出 while时，意味着window是满足题意的  // 最大窗口
            res = max(res, right - left + 1);
            r++;
        }
        return res;
     */
}
