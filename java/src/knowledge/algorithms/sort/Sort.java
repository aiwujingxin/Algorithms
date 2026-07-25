package knowledge.algorithms.sort;

import knowledge.algorithms.sort.comparison.*;
import knowledge.algorithms.sort.noncomparison.BucketSort;
import knowledge.algorithms.sort.noncomparison.CountingSort;
import knowledge.algorithms.sort.noncomparison.RadixSort;
import knowledge.algorithms.sort.selection.HeapSelect;
import knowledge.algorithms.sort.selection.QuickSelect;
import knowledge.algorithms.sort.selection.TopK;
import leetcode.problems.LeetCode912;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 排序算法体系索引
 * <核心题目>
 * @see LeetCode912 排序数组 (https://leetcode.cn/problems/sort-an-array/)
 * <比较排序 (Comparison Sorts)>
 * - 稳定排序
 * @see BubbleSort   冒泡排序 O(N^2)
 * @see InsertSort   插入排序 O(N^2)
 * @see MergeSort    归并排序 O(N log N)
 * - 不稳定排序
 * @see SelectSort   选择排序 O(N^2)
 * @see ShellSort    希尔排序 O(N log^2 N)
 * @see QuickSort    快速排序 O(N log N)
 * @see HeapSort     堆排序 O(N log N)
 * <非比较排序 (Non-Comparison Sorts)>
 * - 均为稳定排序，原生支持负数
 * @see CountingSort 计数排序 O(N + K)
 * @see RadixSort    基数排序 O(N * d)
 * @see BucketSort   桶排序 O(N + K)
 * <选择算法与特定排序>
 * @see TopK         TopK问题导航接口
 * @see QuickSelect  快速选择算法 O(N)
 * @see HeapSelect   堆选择算法 O(N log K)
 * @see IndexingSort 原址排序 (数组原地归位)
 */
public interface Sort {

    int[] sortArray(int[] nums);
}
