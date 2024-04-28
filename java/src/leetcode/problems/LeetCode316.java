package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/26 09:51
 */
public class LeetCode316 {

    public String removeDuplicateLetters(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']--;
            if (visited[s.charAt(i) - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && s.charAt(i) <= stack.peek() && freq[stack.peek() - 'a'] > 0) {
                char d = stack.pop();
                visited[d - 'a'] = false;
            }
            stack.push(s.charAt(i));
            visited[s.charAt(i) - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
