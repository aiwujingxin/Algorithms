package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/23 23:43
 */
public class LeetCode80 {

    public int removeDuplicates(int[] nums) {
        int stackSize = 2; // 栈的大小，前两个元素默认保留
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[stackSize - 2]) { // 和栈顶下方的元素比较
                nums[stackSize++] = nums[i]; // 入栈
            }
        }
        return stackSize;
    }
}
