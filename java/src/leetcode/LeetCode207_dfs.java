package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/28 16:49
 */
public class LeetCode207_dfs {

    Map<Integer, List<Integer>> map = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] cp : prerequisites) {
            map.get(cp[1]).add(cp[0]);
        }
        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(flags, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[] flags, int i) {
        if (flags[i] == 1) {
            return true;
        }
        if (flags[i] == -1) {
            return false;
        }
        flags[i] = 1;
        for (Integer j : map.get(i)) {
            if (dfs(flags, j)) {
                return true;
            }
        }
        flags[i] = -1;
        return false;
    }
}
