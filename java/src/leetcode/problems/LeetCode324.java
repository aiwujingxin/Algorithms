package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/17 00:48
 * @see knowledge.algorithms.sort.QuickSelect
 * @see LeetCode75

 */
public class LeetCode324 {

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        int index = n - 1;
        for (int i = 1; i < n; i += 2, index--) {
            nums[i] = sorted[index];
        }
        for (int i = 0; i < n; i += 2, index--) {
            nums[i] = sorted[index];
        }
    }

    public void wiggleSort_quickselect(int[] nums) {
        int n = nums.length;
        int mid = (n + 1) / 2;
        // 中位数
        int target = findKthLargest(nums, mid, 0, nums.length - 1);
        // 分成「小于 x / 等于 x / 大于 x」三段 荷兰国旗
        split(nums, target);
        int[] arr = nums.clone();
        for (int i = 0, j = mid - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }

    public int findKthLargest(int[] nums, int k, int left, int right) {
        if (left > right) {
            return -1;
        }
        int index = partition(nums, left, right);
        if (index == k - 1) {
            return nums[index];
        }
        if (index > k - 1) {
            return findKthLargest(nums, k, left, index - 1);
        }
        return findKthLargest(nums, k, index + 1, right);
    }

    private int partition(int[] nums, int i, int j) {
        int pi = nums[i];
        while (i < j) {
            while (i < j && nums[j] <= pi) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] >= pi) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pi;
        return i;
    }

    private void split(int[] nums, int target) {
        int p0 = 0;
        int p2 = nums.length - 1;
        int index = 0;
        while (index <= p2) {
            if (nums[index] < target) {
                swap(nums, index, p0);
                index++;
                p0++;
            } else if (nums[index] == target) {
                index++;
            } else {
                swap(nums, index, p2);
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
