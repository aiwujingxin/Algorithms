package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/26 09:51
 */
public class LeetCode316 {

    public String removeDuplicateLetters(String s) {
        if (s == null || s.isEmpty()) return "";
        Stack<Character> stack = new Stack<>();
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            freq[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && freq[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
