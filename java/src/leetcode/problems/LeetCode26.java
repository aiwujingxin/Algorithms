package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 17:27
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        int right = 1;
        int left = 1;
        while (right < nums.length) {
            if (nums[right] != nums[left - 1]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
