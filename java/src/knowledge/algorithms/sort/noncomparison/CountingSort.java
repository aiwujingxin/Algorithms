package knowledge.algorithms.sort.noncomparison;

import knowledge.algorithms.sort.Sort;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 计数排序 利用数组下标来确定元素的位置
 */
public class CountingSort implements Sort {

    @Override
    public int[] sortArray(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int len = max - min + 1;
        int[] count = new int[len];
        for (int num : nums) {
            count[num - min]++;
        }
        int index = 0;
        for (int i = 0; i < len; i++) {
            while (count[i] > 0) {
                nums[index] = i + min;
                count[i]--;
                index++;
            }
        }
        return nums;
    }
}
