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

    public int findKthLargest(int[] nums, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int index = partition(nums, start, end);
        if (index + 1 == k) {
            return nums[index];
        }
        if (index + 1 < k) {
            return findKthLargest(nums, index + 1, end, k);
        }
        return findKthLargest(nums, start, index - 1, k);
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

    @Override
    public int findKthSmallest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int pos = rpart(nums, left, right);
            if (pos + 1 == k) {
                return pos;
            } else if (pos + 1 > k) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
        return -1;
    }

    private int rpart(int[] nums, int i, int j) {
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
}
