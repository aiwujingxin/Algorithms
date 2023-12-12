package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/12 21:39
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
            if (nums[left - 2] != nums[right]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
