package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/30 15:02
 */
public class LeetCode1042 {

    List<Integer>[] graph;
    int[] ans;

    public int[] gardenNoAdj(int n, int[][] paths) {
        graph = new List[n + 1];
        ans = new int[n];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] p : paths) {
            graph[p[0]].add(p[1]);
            graph[p[1]].add(p[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (ans[i - 1] == 0) {
                bfs(i);
            }
            ans[i - 1] = cal(ans[i - 1]) + 1;
        }
        return ans;
    }

    public void bfs(int cur) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(cur);
        set.add(cur);
        while (!q.isEmpty()) {
            int node = q.poll();
            int index = cal(ans[node - 1]);
            for (int ch : graph[node]) {
                ans[ch - 1] |= 1 << index;
                if (!set.contains(ch)) {
                    q.add(ch);
                    set.add(ch);
                }
            }
        }
    }

    public int cal(int num) {
        return Integer.numberOfTrailingZeros(~num);
    }
}
