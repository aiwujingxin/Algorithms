package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 17:38
 */
public class LeetCode27 {

    public int removeElement(int[] nums, int val) {
        int stackSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[stackSize++] = nums[i];
            }
        }
        return stackSize;
    }
}
