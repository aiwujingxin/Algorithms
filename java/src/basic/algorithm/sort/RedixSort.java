package basic.algorithm.sort;

import basic.datastructure.array.ArraySort;

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
        // 遍历次数
        while (max / exp > 0) {
            int[] count = new int[R];
            // 该位置有几个数
            for (int num : nums) {
                count[(num / exp) % 10]++;
            }
            //求前缀和，将“出现个数”转换为“数组索引”
            //对计数数组进行变形，使得每个索引处的值等于其前面所有索引处值的累加和。
            //这一步的目的是确定每个元素在有序数组中的最后一个位置。
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                int index = (nums[i] / exp) % 10;
                temp[count[index] - 1] = nums[i];
                count[index]--;
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = temp[i];
            }
            exp *= 10;
        }
        return nums;
    }
}
