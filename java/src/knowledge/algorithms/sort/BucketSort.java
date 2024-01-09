package knowledge.algorithms.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 14:15
 * @description 将元素均匀分布至桶中, 对桶内的元素排序,最后按顺序输出
 */
public class BucketSort implements Sort {

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
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int value : nums) {
            int num = (value - minVal) / nums.length;
            buckets.get(num).add(value);
        }
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        int index = 0;
        for (List<Integer> list : buckets) {
            for (Integer num : list) {
                nums[index++] = num;
            }
        }
        return nums;
    }
}
