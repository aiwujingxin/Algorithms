package knowledge.algorithms.search.dfsAndBfs.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2025/5/27 02:42
 * @description 八数码 双向BFS
 */

public class EightPuzzle_bibfs2 {

    static final String TARGET = "123456780";
    static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            String s = sc.next();
            sb.append(s.equals("x") ? '0' : s.charAt(0));
        }
        String start = sb.toString();
        int result = bfs(start);
        System.out.println(result);
    }

    static int expand(Queue<String> q, Map<String, Integer> d1, Map<String, Integer> d2) {
        String cur = q.poll();
        int step = d1.get(cur);
        int idx = cur.indexOf('0');
        int x = idx / 3, y = idx % 3;

        for (int[] dir : DIRS) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) {
                continue;
            }
            int nIdx = nx * 3 + ny;
            char[] chars = cur.toCharArray();
            // swap
            char temp = chars[idx];
            chars[idx] = chars[nIdx];
            chars[nIdx] = temp;
            String next = new String(chars);
            if (d1.containsKey(next)) {
                continue;
            }
            d1.put(next, step + 1);
            if (d2.containsKey(next)) {
                return step + 1 + d2.get(next);
            }
            q.add(next);
        }
        return -1;
    }

    static int bfs(String start) {
        if (start.equals(TARGET)) {
            return 0;
        }
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        Map<String, Integer> dist1 = new HashMap<>();
        Map<String, Integer> dist2 = new HashMap<>();

        q1.offer(start);
        dist1.put(start, 0);

        q2.offer(TARGET);
        dist2.put(TARGET, 0);

        int ans;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() <= q2.size()) {
                ans = expand(q1, dist1, dist2);
            } else {
                ans = expand(q2, dist2, dist1);
            }
            if (ans != -1) return ans;
        }
        return -1;
    }
}
