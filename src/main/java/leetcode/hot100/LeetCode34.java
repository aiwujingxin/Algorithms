package leetcode.hot100;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 01:36
 */
public class LeetCode34 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                int n = mid;
                int m = mid;

                while (n > 0 && nums[n - 1] == target) {
                    n = n - 1;
                }
                while (m < nums.length - 1 && nums[m + 1] == target) {
                    m = m + 1;
                }
                return new int[]{n, m};
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return new int[]{-1, -1};

    }
}
