package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/2 21:41
 */
public class LeetCode2368 {

    List<Integer>[] list;
    HashSet<Integer> set;
    HashSet<Integer> vistied;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        set = new HashSet<>();
        vistied = new HashSet<>();
        for (int r : restricted) {
            set.add(r);
        }
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        dfs(0);
        vistied.add(0);
        return vistied.size();
    }

    private void dfs(int i) {
        for (int a : list[i]) {
            if (set.contains(a) || vistied.contains(a)) {
                continue;
            }
            vistied.add(a);
            dfs(a);
        }
    }
}
