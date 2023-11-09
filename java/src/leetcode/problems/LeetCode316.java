package leetcode.problems;

import java.util.Stack;

/**
 * @author jingxinwu
 * @date 2022-02-26 2:15 PM
 * @description 单调栈+贪心
 */
public class LeetCode316 {

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.contains(c)) {
                while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                    stack.pop();
                }
                stack.add(c);
            }
            count[c - 'a']--;
        }
        StringBuilder res = new StringBuilder();
        for (char ch : stack) {
            res.append(ch);
        }
        return res.toString();
    }
}
