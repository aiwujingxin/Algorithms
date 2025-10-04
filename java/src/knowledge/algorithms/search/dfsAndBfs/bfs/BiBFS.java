package knowledge.algorithms.search.dfsAndBfs.bfs;

import knowledge.algorithms.search.dfsAndBfs.problems.EightPuzzle_2bfs;
import knowledge.algorithms.search.dfsAndBfs.problems.HDU1401;
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
 * @see HDU1401
 */
public class BiBFS<T> {

    public int search(T s, T e, Function<T, List<T>> getNeighbors) {
        if (s.equals(e)) return 0;
        Queue<T> q1 = new LinkedList<>();
        Map<T, Integer> d1 = new HashMap<>();
        Queue<T> q2 = new LinkedList<>();
        Map<T, Integer> d2 = new HashMap<>();
        q1.add(s);
        d1.put(s, 0);
        q2.add(e);
        d2.put(e, 0);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int ans;
            if (q1.size() <= q2.size()) { // 总是扩展节点数较少的一侧
                ans = expand(q1, d1, d2, getNeighbors);
            } else {
                ans = expand(q2, d2, d1, getNeighbors);
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
