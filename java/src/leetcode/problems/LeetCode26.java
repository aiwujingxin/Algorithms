package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 17:27
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        int r = 1;
        int l = 1;
        while (r < nums.length) {
            if (nums[r] != nums[l - 1]) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }
}
