package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/18 14:42
 */
public class LeetCode189 {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, nums.length - 1 - k);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] chars, int i, int j) {
        while (i < j) {
            int t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
            i++;
            j--;
        }
    }
}
