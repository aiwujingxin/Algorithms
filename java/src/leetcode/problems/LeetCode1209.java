package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2/23/25 22:44
 */
public class LeetCode1209 {

    public String removeDuplicates(String s, int k) {
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(s.charAt(0), 1));
        for (int i = 1; i < s.length(); i++) {
            if (stack.peek().c == s.charAt(i)) {
                stack.push(new Node(s.charAt(i), stack.peek().cnt + 1));
            } else {
                stack.push(new Node(s.charAt(i), 1));
            }
            if (!stack.isEmpty() && stack.peek().cnt == k) {
                int t = k;
                while (t > 0) {
                    stack.pop();
                    t--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop().c);
        }
        return sb.reverse().toString();
    }

    static class Node {
        char c;
        int cnt;

        public Node(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }
}
