package basic.algorithm.sort;

import basic.datastructure.array.TopK;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/18 17:14
 */
public class QuickSelect implements TopK {

    @Override
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = partition(nums, left, right);
            if (index + 1 == k) {
                return nums[index];
            } else if (index + 1 > k) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return -1;
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
