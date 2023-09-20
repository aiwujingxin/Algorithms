package leetcode;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/20 21:32
 */
public class LeetCode581 {

    //https://www.youtube.com/watch?v=jbrAZ9Tf0ew

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Stack<Integer> incr = new Stack<>();
        Stack<Integer> decr = new Stack<>();
        int n = nums.length;
        int start = n;
        int end = -1;
        for (int i = 0; i < n; i++) {
            while (!incr.empty() && nums[i] < nums[incr.peek()]) {
                start = Math.min(start, incr.pop());
            }
            incr.push(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!decr.empty() && nums[i] > nums[decr.peek()]) {
                end = Math.max(end, decr.pop());
            }
            decr.push(i);
        }
        if (end == -1) {
            return 0;
        }
        return end - start + 1;
    }
}
