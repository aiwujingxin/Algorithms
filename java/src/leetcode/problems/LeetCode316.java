package leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/26 09:51
 */
public class LeetCode316 {

    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] vis = new boolean[26];
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            freq[idx]--;
            if (vis[idx]) continue;
            while (!stack.isEmpty() && stack.peek() > s.charAt(i) && freq[stack.peek() - 'a'] > 0) {
                vis[stack.pop() - 'a'] = false;
            }
            stack.push(s.charAt(i));
            vis[idx] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
