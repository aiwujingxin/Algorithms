package leetcode.lists.hot100;

import java.util.*;

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
        int left = bsearch_1(nums, target);
        int right = bsearch_2(nums, target);
        if (left == nums.length || nums[left] != target) {
            left = -1;
        }
        if (nums[right] != target) {
            right = -1;
        }
        return new int[]{left, right};
    }


    int bsearch_1(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    int bsearch_2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
