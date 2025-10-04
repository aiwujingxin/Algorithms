package knowledge.algorithms.search.dfsAndBfs.bfs;

import knowledge.algorithms.search.dfsAndBfs.problems.EightPuzzle_astar2;
import knowledge.algorithms.search.dfsAndBfs.problems.EightPuzzle_astar3;
import knowledge.algorithms.search.dfsAndBfs.problems.MazeProblem_astar;
import leetcode.problems.LeetCode752_astar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntBiFunction;

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
    // --- 坐标点启发式函数 (使用 int[] 数组) ---
    /**
     * 1) 曼哈顿距离 (4方向网格)
     * 输入: 两个 int[] 坐标 a, b
     * 返回: 整数距离
     */
    public static final ToIntBiFunction<int[], int[]> MANHATTAN =
            (a, b) -> Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    /**
     * 2) 切比雪夫距离 (8方向网格，斜线代价==直走代价)
     * 输入: 两个 int[] 坐标 a, b
     * 返回: 整数距离
     */
    public static final ToIntBiFunction<int[], int[]> CHEBYSHEV =
            (a, b) -> Math.max(Math.abs(a[0] - b[0]), Math.abs(a[1] - b[1]));
    /**
     * 3) 欧几里得距离 (任意方向，返回 double)
     * 输入: 两个 int[] 坐标 a, b
     * 返回: double 距离
     */
    public static final ToDoubleBiFunction<int[], int[]> EUCLIDEAN_D =
            (a, b) -> {
                double dx = a[0] - b[0];
                double dy = a[1] - b[1];
                return Math.sqrt(dx * dx + dy * dy);
            };
    /**
     * 3b) 欧几里得距离 (任意方向，返回 int)
     * 输入: 两个 int[] 坐标 a, b
     * 返回: 整数距离 (通过类型转换)
     */
    public static final ToIntBiFunction<int[], int[]> EUCLIDEAN_I =
            (a, b) -> (int) EUCLIDEAN_D.applyAsDouble(a, b);
    // --- 字符串/序列启发式函数 (保持不变) ---
    /**
     * 4) 汉明距离 (拼图：错位瓦片计数，忽略 '0' 或其他占位符)
     * 输入: 两个字符串 s, t
     * 返回: 整数距离
     */
    public static final ToIntBiFunction<String, String> HAMMING =
            (s, t) -> {
                int count = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != '0' && s.charAt(i) != t.charAt(i)) {
                        count++;
                    }
                }
                return count;
            };
    /**
     * 5) 八数码的曼哈顿距离 ('0' 为空格；3x3)
     * 输入: 两个字符串 s, t (s是当前状态, t是目标状态)
     * 返回: 整数距离
     */
    public static final ToIntBiFunction<String, String> PUZZLE_MANHATTAN =
            (s, t) -> {
                int distance = 0;
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c == '0') continue;
                    int targetIndex = t.indexOf(c);
                    // 计算当前位置 (i/3, i%3) 和目标位置 (j/3, j%3) 的曼哈顿距离
                    distance += Math.abs(i / 3 - targetIndex / 3) + Math.abs(i % 3 - targetIndex % 3);
                }
                return distance;
            };
}