package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/23 11:27
 */
public class LeetCode1852 {

    public int[] distinctNumbers(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[]{};
        }

        int left = 0;
        int right = 0;

        int count = 0;

        int[] arr = new int[100000];
        int[] ans = new int[nums.length - k + 1];


        while (right < nums.length) {
            arr[nums[right]]++;
            if (arr[nums[right]] == 1) {
                count++;
            }
            while (right - left + 1 > k) {
                arr[nums[left]]--;
                if (arr[nums[left]] == 0) {
                    count--;
                }
                left++;
            }
            ans[left] = count;
            right++;
        }

        return ans;
    }
}
