package leetCode.problems;

import java.util.Stack;

/**
 * @author jingxinwu
 * @date 2021-12-18 7:40 PM
 */
public class LeetCode581 {

    public static void main(String[] args) {
        System.out.println(new LeetCode581().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int l = nums.length - 1;
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (stack.empty() || nums[i] > nums[stack.peek()]) {
                stack.push(i);
            } else {
                l = Math.min(l, stack.pop());
                i--;
            }
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {

            if (stack.empty() || nums[i] <= nums[stack.peek()]) {
                stack.push(i);

            } else {
                r = Math.max(r, stack.pop());
            }
        }
        return r - l + 1;
    }
}
