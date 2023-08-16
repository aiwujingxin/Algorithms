package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/25 23:43
 */
public class LeetCode1361_dfs_v2 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if (root == -1) {
            return false;
        }

        return validateByDFS(n, leftChild, rightChild, root);
    }

    boolean validateByDFS(int n, int[] leftChild, int[] rightChild, int root) {
        boolean[] visited = new boolean[n];
        if (!validateByDFS(n, leftChild, rightChild, root, visited)) {
            return false;
        }

        for (boolean v : visited) {
            if (!v) {
                return false;
            }

        }
        return true;

    }

    boolean validateByDFS(int n, int[] leftChild, int[] rightChild, int root, boolean[] visited) {
        if (root == -1) {
            return true;
        }

        if (visited[root]) {
            return false;
        }
        visited[root] = true;
        return validateByDFS(n, leftChild, rightChild, leftChild[root], visited)
                && validateByDFS(n, leftChild, rightChild, rightChild[root], visited);

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
