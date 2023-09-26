package basic.datastructure.advance;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/22 22:16
 * @link <a href="https://algs4.cs.princeton.edu/15uf/">UF</a>
 * @link <a href="https://github.com/AhmadElsagheer/Competitive-programming-library/blob/master/data_structures/UnionFind.java"></a>
 */
public class UnionFind {

    private final int[] parent, size, rank; // parent[i] = parent of i
    private int count; // number of components

    public UnionFind(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        this.rank = new int[n];
        this.count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            rank[i] = 1;
        }
    }

    public UnionFind(int n, int count) {
        this.parent = new int[n];
        this.size = new int[n];
        this.rank = new int[n];
        this.count = count;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            rank[i] = 1;
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

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return false;
        }
        parent[rootX] = rootY;
        size[rootY] += size[rootX];
        count--;
        return true;
    }

    public void unionByRank(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
            rank[rootX] += 1;
        }
        count--;
    }

    public void unionBySize(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) {
            return;
        } else if (size[xr] < size[yr]) {
            parent[xr] = yr;
            size[yr] += size[xr];
        } else {
            parent[yr] = xr;
            size[xr] += size[yr];
        }
        count--;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        count++;
    }

    public int sizeOfSet(int i) {
        return this.size[find(i)];
    }
}
