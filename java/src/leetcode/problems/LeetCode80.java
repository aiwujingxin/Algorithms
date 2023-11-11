package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/11 21:36
 * @see LeetCode26
 */
public class LeetCode80 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int right = 2;
        int left = 2;
        while (right < n) {
            //窗口一样
            if (nums[left - 2] != nums[right]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
