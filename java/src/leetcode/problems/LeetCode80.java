package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/23 23:43
 */
public class LeetCode80 {

    public int removeDuplicates(int[] nums) {
        int left = 2;
        int right = 2;
        while (right < nums.length) {
            if (nums[right] != nums[left - 2]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
