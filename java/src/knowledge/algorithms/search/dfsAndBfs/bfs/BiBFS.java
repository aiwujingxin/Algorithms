package knowledge.algorithms.search.dfsAndBfs.bfs;

import knowledge.algorithms.search.dfsAndBfs.problems.EightPuzzle_2bfs;
import knowledge.algorithms.search.dfsAndBfs.problems.HDU1401_solitaire;
import leetcode.problems.*;

import java.util.*;
import java.util.function.Function;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 11:55
 * @description 双向BFS 以指数级别降低搜索空间，解决一个起点终点明确、状态转移最好是可逆的无权图最短路问题。
 * @see EightPuzzle_2bfs
 * @see LeetCode433_2bfs
 * @see LeetCode127_2bfs
 * @see LeetCode752_2bfs
 * @see LeetCode773_2bfs
 * @see LeetCode2571_2bfs
 * @see HDU1401_solitaire
 */
public class BiBFS<T> {

    public int search(T start, T end, Function<T, List<T>> getNeighbors) {
        if (start.equals(end)) return 0;
        Queue<T> qs = new LinkedList<>();
        Map<T, Integer> ds = new HashMap<>();
        Queue<T> qe = new LinkedList<>();
        Map<T, Integer> de = new HashMap<>();
        qs.add(start);
        ds.put(start, 0);
        qe.add(end);
        de.put(end, 0);
        while (!qs.isEmpty() && !qe.isEmpty()) {
            int ans;
            // 总是扩展节点数较少的一侧
            if (qs.size() <= qe.size()) {
                ans = expand(qs, ds, de, getNeighbors);
            } else {
                ans = expand(qe, de, ds, getNeighbors);
            }
            if (ans != -1) {
                return ans;
            }
        }
        return -1;
    }

    private int expand(Queue<T> q, Map<T, Integer> s, Map<T, Integer> t, Function<T, List<T>> f) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            T u = q.poll();
            int d = s.get(u);
            for (T v : f.apply(u)) {
                if (t.containsKey(v)) {
                    return d + 1 + t.get(v);
                }
                if (!s.containsKey(v)) {
                    s.put(v, d + 1);
                    q.add(v);
                }
            }
        }
        return -1;
    }
}
