package leetcode.hot100;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/10 16:41
 */
public class LeetCode301_bfs {

    //https://leetcode.com/problems/remove-invalid-parentheses/discuss/2306346/Java-or-BFS-or-clean-code

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();     // To Avoid duplicate
        boolean isValidFound = false;

        Queue<String> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty() && !isValidFound) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (isValid(cur)) {
                    isValidFound = true;
                    result.add(cur);
                } else if (!isValidFound) {
                    for (int j = 0; j < cur.length(); j++) {
                        if (Character.isLetter(cur.charAt(j))) {
                            continue;
                        }
                        //remove j
                        String new_str = cur.substring(0, j) + cur.substring(j + 1);
                        if (!set.contains(new_str)) {
                            queue.add(new_str);
                            set.add(new_str);
                        }
                    }
                }
            }
        }
        return result;
    }

    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.add('(');
            } else if (stack.isEmpty() && str.charAt(i) == ')') {
                return false;
            } else if (str.charAt(i) == ')') {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
