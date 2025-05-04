package leetcode.problems;

import knowledge.algorithms.sort.QuickSelect;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/17 00:48
 * @see LeetCode75
 */
public class LeetCode324 {

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int mid = (n + 1) / 2 - 1;// 1. `n + 1` 是为了在奇数长度时让左半部分多一个元素；; 2. `-1` 获取前一半的最后一个索引。
        int end = n - 1;
        for (int i = 0; i < n; i++) {
            nums[i] = (i % 2 == 0) ? sorted[mid--] : sorted[end--];
        }
    }

    public void wiggleSort_quickselect(int[] nums) {
        int n = nums.length;
        // 1. 找中位数 // 偏左中位数: (n + 1) / 2; 偏右中位数: n / 2 + 1
        int median = new QuickSelect().findKthLargest(nums, (n + 1) / 2);
        // 2. 三路划分 分成「小于 x / 等于 x / 大于 x」三段
        split(nums, median);
        // 3. 重新排序
        int[] arr = nums.clone();
        int mid = (n + 1) / 2 - 1;
        int end = n - 1;
        for (int i = 0; i < n; i++) {
            nums[i] = (i % 2 == 0) ? arr[mid--] : arr[end--];
        }
    }

    private void split(int[] nums, int target) {
        int p0 = 0;
        int p2 = nums.length - 1;
        int i = 0;
        while (i <= p2) {
            if (nums[i] < target) {
                swap(nums, i, p0);
                p0++;
                i++;
            } else if (nums[i] == target) {
                i++;
            } else {
                swap(nums, i, p2);
                p2--;
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
