package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/4 18:30
 * @description 贪心
 * @see knowledge.algorithm.sort.QuickSelect
 */
public class LeetCode462 {

    public int minMoves2(int[] nums) {
        int n = nums.length;
        int index = findKthSmallest(nums, n / 2 + 1);
        int x = nums[index];
        int ret = 0;
        for (int num : nums) {
            ret += Math.abs(num - x);
        }
        return ret;
    }

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
