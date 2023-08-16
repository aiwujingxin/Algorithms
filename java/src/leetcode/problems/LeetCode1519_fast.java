package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/13 14:25
 */
public class LeetCode1519_fast {

    public char[] labels;
    public List<Integer>[] edge;
    public int[] answer;
    public int[] count;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.labels = labels.toCharArray();
        edge = new ArrayList[n];
        for (int i = 0; i < n; i += 1) {
            edge[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            edge[e[0]].add(e[1]);
            edge[e[1]].add(e[0]);
        }

        answer = new int[n];
        count = new int[26];
        dfs(0, -1);
        return answer;
    }

    public void dfs(int u, int p) {
        int cur = count[labels[u] - 'a']++;
        for (int v : edge[u]) {
            if (v == p) {
                continue;
            }
            dfs(v, u);
        }
        answer[u] = count[labels[u] - 'a'] - cur;
    }
}
