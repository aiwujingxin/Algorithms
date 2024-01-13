package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/13 23:10
 */
public class LeetCode1081 {

    public String removeDuplicateLetters(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        boolean[] used = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']--;
            if (used[s.charAt(i) - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && freq[stack.peek() - 'a'] > 0 && s.charAt(i) < stack.peek()) {
                used[stack.peek() - 'a'] = false;
                stack.pop();
            }
            used[s.charAt(i) - 'a'] = true;
            stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
