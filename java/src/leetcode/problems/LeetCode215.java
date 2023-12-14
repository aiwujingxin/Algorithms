package leetcode.problems;

import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 13:53
 */
public class LeetCode215 {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return find(nums, 0, nums.length - 1, k);
    }

    public int find(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[start];
        }
        int index = partition(nums, start, end);
        if (index + 1 == k) {
            return nums[index + 1];
        }
        if (index + 1 < k) {
            return find(nums, index + 1, end, k);
        }
        return find(nums, start, index - 1, k);
    }


    public int partition(int[] nums, int i, int j) {
        int ri = new Random().nextInt(j - i + 1) + i; // 随机选一个作为我们的主元
        swap(nums, ri, i);
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

    private void swap(int[] nums, int ri, int i) {
        int temp = nums[i];
        nums[i] = nums[ri];
        nums[ri] = temp;
    }
}
