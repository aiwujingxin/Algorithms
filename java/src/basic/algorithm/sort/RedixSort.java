package basic.algorithm.sort;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/13 23:15
 * @link <a href="https://www.bilibili.com/video/BV1YM4y1A7wi/"></a>
 * @link 见leetcode.solution.pic.redixSort.png 有图解
 * @description 时间复杂度 O(n)
 */
public class RedixSort implements Sort {

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int n = nums.length;
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] temp = new int[n];
        // 对每个位进行计数排序
        for (int exp = 1; max / exp > 0; exp *= 10) {
            int[] count = new int[10];
            // 该位置有几个数
            for (int num : nums) {
                count[(num / exp) % 10]++;
            }
            //将“出现个数”转换为“数组索引”
            //求前缀和，使得每个索引处的值等于其前面所有索引处值的累加和。
            //这一步的目的是确定每个元素在有序数组中的最后一个位置。
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }
            // 从后往前遍历原数组，根据位上的数字放入输出数组中
            for (int i = n - 1; i >= 0; i--) {
                int index = (nums[i] / exp) % 10;
                temp[count[index] - 1] = nums[i];
                count[index]--;
            }
            for (int i = 0; i < n; i++) {
                nums[i] = temp[i];
            }
        }
        return nums;
    }
}
