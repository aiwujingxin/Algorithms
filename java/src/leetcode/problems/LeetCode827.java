package leetcode.problems;

import knowledge.advstructure.UnionFind;

import java.util.HashSet;

//https://leetcode.com/problems/making-a-large-island/solutions/3787791/clean-java-solution-union-find-concise-solution-easy-to-understand/

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/18 16:56
 */
public class LeetCode827 {

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        UnionFind unionFind = new UnionFind(n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;
                int[][] drc = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                for (int[] d : drc) {
                    int r = d[0] + i, c = d[1] + j;
                    if (0 <= r && r < n && 0 <= c && c < n && grid[r][c] == 1) {
                        unionFind.unionBySize(i * n + j, r * n + c);
                    }
                }
            }
        }
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxSize = Math.max(maxSize, unionFind.sizeOfSet(i * n + j));
                    continue;
                }
                int[][] drc = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                HashSet<Integer> visited = new HashSet<>();
                int currSize = 0;
                for (int[] d : drc) {
                    int r = d[0] + i, c = d[1] + j;
                    if (0 <= r && r < n && 0 <= c && c < n && grid[r][c] == 1 &&
                            !visited.contains(unionFind.find(r * n + c))) {
                        visited.add(unionFind.find(r * n + c));
                        currSize += unionFind.sizeOfSet(r * n + c);
                    }
                }
                maxSize = Math.max(maxSize, currSize + 1);
            }
        }
        return maxSize;
    }
}
