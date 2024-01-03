package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/29 17:38
 */
public class LeetCode947 {

    public int removeStones(int[][] stones) {
        Set<int[]> visited = new HashSet<>();
        int numOfIslands = 0;
        for (int[] s1 : stones) {
            if (!visited.contains(s1)) {
                dfs(s1, visited, stones);
                numOfIslands++;
            }
        }
        return stones.length - numOfIslands;
    }

    private void dfs(int[] s1, Set<int[]> visited, int[][] stones) {
        visited.add(s1);
        for (int[] s2 : stones) {
            if (!visited.contains(s2)) {
                if (s1[0] == s2[0] || s1[1] == s2[1]) {
                    dfs(s2, visited, stones);
                }
            }
        }
    }
}
