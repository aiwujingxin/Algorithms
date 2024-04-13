package knowledge.algorithms.twopoint;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/1 16:51
 * @description 滑动窗口  滑动窗口是一个比较特殊的双指针，所以单独拿出来整理
 * 滑动窗口是数组/字符串问题中常用的抽象概念。是可以将两个边界向某一方向“滑动”的窗口
 * 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 [i,j]。
 * 详细见《滑动窗口.xmind》
 * <定长窗口>
 * @see LeetCode1100 1100. 长度为 K 的无重复字符子串
 * @see LeetCode1151 1151. 最少交换次数来组合所有的 1
 * <最长窗口>
 * @see LeetCode3
 * @see LeetCode30
 * <最短窗口>
 * @see LeetCode76 最小覆盖子串
 * @see LeetCode209 209. 长度最小的子数组
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
