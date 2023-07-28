package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/16 15:55
 */
public class LeetCode323 {

    int[] parent;

    int count;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        count = n - 1;

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            if (union(x, y)) {
                count--;
            }
        }
        return count;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            parent[px] = py;
            return true;
        }
        return false;
    }
}
