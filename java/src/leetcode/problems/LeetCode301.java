package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/7 18:18
 */
public class LeetCode301 {

    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        HashSet<String> res = new HashSet<>();
        if (check(s)) {
            List<String> list = new ArrayList<>();
            list.add(s);
            return list;
        }
        HashSet<String> visited = new HashSet<>();
        visited.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                for (int index = 0; index < node.length(); index++) {
                    if (node.charAt(index) >= 'a' && node.charAt(index) <= 'z') {
                        continue;
                    }
                    String ss = node.substring(0, index) + node.substring(index + 1, node.length());
                    if (check(ss)) {
                        res.add(ss);
                    } else {
                        if (visited.contains(ss)) {
                            continue;
                        }
                        visited.add(ss);
                        queue.add(ss);
                    }
                }
            }
            if (!res.isEmpty()) {
                return new ArrayList<>(res);
            }
        }
        return new ArrayList<>();
    }

    public boolean check(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            }
            if (s.charAt(i) == ')') {
                right++;
            }
            if (left < right) {
                return false;
            }
        }
        return left == right;
    }
}
