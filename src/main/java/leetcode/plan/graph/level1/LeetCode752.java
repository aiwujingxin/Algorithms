package leetcode.plan.graph.level1;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/20 22:10
 */
public class LeetCode752 {

    public static void main(String[] args) {
        System.out.println(new LeetCode752().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }


    public int openLock(String[] deadends, String target) {
        if (deadends == null || deadends.length == 0) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }
        queue.add("0000");
        visited.add("0000");

        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size > 0) {

                String s = queue.poll();

                List<String> list = getList(s);

                for (String next : list) {
                    if (dead.contains(next)) {
                        continue;
                    }
                    if (visited.contains(next)) {
                        continue;
                    }
                    if (next.equals(target)) {
                        return step;
                    }
                    visited.add(next);
                    queue.add(next);

                }
                size--;
            }

        }
        return -1;
    }

    private List<String> getList(String s) {
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char t = chars[i];
            if (chars[i] == '0') {
                chars[i] = '9';
                list.add(new String(chars));
                chars[i] = '1';
                list.add(new String(chars));
            } else if (chars[i] == '9') {
                chars[i] = '0';
                list.add(new String(chars));
                chars[i] = '8';
                list.add(new String(chars));
            } else {
                chars[i] = (char) (t - 1);
                list.add(new String(chars));
                chars[i] = (char) (t + 1);
                list.add(new String(chars));
            }

            chars[i] = t;
        }
        return list;
    }
}
