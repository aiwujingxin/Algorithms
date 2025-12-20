package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 12/4/25 14:15
 */
public class LeetCode2211 {

    public int countCollisions(String directions) {
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        int n = directions.length();
        char[] chars = directions.toCharArray();
        for (int i = 0; i < n; i++) {
            char d = chars[i];
            if (stack.isEmpty()) {
                stack.push(d);
                continue;
            }
            if (d == 'R') {
                stack.push(d);
            }
            if (d == 'S') {
                if (stack.peek() == 'R') {
                    stack.pop();
                    cnt++;
                }
                stack.push(d);
            }
            if (d == 'L') {
                if (stack.peek() == 'R') {
                    cnt += 2;
                    stack.pop();
                    stack.push('S');
                } else if (stack.peek() == 'L') {
                    stack.push(d);
                } else {
                    cnt++;
                }
            }
        }
        int R = 0;
        for (char s : stack) {
            if (s == 'S') {
                cnt += R;
                R = 0;
            }
            if (s == 'R') {
                R++;
            }
        }
        return cnt;
    }
}
