package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/23 22:11
 */
public class LeetCode1319_uf1 {

    public int makeConnected(int n, int[][] connections) {
        // To connect all nodes need at least n-1 edges
        if (connections.length < n - 1) {
            return -1;
        }
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int components = n;
        for (int[] c : connections) {
            int p1 = findParent(parent, c[0]);
            int p2 = findParent(parent, c[1]);
            if (p1 != p2) {
                parent[p1] = p2; // Union 2 component
                components--;
            }
        }
        return components - 1; // Need (components-1) cables to connect components together
    }

    private int findParent(int[] parent, int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i; // Without Path Compression
    }
}
