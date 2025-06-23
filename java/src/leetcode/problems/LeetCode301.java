package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/7 18:18
 */
public class LeetCode301 {

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (check(s)) {
            result.add(s);
            return result;
        }
        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                List<String> nexts = getNext(cur);
                for (String next : nexts) {
                    if (set.contains(next)) {
                        continue;
                    }
                    set.add(next);
                    if (check(next)) {
                        result.add(next);
                    }
                    queue.add(next);
                }
            }
            if (!result.isEmpty()) {
                return result;
            }
        }
        return result;
    }

    public List<String> getNext(String cur) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != '(' && cur.charAt(i) != ')') continue;
            String next = cur.substring(0, i) + cur.substring(i + 1);
            list.add(next);
        }
        return list;
    }

    public boolean check(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            }
            if (s.charAt(i) == ')') {
                if (cnt == 0) {
                    return false;
                }
                cnt--;
            }
        }
        return cnt == 0;
    }
}
