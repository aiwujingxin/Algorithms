package knowledge.algorithms.search.dfsAndBfs.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/23 15:32
 * @description 八数码
 * 回溯算法+ 曼哈顿距离作为启发式函数 + 康托展开来检查状态是否已访问
 */

public class EightPuzzle {

    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final int[] FACT = {1, 1, 2, 6, 24, 120, 720, 5040, 40320};
    private final int[] targetPos = new int[9];
    private final Map<String, Integer> steps = new HashMap<>();
    boolean[] vis = new boolean[362880];

    public int solve(int[][] start, int[][] goal) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : start) for (int x : row) sb.append(x);
        String begin = sb.toString();
        sb.setLength(0);
        for (int[] row : goal) for (int x : row) sb.append(x);
        String target = sb.toString();
        for (int i = 0; i < 9; i++) {
            targetPos[target.charAt(i) - '0'] = i;
        }

        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(s -> dist(s) + steps.get(s)));
        steps.put(begin, 0);
        pq.add(begin);
        vis[cantor(begin)] = true;

        while (!pq.isEmpty()) {
            String cur = pq.poll();
            int g = steps.get(cur);
            if (cur.equals(target)) return g;

            int idx = cur.indexOf('0'), x = idx / 3, y = idx % 3;
            for (int[] d : DIRS) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || ny < 0 || nx >= 3 || ny >= 3) continue;
                int nIdx = nx * 3 + ny;
                char[] arr = cur.toCharArray();
                arr[idx] = arr[nIdx];
                arr[nIdx] = '0';
                String next = new String(arr);
                int c = cantor(next);
                if (!vis[c]) {
                    vis[c] = true;
                    steps.put(next, g + 1);
                    pq.add(next);
                }
            }
        }
        return -1;
    }


    private int dist(String s) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            char c = s.charAt(i);
            if (c == '0') continue;
            int pos = targetPos[c - '0'];
            sum += Math.abs(i / 3 - pos / 3) + Math.abs(i % 3 - pos % 3);
        }
        return sum;
    }

    private int cantor(String s) {
        char[] a = s.toCharArray();
        int res = 0;
        for (int i = 0; i < 9; i++) {
            int less = 0;
            for (int j = i + 1; j < 9; j++)
                if (a[j] < a[i]) less++;
            res += less * FACT[8 - i];
        }
        return res;
    }

    public static void main(String[] args) {
        EightPuzzle ep = new EightPuzzle();
        int[][] start = {
                {1, 2, 3},
                {0, 8, 4},
                {7, 6, 5}
        };
        int[][] goal = {
                {1, 0, 3},
                {8, 2, 4},
                {7, 6, 5}
        };
        System.out.println("最少步数：" + ep.solve(start, goal));
    }
}
