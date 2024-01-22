package leetcode.lists.lcr;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/26 14:34
 */
public class LCR109 {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));
        if (set.contains(target) || set.contains("0000")) {
            return -1;
        }
        if ("0000".equals(target)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        HashSet<String> visited = new HashSet<>();
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (String next : getNext(cur, visited)) {
                    if (set.contains(next)) {
                        continue;
                    }
                    if (Objects.equals(next, target)) {
                        return step + 1;
                    }
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    queue.add(next);
                }
            }
            step++;
        }
        return -1;
    }

    private List<String> getNext(String cur, HashSet<String> visited) {
        List<String> list = new ArrayList<>();
        char[] chars = cur.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char t = chars[i];
            chars[i] = getNC(t);
            String n = new String(chars);
            if (!visited.contains(n)) {
                list.add(n);
            }
            chars[i] = t;
            chars[i] = getPC(t);
            String p = new String(chars);
            if (!visited.contains(p)) {
                list.add(p);
            }
            chars[i] = t;
        }
        return list;
    }

    private char getPC(char t) {
        if (t == '0') {
            return '9';
        }
        return (char) (t - 1);
    }

    private char getNC(char t) {
        if (t == '9') {
            return '0';
        }
        return (char) (t + 1);
    }
}
