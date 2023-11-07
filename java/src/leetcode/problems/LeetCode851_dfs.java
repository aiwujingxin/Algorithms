package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/1 15:01
 */
public class LeetCode851_dfs {

    //https://leetcode.cn/problems/loud-and-rich/solutions/1158560/javashen-du-you-xian-sou-su-sou-suo-ji-l-rqgh/?envType=daily-question&envId=2023-09-01
    int[] ans;
    int[] quiet;
    Map<Integer, List<Integer>> map = new HashMap<>();
    boolean[] v;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        this.quiet = quiet;
        ans = new int[n];
        v = new boolean[n];

        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        // 反向建图
        int[] degree = new int[n];
        for (int[] r : richer) {
            map.get(r[1]).add(r[0]);
            degree[r[0]]++;
        }
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                dfs(i);
            }
        }
        return ans;
    }

    private int dfs(int u) {
        if (v[u]) {//如果已经求过了
            return ans[u];
        }
        int min = u;//当前结点的安静度
        for (int next : map.get(u)) {
            int t = dfs(next);//相邻结点子树下最安静的
            if (quiet[t] < quiet[min]) {
                min = t;
            }
        }
        v[u] = true;
        ans[u] = min;
        return min;
    }
}
