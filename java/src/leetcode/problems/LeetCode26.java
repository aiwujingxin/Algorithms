package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 17:27
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        int l = 1;
        int cur = nums[0];
        for (int r = 1; r < nums.length; r++) {
            int val = nums[r];
            if (val != cur) {
                nums[l] = val;
                l++;
                cur = val;
            }
        }
        return l;
    }
}
