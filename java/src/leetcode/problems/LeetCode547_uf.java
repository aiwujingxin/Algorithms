package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/16 20:28
 */
public class LeetCode547_uf {

    //https://leetcode.com/problems/number-of-provinces/discuss/2429554/JAVA-or-Faster-than-99.98-or-Quick-Find-and-Union
    private int[] root;

    public int findCircleNum(int[][] isConnected) {
        //init
        int n = isConnected.length;
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (root[i] == i) {
                count++;
            }
        }
        return count;
    }

    public int find(int i) {
        return root[i];
    }

    public void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX != rootY) {
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootY) {
                    root[i] = rootX;
                }
            }
        }
    }
}
