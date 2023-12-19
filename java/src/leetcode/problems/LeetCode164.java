package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/19 14:44
 */
public class LeetCode164 {

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        sort(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }

    private void sort(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int max = 0;
        for (int j : nums) {
            max = Math.max(max, j);
        }
        for (int exp = 1; max / exp > 0; exp = exp * 10) {
            int[] count = new int[10];
            for (int i = 0; i < nums.length; i++) {
                count[(nums[i] / exp) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
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
