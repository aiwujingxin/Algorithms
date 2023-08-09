package basic.algorithm.sort;

import basic.structure.array.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 14:15
 */
public class BucketSort implements ArraySort {

    @Override
    public int[] sortArray(int[] nums) {
        int minVal = nums[0];
        int maxVal = nums[0];
        for (int item : nums) {
            if (item < minVal) {
                minVal = item;
            } else if (item > maxVal) {
                maxVal = item;
            }
        }
        int bucketNum = (maxVal - minVal) / nums.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<>());
        }

        for (int value : nums) {
            int num = (value - minVal) / nums.length;
            bucketArr.get(num).add(value);
        }
        for (ArrayList<Integer> integers : bucketArr) {
            Collections.sort(integers);
        }

        int ndx = 0;
        for (ArrayList<Integer> list : bucketArr) {
            for (Integer n : list) {
                nums[ndx++] = n;
            }
        }
        return nums;
    }

}
