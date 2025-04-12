package knowledge.algorithms.sort;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 14:11
 * @description 排序算法
 * <题目>
 * @see LeetCode912 排序数组 https://leetcode.cn/problems/sort-an-array/
 * <稳定排序>
 * @see BubbleSort
 * @see InsertSort
 * @see MergeSort
 * @see CountingSort
 * @see RedixSort
 * @see BucketSort
 * <不稳定排序>
 * @see QuickSort
 * @see SelectSort
 * @see HeapSort
 * @see ShellSort
 */
public interface Sort {

    int[] sortArray(int[] nums);
}
