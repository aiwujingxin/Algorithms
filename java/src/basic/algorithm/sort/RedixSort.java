package basic.algorithm.sort;

import basic.datastructure.liner.array.ArraySort;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/13 23:15
 */
public class RedixSort implements ArraySort {

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int exp = 1; // 1, 10, 100, 1000 ...
        int R = 10; // 10 digits
        int[] temp = new int[nums.length];
        while (max / exp > 0) { // Go through all digits from LSB to MSB
            int[] count = new int[R];
            for (int num : nums) {
                count[(num / exp) % 10]++;
            }
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                temp[count[(nums[i] / exp) % 10] - 1] = nums[i];
                count[(nums[i] / exp) % 10]--;
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = temp[i];
            }
            exp *= 10;
        }
        return nums;
    }
}
