package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/22 18:14
 * @see LeetCode337
 */
public class LeetCode2378 {

    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashMap<Integer, Integer> wightMap = new HashMap<>();

    public long maxScore(int[][] edges) {
        for (int i = 1; i < edges.length; i++) {
            map.putIfAbsent(edges[i][0], new ArrayList<>());
            map.get(edges[i][0]).add(i);
            wightMap.put(i, edges[i][1]);
        }
        wightMap.put(0, 0);
        long[] res = dfs(0);
        return res[0];
    }

    private long[] dfs(int node) {
        if (map.get(node) == null) {
            return new long[]{0, 0};
        }
        long sum = 0;
        long diff = 0;
        for (int j = 0; j < map.get(node).size(); j++) {
            long[] child = dfs(map.get(node).get(j));
            // child[0]  选
            // child[1] 不选
            sum += child[0]; //不选node, 则累加选孩子的最优结果
            diff = Math.max(diff, (wightMap.get(map.get(node).get(j)) + child[1] - child[0]));
        }

        /*
         * Example:
         * weight(from.child1) + dp[child1][1] + dp[child2][0] + dp[child3][0]
         * weight(from.child2) + dp[child2][1] + dp[child1][0] + dp[child3][0]
         * weight(from.child3) + dp[child3][1] + dp[child1][0] + dp[child2][0]
         *
         * weight(from.child1) + dp[child1][1] + dp[child2][0] + dp[child3][0]
         * = Max(weight(from.child1) + dp[child1][1] - dp[child1][1] + (dp[child1][0] + dp[child2][0] + dp[child3][0])
         *       weight(from.child2) + dp[child2][1] - dp[child2][1] + (dp[child1][0] + dp[child2][0] + dp[child3][0])
         *       weight(from.child3) + dp[child3][1] - dp[child3][1] + (dp[child1][0] + dp[child2][0] + dp[child3][0]))
         */
        System.out.println("sum " + sum + " diff " + diff);

        //选择一个叶子节点的未选中最大值 + 节点到该叶子节点的边的值 + 其他叶子节点的被选中和未选中的最大值
        return new long[]{diff + sum, sum};
    }
}
