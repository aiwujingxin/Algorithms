package basic.algorithm.twopoint;

import leetcode.problems.LeetCode674;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/1 16:51
 * @see LeetCode674 连续最长递增子序列
 */
public interface SlidingWindow {

    /*

    滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 [i,j)（左闭，右开）。
    而滑动窗口是可以将两个边界向某一方向“滑动”的窗口

      for (int i = 0, j = 0; i < n; i ++ )
      {
          while (j < i && check(i, j)) {j ++ ;}
          // 具体问题的逻辑
      }
      常见问题分类：
          (1) 对于一个序列，用两个指针维护一段区间
          (2) 对于两个序列，维护某种次序，比如归并排序中合并两个有序序列的操作
     */
}
