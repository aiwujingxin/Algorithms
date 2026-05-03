package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 17:38
 */
public class LeetCode27 {

    public int removeElement(int[] nums, int val) {
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] != val) {
                nums[l] = nums[r];
                l++;
            }
        }
        return l;
    }
}
