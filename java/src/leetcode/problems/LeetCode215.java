package leetcode.problems;

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
