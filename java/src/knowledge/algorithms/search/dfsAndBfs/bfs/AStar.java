package knowledge.algorithms.search.dfsAndBfs.bfs;

import knowledge.algorithms.search.dfsAndBfs.problems.Coordinate;
import knowledge.algorithms.search.dfsAndBfs.problems.*;
import leetcode.problems.*;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @param <T> 状态的类型，必须可哈希。
 * @author wujingxinit@outlook.com
 * @date 9/18/25 16:35
 * @description 通用单向 A* 算法模板
 * @see LeetCode752_astar
 * @see EightPuzzle_astar2
 * @see EightPuzzle_astar3
 * @see MazeProblem_astar
 */
public class AStar<T> {

    private record N<T>(T s, int f) implements Comparable<N<T>> {
        public int compareTo(N<T> o) {
            return Integer.compare(f, o.f);
        }
    }

    public int search(T st, T ed, Function<T, List<Map.Entry<T, Integer>>> nb, BiFunction<T, T, Integer> h) {
        Map<T, Integer> g = new HashMap<>();
        PriorityQueue<N<T>> pq = new PriorityQueue<>();
        g.put(st, 0);
        pq.add(new N<>(st, h.apply(st, ed)));
        while (!pq.isEmpty()) {
            N<T> n = pq.poll();
            T s = n.s;
            int gs = g.get(s);
            if (s.equals(ed)) return gs;
            if (n.f > gs + h.apply(s, ed)) continue;
            for (var e : nb.apply(s)) {
                T ns = e.getKey();
                int ng = gs + e.getValue();
                if (ng < g.getOrDefault(ns, Integer.MAX_VALUE)) {
                    g.put(ns, ng);
                    pq.add(new N<>(ns, ng + h.apply(ns, ed)));
                }
            }
        }
        return -1;
    }
}

class Heuristic {

    // 1) 曼哈顿距离（4方向网格）
    public static final BiFunction<Coordinate, Coordinate, Integer> MANHATTAN =
            (a, b) -> Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    // 2) 切比雪夫距离（8方向网格，斜线代价==直走代价）
    public static final BiFunction<Coordinate, Coordinate, Integer> CHEBYSHEV =
            (a, b) -> Math.max(Math.abs(a.x - b.x), Math.abs(a.y - b.y));
    // 3) 欧几里得距离（任意方向，返回 double 版）
    public static final BiFunction<Coordinate, Coordinate, Double> EUCLIDEAN_D =
            (a, b) -> {
                double dx = a.x - b.x, dy = a.y - b.y;
                return Math.sqrt(dx * dx + dy * dy);
            };
    public static final BiFunction<Coordinate, Coordinate, Integer> EUCLIDEAN_I =
            (a, b) -> {
                double dx = a.x - b.x, dy = a.y - b.y;
                return (int) Math.sqrt(dx * dx + dy * dy);
            };
    // 4) 汉明距离（拼图：错位瓦片计数，忽略 '0'）
    public static final BiFunction<String, String, Integer> HAMMING =
            (s, t) -> {
                int c = 0, n = s.length();
                for (int i = 0; i < n; i++) if (s.charAt(i) != '0' && s.charAt(i) != t.charAt(i)) c++;
                return c;
            };
    // 5) 八数码的曼哈顿距离（'0' 为空格；3x3）
    public static final BiFunction<String, String, Integer> PUZZLE_MANHATTAN =
            (s, t) -> {
                int d = 0, n = s.length();
                for (int i = 0; i < n; i++) {
                    char c = s.charAt(i);
                    if (c == '0') continue;
                    int j = t.indexOf(c);
                    d += Math.abs(i / 3 - j / 3) + Math.abs(i % 3 - j % 3);
                }
                return d;
            };
}