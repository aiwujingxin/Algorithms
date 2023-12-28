package leetcode.problems;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author jingxinwu
 * @date 2023.11.09 22:30
 * @description 单调栈+贪心
 */
public class LeetCode316 {

    public String removeDuplicateLetters(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']--;
            if (set.contains(s.charAt(i))) {
                continue;
            }
            while (!stack.isEmpty() && (stack.peek() >= s.charAt(i)) && (arr[stack.peek() - 'a'] > 0)) {
                set.remove(stack.peek());
                stack.pop();
            }
            set.add(s.charAt(i));
            stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
