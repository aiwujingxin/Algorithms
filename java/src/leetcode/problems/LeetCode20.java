package leetcode.problems;

import java.util.Map;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 15:22
 */
public class LeetCode20 {

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> st = new Stack<>();
        Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (st.isEmpty() || st.pop() != map.get(c)) return false;
            } else st.push(c);
        }
        return st.isEmpty();
    }

    class Solution_OPT {

        public boolean isValid(String s) {
            if (s.length() % 2 != 0) return false;
            char[] stack = new char[s.length()];
            int top = 0;
            char[] chs = s.toCharArray();
            for (char c : chs) {
                if (c == '(') {
                    stack[top++] = ')';
                } else if (c == '[') {
                    stack[top++] = ']';
                } else if (c == '{') {
                    stack[top++] = '}';
                } else {
                    if (top == 0 || stack[--top] != c) {
                        return false;
                    }
                }
            }
            return top == 0;
        }
    }
}
