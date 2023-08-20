package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/12 21:43
 */
public class LeetCode1351 {

    public static void main(String[] args) {
        System.out.println(new LeetCode1351().helper(new int[]{3, 2}));
        System.out.println(new LeetCode1351().helper(new int[]{4, 3, 2, -1}));
        System.out.println(new LeetCode1351().helper(new int[]{3, 2, 1, -1}));
        System.out.println(new LeetCode1351().helper(new int[]{1, 1, -1, -2}));
        System.out.println(new LeetCode1351().helper(new int[]{-1, -1, -2, -3}));
    }

    public int countNegatives(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int[] nums : grid) {
            count += helper(nums);
        }
        return count;
    }

    private int helper(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
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
