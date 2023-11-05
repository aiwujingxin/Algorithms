package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/26 10:33
 * @see LeetCode26
 */
public class LeetCode80 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 2, right = 2;
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
