package knowledge.algorithms.sort.noncomparison;

import knowledge.algorithms.sort.Sort;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 基数排序 时间复杂度 O(n)
 */
public class RadixSort implements Sort {

    @Override
    public int[] sortArray(int[] nums) {
        long max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, Math.abs((long) nums[i]));
        }

        int n = nums.length;
        int[] temp = new int[n];
        for (long exp = 1; max / exp > 0; exp *= 10) {
            int[] count = new int[19];
            for (int num : nums) {
                int digit = (int) (num / exp) % 10;
                count[digit + 9]++;
            }
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                int digit = (int) (nums[i] / exp) % 10;
                temp[count[digit + 9] - 1] = nums[i];
                count[digit + 9]--;
            }
            for (int i = 0; i < n; i++) {
                nums[i] = temp[i];
            }
        }
        return nums;
    }
}
