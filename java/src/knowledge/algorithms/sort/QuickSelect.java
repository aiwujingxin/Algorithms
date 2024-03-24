package knowledge.algorithms.sort;

import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/9 21:08
 */

public class QuickSelect implements TopK {

    @Override
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    public int findKthLargest(int[] nums, int lo, int hi, int k) {
        if (lo > hi) {
            return -1;
        }
        int index = partition(nums, lo, hi);
        if (index == k - 1) {
            return nums[index];
        }
        if (index > k - 1) {
            return findKthLargest(nums, lo, index - 1, k);
        }
        return findKthLargest(nums, index + 1, hi, k);
    }

    private int partition(int[] nums, int i, int j) {
        int rand = new Random().nextInt(j - i + 1) + i;
        swap(nums, rand, i);
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

    private void swap(int[] nums, int rand, int i) {
        int t = nums[rand];
        nums[rand] = nums[i];
        nums[i] = t;
    }
}
