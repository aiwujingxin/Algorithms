package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/19 17:38
 * 换根DP
 */
public class LeetCode1245 {

    int ans = 0;

    Map<Integer, List<Integer>> map = new HashMap<>();

    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1);
        return ans;
    }

    public int dfs(int x, int fa) {
        int maxLen = 0;
        for (int a : map.get(x)) {
            if (a == fa) {
                continue;
            }
            int mx = dfs(a, x);
            // merge 子节点结果
            ans = Math.max(ans, mx + maxLen);
            // 以x为根时,最大的直径
            maxLen = Math.max(mx, maxLen);
        }
        // 返回给父节点
        return maxLen + 1;
    }
}
