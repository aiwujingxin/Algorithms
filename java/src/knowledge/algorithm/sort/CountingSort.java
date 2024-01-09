package knowledge.algorithm.sort;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 23:07
 * @description 利用数组下标来确定元素的位置
 */
public class CountingSort implements Sort {

    @Override
    public int[] sortArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int len = max + 1;
        int[] count = new int[len];
        // 统计
        for (int num : nums) {
            count[num]++;
        }
        int index = 0;
        for (int i = 0; i < len; i++) {
            while (count[i] > 0) {
                nums[index] = i;
                count[i]--;
                index++;
            }
        }
        return nums;
    }
}
