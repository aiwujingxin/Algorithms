package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/21 01:08
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        int x = 1;
        for (int i = x; i < nums.length; i++) {
            if (nums[i] > nums[x - 1]) {
                nums[x++] = nums[i];
            }
        }
        return x;
    }
}
