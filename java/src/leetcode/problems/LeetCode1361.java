package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/25 23:36
 */
public class LeetCode1361 {

    //https://leetcode.com/problems/validate-binary-tree-nodes/discuss/1814452/Java-Simple-Solution-Using-DFS

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        // build graph
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        // 判断孩子个数
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
        for (int j : indegree) {
            // root 节点
            if (j == 0) {
                components++;
                if (components > 1) {
                    return false;
                }
            }
            if (j > 1) {
                return false;
            }
        }

        // 判断环
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
