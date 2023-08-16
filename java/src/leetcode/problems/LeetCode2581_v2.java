package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/12 18:36
 */
public class LeetCode2581_v2 {

    private List<Integer>[] g;
    private final Set<Long> s = new HashSet<>();
    private int k, ans, cnt0;

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        this.k = k;
        g = new ArrayList[edges.length + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x); // 建图
        }

        for (var e : guesses) // guesses 转成哈希表
            s.add((long) e[0] << 32 | e[1]); // 两个 4 字节数压缩成一个 8 字节数

        dfs(0, -1);
        reroot(0, -1, cnt0);
        return ans;
    }

    private void dfs(int x, int fa) {
        for (var y : g[x]) {
            if (y != fa) {
                if (s.contains((long) x << 32 | y)) // 以 0 为根时，猜对了
                    ++cnt0;
                dfs(y, x);
            }
        }
    }

    private void reroot(int x, int fa, int cnt) {
        if (cnt >= k) ++ans; // 此时 cnt 就是以 x 为根时的猜对次数
        for (var y : g[x])
            if (y != fa) {
                int c = cnt;
                if (s.contains((long) x << 32 | y)) --c; // 原来是对的，现在错了
                if (s.contains((long) y << 32 | x)) ++c; // 原来是错的，现在对了
                reroot(y, x, c);
            }
    }
}
