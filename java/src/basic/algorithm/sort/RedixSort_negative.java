package basic.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 23:03
 */
public class RedixSort_negative implements ArraySort {

    //https://leetcode.cn/problems/sort-an-array/solution/912-pai-xu-shu-zu-ji-chu-pai-xu-suan-fa-1qt5f/
    @Override
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // 避免负数，让当前数组从0开始
        for (int i = 0; i < n; i++) {
            nums[i] -= min;
        }
        max -= min;

        // 计算最大值的位数
        int digit = 0;
        while (max != 0) {
            digit++;
            max /= 10;
        }

        double power = 0.1;
        for (int i = 0; i < digit; i++) {
            power *= 10;
            List<List<Integer>> buckets = new ArrayList<>();
            for (int k = 0; k < 10; k++) {
                buckets.add(new ArrayList<>());
            }
            // 根据倒数第i位确定放入桶中的位置
            for (int j = 0; j < n; j++) {
                int index = (int) (nums[j] / power) % 10;
                buckets.get(index).add(nums[j]);
            }

            // 放回原数组
            int k = 0;
            for (int j = 0; j < 10; j++) {
                for (int num : buckets.get(j)) {
                    nums[k++] = num;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            nums[i] += min;
        }
        return nums;

    }
}
