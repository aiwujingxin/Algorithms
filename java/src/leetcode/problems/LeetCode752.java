package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/20 22:10
 */
public class LeetCode752 {

    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        String start = "0000";
        if (deadSet.contains(start)) return -1;
        if (start.equals(target)) return 0;
        Queue<String> queue = new ArrayDeque<>(); // 使用 ArrayDeque 性能更优
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int steps = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return steps;
                }
                for (String neighbor : getNexts(current)) {
                    if (!visited.contains(neighbor) && !deadSet.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private List<String> getNexts(String s) {
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            neighbors.add(addOne(s, i));
            neighbors.add(minusOne(s, i));
        }
        return neighbors;
    }

    private String addOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '9') {
            ch[i] = '0';
        } else {
            ch[i]++;
        }
        return new String(ch);
    }

    private String minusOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '0') {
            ch[i] = '9';
        } else {
            ch[i]--;
        }
        return new String(ch);
    }
}
