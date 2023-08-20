package leetcode;

import java.util.HashSet;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/18 17:32
 */
public class LeetCode827_UF2 {

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        UnionFind uf = new UnionFind(n * n);

        boolean hasZero = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                    continue;
                }

                // union all nodes with value 1, no need to check four directions. just right and down.
                if (i + 1 < n && grid[i + 1][j] == 1) {
                    uf.union(i * n + j, (i + 1) * n + j);
                }

                if (j + 1 < n && grid[i][j + 1] == 1) {
                    uf.union(i * n + j, i * n + (j + 1));
                }
            }
        }

        if (!hasZero) {
            return n * n;
        }

        int maxIslandSize = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }

                HashSet<Integer> set = new HashSet<>();
                int islandSize = 1;

                for (int[] direction : directions) {
                    int newX = i + direction[0];
                    int newY = j + direction[1];

                    if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                        int newRoot = uf.find(newX * n + newY);
                        if (!set.contains(newRoot)) {
                            islandSize += uf.getClusterSize(newRoot);
                            set.add(newRoot);
                        }
                    }
                }

                maxIslandSize = Math.max(maxIslandSize, islandSize);
            }
        }

        return maxIslandSize;
    }

    static class UnionFind {
        int[] parents;
        int[] rank;
        int[] clusterSize;

        public UnionFind(int size) {
            parents = new int[size];
            rank = new int[size];
            clusterSize = new int[size];

            for (int i = 0; i < size; i++) {
                rank[i] = 1;
                parents[i] = i;
                clusterSize[i] = 1;
            }
        }

        public int find(int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            int rankX = rank[rootX];
            int rankY = rank[rootY];

            if (rankX > rankY) {
                parents[rootY] = rootX;
                clusterSize[rootX] += clusterSize[rootY];
            } else if (rankY > rankX) {
                parents[rootX] = rootY;
                clusterSize[rootY] += clusterSize[rootX];
            } else {
                parents[rootY] = rootX;
                rank[rootX]++;
                clusterSize[rootX] += clusterSize[rootY];
            }
        }

        public int getClusterSize(int x) {
            return clusterSize[x];
        }
    }
}
