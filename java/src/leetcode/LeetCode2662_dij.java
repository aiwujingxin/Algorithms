package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/8 18:50
 */
public class LeetCode2662_dij {

    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int max_num = 100005;
        int n = specialRoads.length;
        List<int[]> vertices = new ArrayList<>();
        // 先转点 只保留 特殊路径的目标点和 起点与终点
        // 0 - n-1
        for (int[] specialRoad : specialRoads) {
            vertices.add(new int[]{specialRoad[2], specialRoad[3]});
        }
        // n
        vertices.add(start);
        // n + 1
        vertices.add(target);
        // 建图
        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>(n + 2);
        for (int i = 0; i < n + 2; i++) {
            graph.add(new ArrayList<>());
            for (int j = 0; j < n + 2; j++) {
                if (i == j) {
                    continue;
                }
                if (j < n) {
                    // 从 ver[i] 移动到 ver[j] 的最短（要么全程曼哈顿，要么先曼哈顿到特殊路径的起点+特殊代价）
                    graph.get(i).add(new Pair<>(j,
                            Math.min(calDis(vertices.get(i), vertices.get(j)),
                                    calDis(vertices.get(i), new int[]{specialRoads[j][0], specialRoads[j][1]}) + specialRoads[j][4])));
                } else {
                    graph.get(i).add(new Pair<>(j, calDis(vertices.get(i), vertices.get(j))));
                }
            }
        }

        int ans = 0;

        class Pos {
            final int x;
            final int y;
            final int cost;
            final int fa;
            final int idx;

            Pos(int x, int y, int cost, int fa, int index) {
                this.x = x;
                this.y = y;
                this.cost = cost;
                this.fa = fa;
                this.idx = index;
            }
        }

        class Cmp implements Comparator<Pos> {
            @Override
            public int compare(Pos a, Pos b) {
                return a.cost - b.cost;
            }
        }

        PriorityQueue<Pos> queue = new PriorityQueue<>(new Cmp());
        queue.add(new Pos(vertices.get(n)[0], vertices.get(n)[1], 0, -1, n));

        int[] dist = new int[max_num];
        Arrays.fill(dist, Integer.MAX_VALUE);

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            if (cur.x == vertices.get(n + 1)[0] && cur.y == vertices.get(n + 1)[1]) {
                ans = cur.cost;
                break;
            }

            for (int j = 0; j < graph.get(cur.idx).size(); j++) {
                int nxt_idx = graph.get(cur.idx).get(j).getKey();
                if (dist[nxt_idx] <= cur.cost + graph.get(cur.idx).get(j).getValue()) {
                    continue;
                }
                dist[nxt_idx] = cur.cost + graph.get(cur.idx).get(j).getValue();
                queue.add(new Pos(vertices.get(nxt_idx)[0], vertices.get(nxt_idx)[1], cur.cost + graph.get(cur.idx).get(j).getValue(), cur.idx, nxt_idx));
            }
        }
        return ans;
    }

    // 计算曼哈顿距离
    private int calDis(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    static class Pair<F, S> {
        private final F first;
        private final S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getKey() {
            return first;
        }

        public S getValue() {
            return second;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) obj;
            if (!first.equals(pair.first)) return false;
            return second.equals(pair.second);
        }

        @Override
        public int hashCode() {
            int result = first.hashCode();
            result = 31 * result + second.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

}
