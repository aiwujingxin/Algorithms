package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/9 22:26
 */
public class LeetCode922 {

    public int[] sortArrayByParityII(int[] nums) {
        int i = 0, j = 1, n = nums.length;
        while (i < n && j < n) {
            while (i < n && nums[i] % 2 == 0) i += 2;
            while (j < n && nums[j] % 2 == 1) j += 2;
            if (i < n && j < n) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return nums;
    }
}
