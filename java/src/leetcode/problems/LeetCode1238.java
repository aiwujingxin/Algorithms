package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 7/5/26 16:07
 */
public class LeetCode1238 {

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> result = new ArrayList<>();
        int total = 1 << n;
        boolean[] visited = new boolean[total];
        result.add(start);
        visited[start] = true;
        backtrack(n, start, result, visited, total);
        return result;
    }

    private boolean backtrack(int n, int current, List<Integer> result, boolean[] visited, int total) {
        if (result.size() == total) {
            return Integer.bitCount(result.getFirst() ^ result.getLast()) == 1;
        }
        for (int i = 0; i < n; i++) {
            int next = current ^ (1 << i);
            if (!visited[next]) {
                visited[next] = true;
                result.add(next);
                if (backtrack(n, next, result, visited, total)) {
                    return true;
                }
                result.removeLast();
                visited[next] = false;
            }
        }
        return false;
    }
}
