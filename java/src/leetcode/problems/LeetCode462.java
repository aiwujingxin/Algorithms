package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/4 18:30
 * @description 贪心
 */
public class LeetCode462 {

    public int minMoves2(int[] nums) {
        int n = nums.length;
        int index = quickSelect(nums, 0, nums.length - 1, n / 2 + 1);
        int x = nums[index];
        int ret = 0;
        for (int num : nums) {
            ret += Math.abs(num - x);
        }
        return ret;
    }

    public int quickSelect(int[] nums, int lo, int hi, int k) {
        if (lo > hi) {
            return -1;
        }
        int index = partition(nums, lo, hi);
        int rank = index + 1;
        if (rank == k) return index;
        if (rank > k) return quickSelect(nums, lo, index - 1, k);
        return quickSelect(nums, index + 1, hi, k);
    }

    private int partition(int[] nums, int i, int j) {
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
