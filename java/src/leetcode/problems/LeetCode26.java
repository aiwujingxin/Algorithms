package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 17:27
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        int stackSize = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[stackSize - 1]) {
                nums[stackSize++] = nums[i];
            }
        }
        return stackSize;
    }
}
