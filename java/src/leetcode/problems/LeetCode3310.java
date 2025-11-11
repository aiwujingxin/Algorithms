package leetcode.problems;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 10/24/25 14:40
 */
public class LeetCode3310 {

    List<Integer>[] graph;
    List<Integer>[] rgraph;

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        graph = new List[n];
        rgraph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            rgraph[i] = new ArrayList<>();
        }
        for (int[] in : invocations) {
            graph[in[0]].add(in[1]);
            rgraph[in[1]].add(in[0]);
        }
        HashSet<Integer> badNode = new HashSet<>();
        dfs(graph, k, badNode, new HashSet<>());

        HashSet<Integer> parent = new HashSet<>();
        for (int bad : badNode) {
            HashSet<Integer> pa = new HashSet<>();
            dfs(rgraph, bad, pa, parent);
            parent.addAll(pa);
        }
        boolean res = hasOtherCall(parent, badNode);

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!res && badNode.contains(i))
                continue;
            ans.add(i);
        }
        return ans;
    }

    private boolean hasOtherCall(HashSet<Integer> path, HashSet<Integer> badSet) {
        for (int pa : path) {
            if (!badSet.contains(pa)) {
                return true;
            }
        }
        return false;
    }

    public boolean dfs(List<Integer>[] graph, int i, HashSet<Integer> path, HashSet<Integer> parent) {
        path.add(i);
        for (int ch : graph[i]) {
            if (path.contains(ch) || parent.contains(ch)) {
                continue;
            }
            path.add(ch);
            dfs(graph, ch, path, parent);
        }
        return true;
    }
}
