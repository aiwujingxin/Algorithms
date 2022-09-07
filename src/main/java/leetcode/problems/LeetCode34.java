package leetcode.problems;

import java.util.Arrays;

/**
 * @author jingxinwu
 * @date 2021-06-18 1:24 上午
 */
public class LeetCode34 {

    public static void main(String[] args) {
        LeetCode34 leetCode34 = new LeetCode34();
        System.out.println(Arrays.toString(leetCode34.searchRange(new int[]{2, 2}, 2)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            if (nums[0] != target) {
                return res;
            } else {
                return new int[2];
            }
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {

            int mid = (right - left) / 2 + left;

            if (nums[mid] == target) {

                int i = mid;
                int j = mid;

                while (i > 0 && nums[i - 1] == nums[mid]) {
                    i--;
                }
                res[0] = i;
                while (j < nums.length - 1 && nums[j + 1] == nums[mid]) {
                    j++;
                }
                res[1] = j;

                return res;

            } else if (nums[mid] < target) {

                left = mid + 1;

            } else {
                right = mid - 1;
            }

        }
        return res;
    }
}
