package basic.datastructure.advance;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/22 22:16
 * @link <a href="https://algs4.cs.princeton.edu/15uf/">UF</a>
 * @link <a href="https://github.com/AhmadElsagheer/Competitive-programming-library/blob/master/data_structures/UnionFind.java"></a>
 */
public class UnionFind {

    private final int[] parent; // parent[i] = parent of i
    private int count; // number of components

    public UnionFind(int n) {
        this.parent = new int[n];
        this.count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public UnionFind(int n, int count) {
        parent = new int[n];
        this.count = count;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        count++;
    }
}
