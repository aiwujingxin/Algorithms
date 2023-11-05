package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/19 23:15
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int left = 1, right = 1;
        while (right < n) {
            if (nums[left - 1] != nums[right]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
