package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 12/15/25 14:11
 */
public class LeetCode1111 {

    public int[] maxDepthAfterSplit(String seq) {
        Stack<Integer> stack = new Stack<>();
        int n = seq.length();
        int[] ans = new int[n];
        int depth = 0;
        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                stack.push(i);
                depth++;
            } else {
                if (stack.isEmpty() || seq.charAt(stack.peek()) != '(') {
                    stack.push(i);
                } else {
                    ans[stack.pop()] = depth % 2;
                    ans[i] = depth % 2;
                    depth--;
                }
            }
        }
        return ans;
    }
}
