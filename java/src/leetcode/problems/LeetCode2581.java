package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/10 05:58
 */
public class LeetCode2581 {

    List<Integer>[] edg;
    HashSet<Integer>[] guess;
    int res = 0, target;

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        target = k;
        int n = edges.length + 1;
        edg = new List[n];
        guess = new HashSet[n];
        for (int i = 0; i < n; i++) {
            edg[i] = new ArrayList<>();
            guess[i] = new HashSet<>();
        }
        for (int i = 0; i < n - 1; i++) {
            edg[edges[i][0]].add(edges[i][1]);
            edg[edges[i][1]].add(edges[i][0]);
        }
        for (int i = 0; i < guesses.length; i++) {
            guess[guesses[i][0]].add(guesses[i][1]);
        }

        int v = dfs(0, -1);
        dfs2(0, -1, v);
        return res;
    }

    private int dfs(int cur, int father) {
        int v = 0;
        for (Integer next : edg[cur]) {
            if (next == father) {
                continue;
            }
            if (guess[cur].contains(next)) v++;
            v += dfs(next, cur);
        }
        return v;
    }

    private void dfs2(int cur, int father, int v) {
        if (v >= target) {
            res++;
        }
        for (Integer next : edg[cur]) {
            if (next == father) {
                continue;
            }
            int tmp = v;
            if (guess[cur].contains(next)) {
                tmp--;
            }
            if (guess[next].contains(cur)) {
                tmp++;
            }
            dfs2(next, cur, tmp);
        }
    }
}
