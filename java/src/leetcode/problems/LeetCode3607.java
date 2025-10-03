package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 9/10/25 13:00
 */
public class LeetCode3607 {

    static class Node {
        int node;
        int status;

        public Node(int node, int s) {
            this.node = node;
            this.status = s;
        }
    }

    HashMap<Integer, Node> nodeMap; // node -> Node
    HashMap<Integer, Integer> groupMap; // node -> group
    HashMap<Integer, TreeSet<Node>> groupTree; // group -> tree

    HashSet<Integer> set;
    List<Integer>[] graph;
    int group = 0;

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        nodeMap = new HashMap<>();
        set = new HashSet<>();
        groupTree = new HashMap<>();
        groupMap = new HashMap<>();
        graph = new List[c + 1];
        for (int i = 1; i <= c; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] con : connections) {
            graph[con[0]].add(con[1]);
            graph[con[1]].add(con[0]);
        }
        for (int i = 1; i <= c; i++) {
            nodeMap.put(i, new Node(i, 0));
        }
        for (int i = 1; i <= c; i++) {
            if (set.contains(i)) continue;
            set.add(i);
            groupMap.put(i, group);
            TreeSet<Node> s = groupTree.getOrDefault(group, new TreeSet<>((o1, o2) -> {
                if (o1.status == o2.status) {
                    return o1.node - o2.node;
                }
                return o1.status - o2.status;
            }));
            s.add(nodeMap.get(i));
            groupTree.put(group, s);
            dfs(i);
            group++;
        }

        List<Integer> list = new ArrayList<>();
        for (int[] q : queries) {
            int group = groupMap.get(q[1]);
            TreeSet<Node> s = groupTree.get(group);
            if (q[0] == 1) {
                if (nodeMap.get(q[1]).status == 0) {
                    list.add(q[1]);
                } else {
                    Node first = s.first();
                    if (first.status == 1) {
                        list.add(-1);
                    } else {
                        list.add(first.node);
                    }
                }
            }
            if (q[0] == 2) {
                Node d = nodeMap.get(q[1]);
                s.remove(d);
                Node add = new Node(q[1], 1);
                nodeMap.put(q[1], add);
                s.add(add);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public void dfs(int node) {
        for (int ch : graph[node]) {
            if (set.contains(ch)) continue;
            set.add(ch);
            groupMap.put(ch, group);
            TreeSet<Node> s = groupTree.get(group);
            s.add(nodeMap.get(ch));
            dfs(ch);
        }
    }
}
