package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 15:22
 */
public class LeetCode20 {

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (st.isEmpty() || st.pop() != map.get(c)) return false;
            } else st.push(c);
        }
        return st.isEmpty();
    }
}
