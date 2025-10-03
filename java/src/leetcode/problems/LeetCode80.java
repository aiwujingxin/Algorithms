package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/23 23:43
 */
public class LeetCode80 {

    public int removeDuplicates(int[] nums) {
        int l = 2;
        int r = 2;
        while (r < nums.length) {
            if (nums[r] != nums[l - 2]) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }
}
