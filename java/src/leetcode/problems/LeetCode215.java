package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/17 21:28
 */
public class LeetCode215 {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return findK(nums, 0, nums.length - 1, k);
    }

    public int findK(int[] nums, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int index = partition(nums, start, end);
        if (index + 1 == k) {
            return nums[index];
        } else if (index < k) {
            return findK(nums, index + 1, end, k);
        } else {
            return findK(nums, start, index - 1, k);
        }
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
}
