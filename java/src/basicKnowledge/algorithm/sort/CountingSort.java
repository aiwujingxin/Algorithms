package basicKnowledge.algorithm.sort;

import basicKnowledge.dataStructure.array.ArraySort;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 23:07
 */
public class CountingSort implements ArraySort {

    @Override
    public int[] sortArray(int[] nums) {
        int maxValue = getMaxValue(nums);
        return countingSort(nums, maxValue);
    }

    private int[] countingSort(int[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value]++;
        }

        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}
