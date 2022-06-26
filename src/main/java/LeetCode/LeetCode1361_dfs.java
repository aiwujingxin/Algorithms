package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/25 23:36
 */
public class LeetCode1361_dfs {

    //https://leetcode.com/problems/validate-binary-tree-nodes/discuss/1814452/Java-Simple-Solution-Using-DFS

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        // build graph
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                graph.get(i).add(leftChild[i]);
                indegree[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                graph.get(i).add(rightChild[i]);
                indegree[rightChild[i]]++;
            }
            if (graph.get(i).size() > 2) {
                return false;
            }
        }

        int components = 0;

        // 判断入度
        for (int i : indegree) {
            // root 节点
            if (i == 0) {
                components++;
                if (components > 1) {
                    return false;
                }

            }
            if (i > 1) {
                return false;
            }
        }

        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (isCyclic(graph, i, visited)) {
                    return false;
                }

            }
        }
        return true;
    }

    // 判断有无环 todo 1 ？ 2 ？
    public boolean isCyclic(HashMap<Integer, List<Integer>> graph, int src, int[] visited) {
        if (visited[src] == 2) {
            return true;
        }

        visited[src] = 2;

        for (int i : graph.get(src)) {
            if (visited[i] != 1) {
                if (isCyclic(graph, i, visited)) {
                    return true;
                }
            }
        }

        visited[src] = 1;

        return false;
    }
}
