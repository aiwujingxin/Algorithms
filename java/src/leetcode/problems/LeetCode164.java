package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/24 22:29
 */
public class LeetCode164 {

    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        redixSort(nums);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }

    private void redixSort(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] temp = new int[nums.length], cnt = new int[10];
        for (int exp = 1; max / exp > 0; exp *= 10) {
            Arrays.fill(cnt, 0);
            for (int n : nums) cnt[(n / exp) % 10]++;
            for (int i = 1; i < 10; i++) cnt[i] += cnt[i - 1];
            for (int i = nums.length - 1; i >= 0; i--) {
                int d = (nums[i] / exp) % 10;
                temp[--cnt[d]] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = temp[i];
            }
        }
    }
}
