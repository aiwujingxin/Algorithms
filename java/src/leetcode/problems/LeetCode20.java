package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 15:22
 */
public class LeetCode20 {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) return false;
            } else stack.push(c);
        }
        return stack.isEmpty();
    }
}
