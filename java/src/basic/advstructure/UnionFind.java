package basic.advstructure;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/22 22:16
 * <a href="https://algs4.cs.princeton.edu/15uf/">UF</a>
 * <a href="https://github.com/AhmadElsagheer/Competitive-programming-library/blob/master/data_structures/UnionFind.java">额外信息</a>
 */
public class UnionFind {

    private final int[] parent;  // parent[i] = parent of i
    private int count;     // number of components

    public UnionFind(int n) {
        parent = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean connected(int p, int q) {
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

    /**
     * @author wujingxinit@outlook.com
     * @date 2023/5/22 21:55
     * @see leetcode.problems.LeetCode208
     */
    public static class Trie {
    }
}
