package knowledge.algorithms.search.dfsAndBfs.dfs;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author wujingxinit@outlook.com
 * @date 5/27/25 02:46
 * @description IDDFS 通用的迭代加深深度优先搜索 (IDDFS) 求解器。
 */
public class IDDFS<T> {
    private final Predicate<T> isGoal;
    private final Function<T, Collection<T>> ne;

    public IDDFS(Predicate<T> goalTest, Function<T, Collection<T>> successorFunc) {
        this.isGoal = goalTest;
        this.ne = successorFunc;
    }

    public List<T> solve(T start, int max) {
        for (int d = 0; d < max; d++) {
            Deque<T> path = new LinkedList<>();
            if (dfs(path, start, 0, d)) return new ArrayList<>(path);
        }
        return null;
    }

    private boolean dfs(Deque<T> path, T u, int d, int max) {
        path.addLast(u);
        if (isGoal.test(u)) return true;
        if (d < max) {
            for (T v : ne.apply(u)) {
                if (!path.contains(v) && dfs(path, v, d + 1, max)) {
                    return true;
                }
            }
        }
        path.removeLast(); // 回溯
        return false;
    }
}