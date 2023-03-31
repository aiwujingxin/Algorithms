package leetcode.lists.hot200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/15 21:46
 */
public class LeetCode305 {

    private final static int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind unionFind = new UnionFind(m * n);
        boolean[] visited = new boolean[m * n];

        List<Integer> res = new ArrayList<>();
        for (int[] position : positions) {
            int currX = position[0];
            int currY = position[1];

            // 二维降一维
            int index = currX * n + currY;
            if (!visited[index]) {
                // 把水变成陆地，连通分量个数加 1
                unionFind.addCount();
                visited[index] = true;
                for (int[] direction : DIRECTIONS) {
                    int newX = currX + direction[0];
                    int newY = currY + direction[1];
                    int newIndex = newX * n + newY;
                    // 下面这三个条件很重要
                    if (inArea(newX, newY, m, n) && visited[newIndex] && !unionFind.isConnected(index, newIndex)) {
                        unionFind.union(index, newIndex);
                    }
                }
            }
            res.add(unionFind.getCount());
        }
        return res;
    }

    public boolean inArea(int x, int y, int m, int n) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }

    private class UnionFind {

        private final int[] parent;
        private int count;

        public int getCount() {
            return count;
        }

        public void addCount() {
            count++;
        }

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            this.count = 0;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            count--;
        }
    }
}
