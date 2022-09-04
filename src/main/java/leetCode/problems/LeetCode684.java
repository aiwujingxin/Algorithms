package leetCode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/24 15:36
 */
public class LeetCode684 {


    //树可以看成是一个连通且 无环 的 无向 图。
    public int[] findRedundantConnection(int[][] edges) {

        if (edges == null || edges.length == 0) {
            return new int[]{};
        }
        int n = edges.length + 1;
        // build graph
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int[] res = new int[]{};
        for (int[] c : edges) {
            int p1 = findParent(parent, c[0]);
            int p2 = findParent(parent, c[1]);
            if (p1 != p2) {
                parent[p1] = p2; // Union 2 component
            } else {
                return c;
            }
        }
        return res;
    }


    private int findParent(int[] parent, int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = findParent(parent, parent[i]); // Path compression
    }
}
