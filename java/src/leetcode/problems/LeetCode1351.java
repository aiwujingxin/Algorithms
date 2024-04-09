package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/12 21:43
 */
public class LeetCode1351 {

    public int countNegatives(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int[] nums : grid) {
            count += search(nums);
        }
        return count;
    }

    private int search(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (r == nums.length - 1) {
            return nums[nums.length - 1] < 0 ? 1 : 0;
        }
        return nums.length - 1 - r + 1;
    }
}
