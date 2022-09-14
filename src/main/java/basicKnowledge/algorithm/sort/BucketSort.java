package basicKnowledge.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 14:15
 */
public class BucketSort implements Sort {

    @Override
    public void sort(int[] arr) {
        int minVal = arr[0];
        int maxVal = arr[0];
        for (int item : arr) {
            if (item < minVal) {
                minVal = item;
            } else if (item > maxVal) {
                maxVal = item;
            }
        }
        int bucketNum = (maxVal - minVal) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<>());
        }

        for (int value : arr) {
            int num = (value - minVal) / arr.length;
            bucketArr.get(num).add(value);
        }
        for (ArrayList<Integer> integers : bucketArr) {
            Collections.sort(integers);
        }

        int ndx = 0;
        for (ArrayList<Integer> list : bucketArr) {
            for (Integer n : list) {
                arr[ndx++] = n;
            }
        }
    }

}
