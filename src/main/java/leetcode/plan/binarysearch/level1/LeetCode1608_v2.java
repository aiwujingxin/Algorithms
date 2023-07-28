package leetcode.plan.binarysearch.level1;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/11 19:46
 */
public class LeetCode1608_v2 {

    public static void main(String[] args) {
        System.out.println(new LeetCode1608_v2().specialArray(new int[]{0, 4, 3, 0, 4}));
        System.out.println(new LeetCode1608_v2().specialArray(new int[]{3, 5}));
        System.out.println(new LeetCode1608_v2().specialArray(new int[]{3, 9, 7, 8, 3, 8, 6, 6}));
        System.out.println(new LeetCode1608_v2().specialArray(new int[]{0}));
        System.out.println(new LeetCode1608_v2().specialArray(new int[]{3}));
        //3 3 6 6 7 8 8 9
    }

    public int specialArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int n = nums.length;

        int l = 0;
        int r = max;

        while (l <= r) {

            int num = l + (r - l) / 2;

            int index = searchInsert(nums, num);

            if (n - index == num) {
                return num;
            }
            if (n - index < num) {
                r = num - 1;
            } else {
                l = num + 1;
            }
        }
        return -1;
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r + 1;
    }
}
