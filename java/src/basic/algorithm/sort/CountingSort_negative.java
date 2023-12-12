package basic.algorithm.sort;

import basic.datastructure.array.ArraySort;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 23:05
 */
public class CountingSort_negative implements ArraySort {

    @Override
    public int[] sortArray(int[] nums) {
        int max = 0, min = 0;
        //find max absolute integer for positives and negatives
        for (var c : nums) {
            if (c >= 0) {
                max = Math.max(max, c);
            }
            if (c < 0) {
                min = Math.min(min, c);
            }
        }
        int[] positive = new int[max + 1];
        int[] negative = new int[-min + 1];
        // counting
        for (var c : nums) {
            if (c < 0) {
                negative[-c]++;
            } else {
                positive[c]++;
            }
        }

        //sorting
        int x = 0;
        for (int i = -min; i > 0; i--) {
            while (negative[i] > 0) {
                nums[x] = -i;
                x++;
                negative[i]--;
            }
        }
        for (int i = 0; i < max + 1; i++) {
            while (positive[i] > 0) {
                nums[x] = i;
                x++;
                positive[i]--;
            }
        }
        return nums;
    }
}
