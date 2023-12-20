package basic.algorithm.twopoint;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/1 16:51
 * @description 常见问题分类：
 * (1) 对于一个序列，用两个指针维护一段区间
 * (2) 对于两个序列，维护某种次序，比如归并排序中合并两个有序序列的操作
 * </p>
 * 详细见xmind
 * @see leetcode.problems.LeetCode3
 * @see leetcode.problems.LeetCode30
 * @see leetcode.problems.LeetCode76 最小覆盖子串
 */
public interface SlidingWindow {

    /*
    滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 [i,j)（左闭，右开）。
    而滑动窗口是可以将两个边界向某一方向“滑动”的窗口
    public int windowTemplate() {
        int left = 0;
        int right = 0;
        int res = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            // 添加新的元素进 window 或者需要维护其他的题目中需要的变量
            while (// 窗口不满足题意，则需要缩小 left: left< right && !check(window)) {
                char d = s.charAt(left);
                // 删除 window 中 left 所在的元素
                left++;
            }
            // 退出 while，意味着window是满足题意的
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
     */
}
