package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/25 23:43
 */
public class LeetCode1361_bfs {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if (root == -1) {
            return false;
        }

        return validateByBFS(n, leftChild, rightChild, root);
    }


    boolean validateByBFS(int n, int[] leftChild, int[] rightChild, int root) {
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        boolean[] visited = new boolean[n];
        while (!q.isEmpty()) {
            int node = q.remove();
            if (visited[node]) {
                return false;
            }
            visited[node] = true;
            if (leftChild[node] != -1) {
                q.add(leftChild[node]);
            }
            if (rightChild[node] != -1) {
                q.add(rightChild[node]);
            }
        }
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    int findRoot(int n, int[] left, int[] right) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }

        for (int ch : left) {
            set.remove(ch);
        }
        for (int ch : right) {
            set.remove(ch);
        }
        return set.size() == 1 ? set.iterator().next() : -1;
    }
}
