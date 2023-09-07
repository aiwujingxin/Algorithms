package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/7 23:48
 */
public class LeetCode2359_WA {

    List<Integer>[] graph;

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[i].add(edges[i]);
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(node1, list1);
        dfs(node2, list2);
        int ans = 0;
        System.out.println(list1);
        System.out.println(list2);
        return ans;
    }

    private void dfs(int node, List<Integer> list) {
        if (node == -1) {
            return;
        }
        list.add(node);
        for (int next : graph[node]) {
            dfs(next, list);
        }
    }
}
