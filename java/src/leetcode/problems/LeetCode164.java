package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/24 22:29
 */
public class LeetCode164 {

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        redixSort(nums);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }

    private void redixSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] temp = new int[nums.length];
        for (int exp = 1; max / exp > 0; exp = exp * 10) {
            int[] count = new int[10];
            for (int num : nums) {
                count[(num / exp) % 10]++;
            }
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
        }
    }
}
