package leetcode.problems;

import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/22 21:23
 * @see basic.algorithm.sort.QuickSelect
 */
public class LeetCode462 {

    public int minMoves2(int[] nums) {
        int n = nums.length;
        int x = quickSelect(nums, 0, n - 1, n / 2);
        int ret = 0;
        for (int num : nums) {
            ret += Math.abs(num - x);
        }
        return ret;
    }

    public int quickSelect(int[] nums, int left, int right, int index) {
        int q = partition(nums, left, right);
        if (q == index) {
            return nums[q];
        }
        return q < index ? quickSelect(nums, q + 1, right, index) : quickSelect(nums, left, q - 1, index);
    }

    private int partition(int[] nums, int i, int j) {
        int ri = new Random().nextInt(j - i + 1) + i; // 随机选一个作为我们的主元
        swap(nums, ri, i);
        int pi = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= pi) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= pi) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pi;
        return i;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
