package leetCode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/18 16:56
 */
public class LeetCode827_UnionFind {

    UnionFind uf;

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        uf = new UnionFind(n * n);
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int curr = i * n + j;

                uf.add(curr);
                for (int neigh : neighbors(grid, i, j)) {
                    uf.union(curr, neigh);
                }

                int p = uf.find(curr);
                ans = Math.max(ans, uf.size[p]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }

                Set<Integer> neighParents = new HashSet<>();
                for (int neigh : neighbors(grid, i, j)) {
                    neighParents.add(uf.find(neigh));
                }


                int size = 1;
                for (int s : neighParents) {
                    size += uf.size[s];
                }
                ans = Math.max(ans, size);
            }
        }
        return ans;
    }

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    List<Integer> neighbors(int[][] grid, int i, int j) {
        int n = grid.length;
        List<Integer> list = new ArrayList<>();
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || y < 0 || x >= n || y >= n || !uf.contains(x * n + y)) continue;
            list.add(x * n + y);
        }
        return list;
    }

    static class UnionFind {
        int[] parent, size;

        UnionFind(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);
            size = new int[n];
        }

        boolean contains(int u) {
            return parent[u] >= 0;
        }

        void add(int u) {
            if (contains(u)) return;
            parent[u] = u;
            size[u] = 1;
        }

        int find(int u) {
            if (parent[u] == u) return u;
            parent[u] = find(parent[u]); //path compression
            return parent[u];
        }

        boolean union(int u, int v) {
            int pu = find(u), pv = find(v);
            if (pu == pv) return false;
            if (size[pu] <= size[pv]) { //merge smaller component
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
            return true;
        }
    }
}
