package leetCode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/25 23:19
 */
public class LeetCode1361_uf {

    public boolean validateBinaryTreeNodes(int n, int[] left, int[] right) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; //every node is parent of itselt
        }
        for (int i = 0; i < n; i++) {
            int l = left[i];
            int r = right[i];
            int x = find(parent, i);
            if (l != -1) {
                int root = find(parent, l);
                if (root == x) {
                    return false; // left node already has a parent
                }
                union(parent, i, l);
            }
            if (r != -1) {
                int root = find(parent, r);
                if (root == x) {
                    return false; // right node already has a parent
                }
                union(parent, i, r);
            }
        }
        int root = find(parent, 0);
        for (int i = 1; i < n; i++) {
            int rootI = find(parent, i);
            if (root != rootI) {
                return false;
            }
            //Root of all node should be same - note the path compression

        }
        return true;
    }

    void union(int[] parent, int x, int y) {
        parent[y] = x;
    }

    int find(int[] parent, int x) {
        if (parent[x] != x) {
            //Path compression for faster parent search - this makes Tree root as parent of all nodes
            parent[x] = find(parent, parent[x]);
            return parent[x];
        }
        return x;
    }
}
